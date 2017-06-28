# Recipe created by recipetool
# recipetool create -o libgd_2.2.4.bb https://github.com/libgd/libgd/releases/download/gd-2.2.4/libgd-2.2.4.tar.gz

SUMMARY = "GD is an open source code library for the dynamic creation of images by programmers"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=07384b3aa2e0d39afca0d6c40286f545"

SRC_URI = "https://github.com/libgd/libgd/releases/download/gd-${PV}/libgd-${PV}.tar.gz"
SRC_URI[md5sum] = "0a3c307b5075edbe1883543dd1153c02"
SRC_URI[sha256sum] = "487a650aa614217ed08ab1bd1aa5d282f9d379cfd95c756aed0b43406381be65"

# NOTE: unable to map the following CMake package dependencies: XPM WEBP LIQ ICONV GD
DEPENDS = "zlib libpng freetype jpeg tiff fontconfig libxpm giflib"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DENABLE_PNG=1 -DENABLE_JPEG=1 -DENABLE_TIFF=1 -DENABLE_XPM=1 -DENABLE_FREETYPE=1 -DENABLE_FONTCONFIG=1"

# do_package put libgd.so into libgd-dev, but its the only one, needed by utilities.
# this moves libgd.so from package libgd-dev to libgd...
FILES_${PN}-dev = "/usr/include/*"
FILES_${PN} += "/usr/lib/libgd.so"

HOMEPAGE = "http://www.libgd.org/"
