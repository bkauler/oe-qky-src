
# 171128 fix printing. rolled back from 1.13.5, ref: http://bkhome.org/news/201711/no-cups-support-in-gtk-in-openembedded.html
# see also 'cups', 'gtk+', 'poppler' recipes.

# Recipe created by recipetool
#  recipetool create -o cups-filters_1.11.4.bb https://www.openprinting.org/download/cups-filters/cups-filters-1.11.4.tar.gz

PR = "r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c7c37036d013b7f03c2fc3dcbbc21ccb"

SRC_URI = "https://www.openprinting.org/download/cups-filters/cups-filters-${PV}.tar.gz"
SRC_URI[md5sum] = "46d11b2db0d095c383fac2f6395a7e74"
SRC_URI[sha256sum] = "f8216c9f5762672a4a94170cc80d5fe5c408cf103348340a3b62e8afc38e6e16"

DEPENDS = "libpng freetype zlib poppler lcms glib-2.0 fontconfig ghostscript ijs qpdf jpeg tiff glib-2.0-native cups"

inherit pkgconfig autotools-brokensep

# ref: http://www.linuxfromscratch.org/blfs/view/cvs/pst/cups-filters.html
EXTRA_OECONF = "--with-test-font-path=/usr/share/fonts/TTF/DejaVuSans.ttf --without-php --disable-avahi --enable-ldap --enable-poppler --disable-dbus --enable-ghostscript --enable-ijs --disable-mutool --enable-foomatic --without-rcdir"


HOMEPAGE = "http://www.openprinting.org/"
SUMMARY = "Backends filters and other software that was once part of the core CUPS."
