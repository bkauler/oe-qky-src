DESCRIPTION = "Dia is a gtk+ based diagram creation program released under the GPL license."
SECTION = "x11/graphics"
DEPENDS = "libart-lgpl libpng cairo zlib gtk+ libxml2 intltool-native"

# BK note: dep 'intltool-native' fixed compile error "intltoolize: command not found"

inherit autotools gnome pkgconfig

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/dia/0.97/dia-0.97.3.tar.xz \
           file://oe-configure-in-libxml-freetype.patch \
           "

# BK 170610 i think $STAGING_INCDIR and $STAGING_LIBDIR is for classic oe, no longer valid. instead:
SINC = "${WORKDIR}/recipe-sysroot/usr/include"
SLIB = "${WORKDIR}/recipe-sysroot/usr/lib"

#work around some pkgconfig breakages
LDFLAGS += "-lart_lgpl_2 -lxml2 -lgthread-2.0 -lglib-2.0"
CFLAGS += "-I${SINC}/libart-2.0 "

FILES_${PN} += "${datadir}/mime-info/"

EXTRA_OECONF = "--without-python --without-hardbooks --disable-gnome --enable-debug=no"

SRC_URI[md5sum] = "0e744a0f6a6c4cb6a089e4d955392c3c"
SRC_URI[sha256sum] = "22914e48ef48f894bb5143c5efc3d01ab96e0a0cde80de11058d3b4301377d34"

HOMEPAGE = "http://live.gnome.org/Dia"
SUMMARY = "Program for drawing structured diagrams"
