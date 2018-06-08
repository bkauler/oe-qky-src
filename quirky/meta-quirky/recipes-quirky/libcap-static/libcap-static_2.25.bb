SUMMARY = "Library for getting/setting POSIX.1e capabilities"
HOMEPAGE = "http://sites.google.com/site/fullycapable/"

# no specific GPL version required
LICENSE = "BSD | GPLv2"
LIC_FILES_CHKSUM = "file://License;md5=3f84fd6f29d453a56514cb7e4ead25f1"

DEPENDS = "hostperl-runtime-native gperf-native"

# BK libcap-cap_sys_mount is my patch, originally from nicolas.
# BK ldlibs.patch onwards are from ubuntu: 
#    http://archive.ubuntu.com/ubuntu/pool/main/libc/libcap2/libcap2_2.25-1.2.debian.tar.xz
#    leave these out: ldlibs.patch Hide-private-symbols.patch Filter-out-PIE-flags-when-building-shared-objects.patch
#    also these: Don-t-hardcode-build-flags.patch
SRC_URI = "${KERNELORG_MIRROR}/linux/libs/security/linux-privs/${BPN}2/libcap-${PV}.tar.xz \
           file://0001-ensure-the-XATTR_NAME_CAPS-is-defined-when-it-is-use.patch \
           file://libcap-cap_sys_mount.patch \
           file://setcap-error-message.patch \
           file://Syntax-fixes-for-man-pages.patch \
           file://Avoid-sys-capability.h-on-build-architecture.patch \
           file://Spelling-fixes.patch"
SRC_URI[md5sum] = "6666b839e5d46c2ad33fc8aa2ceb5f77"
SRC_URI[sha256sum] = "693c8ac51e983ee678205571ef272439d83afe62dd8e424ea14ad9790bc35162"

# BK
S = "${WORKDIR}/libcap-${PV}"

inherit lib_package

# BK 20180529 get an error:
# crt1.c undefined reference to main
# https://forums.freebsd.org/threads/problem-linking-with-libc.52488/


# do NOT pass target cflags to host compilations
#
do_configure() {
	# libcap uses := for compilers, fortunately, it gives us a hint
	# on what should be replaced with ?=
	sed -e 's,:=,?=,g' -i Make.Rules
	sed -e 's,^BUILD_CFLAGS ?= $(.*CFLAGS),BUILD_CFLAGS := $(BUILD_CFLAGS),' -i Make.Rules

	# disable gperf detection
	sed -e '/shell gperf/cifeq (,yes)' -i libcap/Makefile

	# BK 20180529 want static executables
	sed -i -e 's%shared%static -nostartfiles%' Make.Rules
	#sed -i -e 's%shared%static%' Make.Rules
	sed -i -e 's%^DYNAMIC .*%DYNAMIC = "no"%' Make.Rules
	sed -i -e 's%^LDFLAGS .*%LDFLAGS += -static%' progs/Makefile
	sed -i -e 's%^LDFLAGS .*%LDFLAGS += -static%' Makefile
}

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pam', d)}"
PACKAGECONFIG_class-native ??= ""

PACKAGECONFIG[pam] = "PAM_CAP=yes,PAM_CAP=no,libpam"

EXTRA_OEMAKE = " \
  INDENT=  \
  lib=${@os.path.basename('${libdir}')} \
  RAISE_SETFCAP=no \
  DYNAMIC=no \
"

EXTRA_OEMAKE_append_class-target = " SYSTEM_HEADERS=${STAGING_INCDIR}"

# these are present in the libcap defaults, so include in our CFLAGS too
CFLAGS += "-D_LARGEFILE64_SOURCE -D_FILE_OFFSET_BITS=64"

do_compile() {
	oe_runmake ${PACKAGECONFIG_CONFARGS}
}

# warning: -s (strip) does not work for aarch64 target...
do_install() {
	#oe_runmake install \
	#	${PACKAGECONFIG_CONFARGS} \
	#	DESTDIR="${D}" \
	#	prefix="${prefix}" \
	#	SBINDIR="${sbindir}"
	
	# BK 20180529 only want 'capsh' utility...
	install -d ${D}/usr/sbin
	install -m 755 progs/capsh ${D}/usr/sbin
}

#do_install_append() {
#	# Move the library to base_libdir
#	install -d ${D}${base_libdir}
#	if [ ! ${D}${libdir} -ef ${D}${base_libdir} ]; then
#		mv ${D}${libdir}/libcap* ${D}${base_libdir}
#                if [ -d ${D}${libdir}/security ]; then
#			mv ${D}${libdir}/security ${D}${base_libdir}
#		fi
#	fi
#}

#FILES_${PN}-dev += "${base_libdir}/*.so"

## pam files
#FILES_${PN} += "${base_libdir}/security/*.so"

#BBCLASSEXTEND = "native nativesdk"
