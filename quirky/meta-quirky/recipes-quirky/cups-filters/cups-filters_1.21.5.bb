# Recipe created by recipetool
# recipetool create -o cups-filters_1.21.5.bb https://www.openprinting.org/download/cups-filters/cups-filters-1.21.5.tar.gz
# 181209 note: bumped dep qpdf to 8.2.1

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=079833adec8b92690ca302dd95507100"

SRC_URI = "https://www.openprinting.org/download/cups-filters/cups-filters-${PV}.tar.gz"
SRC_URI[md5sum] = "9cc1e9ecbbe29df482ca21b0ff41170c"
SRC_URI[sha256sum] = "e21158102ef2d263ec214ff941ee12947271a32937d0f90d12698fd46694c5d7"

DEPENDS = "libpng freetype zlib poppler lcms glib-2.0 fontconfig ghostscript ijs qpdf jpeg tiff glib-2.0-native cups dbus"

inherit pkgconfig autotools-brokensep

# ref: http://www.linuxfromscratch.org/blfs/view/cvs/pst/cups-filters.html
# 181209 removed:  --disable-dbus
EXTRA_OECONF = "--with-test-font-path=/usr/share/fonts/TTF/DejaVuSans.ttf --without-php --disable-avahi --enable-ldap --enable-poppler --enable-ghostscript --enable-ijs --disable-mutool --enable-foomatic --without-rcdir"

HOMEPAGE = "http://www.openprinting.org/"
SUMMARY = "Backends filters and other software that was once part of the core CUPS."
