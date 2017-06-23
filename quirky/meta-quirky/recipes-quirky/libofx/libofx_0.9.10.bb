# Recipe created by recipetool
# recipetool create -o libofx_0.9.10.bb http://archive.ubuntu.com/ubuntu/pool/universe/libo/libofx/libofx_0.9.10.orig.tar.gz

SUMMARY = "The LibOFX library is designed to allow applications to very easily support OFX command responses"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=cbbd794e2a0a289b9dfcc9f513d1996e"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/libo/libofx/libofx_${PV}.orig.tar.gz"
SRC_URI[md5sum] = "adfa83a08d76b047f89a82d5b484f79b"
SRC_URI[sha256sum] = "54e26a4944ef2785087cfd8ed8f187ab9d397d9b92b5acc199dd7d5d095cf695"
S = "${WORKDIR}/libofx-${PV}"

DEPENDS = "opensp curl libxml2"

inherit autotools pkgconfig

SROOT = "${WORKDIR}/recipe-sysroot"

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-html-docs --disable-doxygen --with-opensp-includes=${SROOT}/usr/include/OpenSP --with-opensp-libs=${SROOT}/usr/lib"


HOMEPAGE = "http://libofx.sourceforge.net/"
