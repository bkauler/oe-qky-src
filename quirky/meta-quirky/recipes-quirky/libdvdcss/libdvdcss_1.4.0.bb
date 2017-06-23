# Recipe created by recipetool
# recipetool create -o libdvdcss_1.4.0.bb http://download.videolan.org/pub/libdvdcss/1.4.0/libdvdcss-1.4.0.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=64e753fa7d1ca31632bc383da3b57c27"

SRC_URI = "http://download.videolan.org/pub/libdvdcss/${PV}/libdvdcss-${PV}.tar.bz2"
SRC_URI[md5sum] = "2edba36e6af3f0223c4f0454cdf3d159"
SRC_URI[sha256sum] = "2089375984800df29a4817b37f3123c1706723342d6dab4d0a8b75c25c2c845a"

DEPENDS = "libdvdnav libdvdread"
inherit autotools pkgconfig

SROOT = "${WORKDIR}/recipe-sysroot"

# stupid --help is wrong.
# WARNING: libdvdcss-1.4.0-r0 do_configure: QA Issue: libdvdcss: configure was passed
# unrecognised options: --with-sysroot [unknown-configure-option]
EXTRA_OECONF = "--disable-doc"


HOMEPAGE = "http://www.videolan.org/libdvdcss/"
SUMMARY = "Implements the CSS decryption"
