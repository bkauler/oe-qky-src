# Recipe created by recipetool
# recipetool create -o dictd-client_1.12.1.bb https://downloads.sourceforge.net/project/dict/dictd/dictd-1.12.1/dictd-1.12.1.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "https://downloads.sourceforge.net/project/dict/dictd/dictd-${PV}/dictd-${PV}.tar.gz"
SRC_URI[md5sum] = "62696491174c22079f664830d07c0623"
SRC_URI[sha256sum] = "a237f6ecdc854ab10de5145ed42eaa2d9b6d51ffdc495f7daee59b05cc363656"

S = "${WORKDIR}/dictd-${PV}"

# NOTE: the following prog dependencies are unknown, ignoring: nroff col cat troff expand gnroff groff
# NOTE: the following library dependencies are unknown, ignoring: dbi maa Judy
DEPENDS = "bison-native flex-native libmaa zlib"

inherit autotools pkgconfig

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-plugin"

SROOT = "${WORKDIR}/recipe-sysroot"

do_compile_prepend() {
    #creates a broken LIBTOOL variable in Makefile...
    LTNAME="$(find ${SROOT}/usr/bin/crossscripts -maxdepth 1 -name '*-libtool')"
    #ex: x86_64-oe-linux-libtool
    sed -i -e "s%^LIBTOOL=.*%LIBTOOL= ${LTNAME}%" ${B}/Makefile
}

do_compile() {
    #only compile dict client...
    oe_runmake dict
}

do_install() {
    #only install client...
    oe_runmake install.dict DESTDIR=${D}
}

HOMEPAGE = ""
SUMMARY = ""
