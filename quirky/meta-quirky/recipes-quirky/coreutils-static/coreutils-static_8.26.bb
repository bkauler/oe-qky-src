SUMMARY = "The basic file, shell and text manipulation utilities"
DESCRIPTION = "The GNU Core Utilities provide the basic file, shell and text \
manipulation utilities. These are the core utilities which are expected to exist on \
every system."
HOMEPAGE = "http://www.gnu.org/software/coreutils/"
BUGTRACKER = "http://debbugs.gnu.org/coreutils"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504\
                    file://src/ls.c;beginline=5;endline=16;md5=38b79785ca88537b75871782a2a3c6b8"
DEPENDS = "acl attr"
#DEPENDS_class-native = ""

inherit autotools texinfo

SRC_URI = "${GNU_MIRROR}/coreutils/coreutils-${PV}.tar.xz;name=tarball \
           http://distfiles.gentoo.org/distfiles/coreutils-${PV}-man.tar.xz;name=manpages \
           file://man-decouple-manpages-from-build.patch \
           file://remove-usr-local-lib-from-m4.patch \
           file://fix-selinux-flask.patch \
           file://0001-Unset-need_charset_alias-when-building-for-musl.patch \
           file://0001-uname-report-processor-and-hardware-correctly.patch \
           file://disable-ls-output-quoting.patch \
           file://0001-local.mk-fix-cross-compiling-problem.patch \
          "

SRC_URI[tarball.md5sum] = "d5aa2072f662d4118b9f4c63b94601a6"
SRC_URI[tarball.sha256sum] = "155e94d748f8e2bc327c66e0cbebdb8d6ab265d2f37c3c928f7bf6c3beba9a8e"
SRC_URI[manpages.md5sum] = "b58107f532f7beffcb2f38e2ac1f2da3"
SRC_URI[manpages.sha256sum] = "9324ec412ffca3b0431e6299720c33ac98e749e430f72a7c6e65f3635c86aa29"

S = "${WORKDIR}/coreutils-${PV}"

LDFLAGS += " -static"

EXTRA_OECONF = " --without-gmp --without-selinux --with-openssl=no --disable-nls \
     --enable-single-binary=symlinks --disable-libcap --disable-libsmack \
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
