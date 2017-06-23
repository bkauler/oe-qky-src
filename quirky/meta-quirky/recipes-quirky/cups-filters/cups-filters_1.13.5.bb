# Recipe created by recipetool
# recipetool create -o cups-filters_1.13.5.bb https://www.openprinting.org/download/cups-filters/cups-filters-1.13.5.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a4c88b7020cef4a77b4321f78cbe1e1c"

SRC_URI = "https://www.openprinting.org/download/cups-filters/cups-filters-${PV}.tar.gz"
SRC_URI[md5sum] = "568ebc7f0b184939b370c2a08900fc5c"
SRC_URI[sha256sum] = "5f2796396fb558dd3758d08f147e5c9b76d1693e6fdbef314ed33a3eab94666a"

DEPENDS = "libpng dbus freetype zlib poppler lcms glib-2.0 fontconfig ghostscript ijs qpdf jpeg tiff glib-2.0-native"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools-brokensep

# ref: http://www.linuxfromscratch.org/blfs/view/cvs/pst/cups-filters.html
EXTRA_OECONF = "--with-test-font-path=/usr/share/fonts/TTF/DejaVuSans.ttf --without-php --disable-avahi --enable-ldap --enable-poppler --disable-dbus --enable-ghostscript --enable-ijs --disable-mutool --enable-foomatic --without-rcdir"


HOMEPAGE = "http://www.openprinting.org/"
SUMMARY = "Backends filters and other software that was once part of the core CUPS."
