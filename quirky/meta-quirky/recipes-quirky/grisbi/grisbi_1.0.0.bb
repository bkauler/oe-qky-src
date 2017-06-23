# Recipe created by recipetool

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "https://downloads.sourceforge.net/project/grisbi/grisbi%20stable/1.0.x/grisbi-${PV}.tar.bz2 \
           file://0001-Tune-grisbi.desktop.patch \
           file://0002-Add-.pc-quilt-to-POTFILES.skip.patch \
           file://0003-Fix-variable-of-type-PangoAlignment-expected-instead.patch \
           file://0099-reorder-autoconf.patch"
SRC_URI[md5sum] = "d3d0b03b49f2c86b110910ec903630f2"
SRC_URI[sha256sum] = "8a23d26777666814d918702ad9207bac433abd3ac71568d53f7c485670f92c55"

DEPENDS = "gtk+ libxml2 glib-2.0 zlib intltool-native openssl libofx glib-2.0-native"

inherit gettext pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--without-goffice --with-ofx --with-openssl --with-libxml2 --disable-frenchdoc"


HOMEPAGE = "http://www.grisbi.org/"
SUMMARY = "A personal account management package"
