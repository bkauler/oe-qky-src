SUMMARY = "The basic file, shell and text manipulation utilities"
DESCRIPTION = "The GNU Core Utilities provide the basic file, shell and text \
manipulation utilities. These are the core utilities which are expected to exist on \
every system."
HOMEPAGE = "http://www.gnu.org/software/coreutils/"
BUGTRACKER = "http://debbugs.gnu.org/coreutils"

PR = "r0"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504\
                    file://src/ls.c;beginline=1;endline=15;md5=1c3f9411e1842a062ce5ce9210beee0e"

DEPENDS = "acl attr libcap"
#DEPENDS_class-native = ""

inherit autotools texinfo

SRC_URI = "${GNU_MIRROR}/coreutils/coreutils-${PV}.tar.xz \
           file://remove-usr-local-lib-from-m4.patch \
           file://fix-selinux-flask.patch \
           file://0001-Unset-need_charset_alias-when-building-for-musl.patch \
           file://0001-uname-report-processor-and-hardware-correctly.patch \
           file://disable-ls-output-quoting.patch \
           file://0001-local.mk-fix-cross-compiling-problem.patch \
          "
SRC_URI[md5sum] = "960cfe75a42c9907c71439f8eb436303"
SRC_URI[sha256sum] = "92d0fa1c311cacefa89853bdb53c62f4110cdfda3820346b59cbd098f40f955e"

S = "${WORKDIR}/coreutils-${PV}"

LDFLAGS += " -static"

EXTRA_OECONF = " --without-gmp --without-selinux --with-openssl=no --disable-nls \
     --enable-single-binary=symlinks --enable-libcap --disable-libsmack \
     --with-included-regex --enable-acl --enable-xattr"

# BK, interesting, this one replaced the above
#EXTRA_OECONF_class-target = "--enable-install-program=arch --libexecdir=${libdir}"

# Let aclocal use the relative path for the m4 file rather than the
# absolute since coreutils has a lot of m4 files, otherwise there might
# be an "Argument list too long" error when it is built in a long/deep
# directory.
acpaths = "-I ./m4"

# Deal with a separate builddir failure if src doesn't exist when creating version.c/version.h
do_compile_prepend () {
	mkdir -p ${B}/src
}

#inherit update-alternatives
