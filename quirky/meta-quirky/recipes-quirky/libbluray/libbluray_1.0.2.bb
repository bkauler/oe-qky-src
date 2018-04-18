# Recipe created by recipetool

SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=435ed639f84d4585d93824e7da3d85da"

SRC_URI = "ftp://ftp.videolan.org/pub/videolan/libbluray/${PV}/libbluray-${PV}.tar.bz2"
SRC_URI[md5sum] = "3d90c9ac32a299e0a18df077f6dc9515"
SRC_URI[sha256sum] = "6d9e7c4e416f664c330d9fa5a05ad79a3fb39b95adfc3fd6910cbed503b7aeff"

#  libpthread-stubs
DEPENDS = "fontconfig freetype libxml2 zlib expat"

inherit pkgconfig autotools

EXTRA_OECONF = "--disable-doxygen-doc --disable-static --disable-bdjava-jar --disable-examples --disable-extra-warnings"

SUMMARY = "Library for Bluray media"
HOMEPAGE = "https://www.videolan.org/developers/libbluray.html"
