# Recipe created by recipetool
# recipetool create -o scribus_1.5.4.bb https://downloads.sourceforge.net/project/scribus/scribus-devel/1.5.4/scribus-1.5.4.tar.xz

# ***BROKEN***
# almost completes do_compile, gives errors, such as:
# /mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/scribus/1.5.4-r0/scribus-1.5.4/scribus/scfonts.cpp:1052:6: error: 'class QFile' has no member named 'setName'; did you mean 'rename'?
#   fs.setName("/usr/X11R6/lib/X11/fs/config");


LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c5cffbe2fa807a80465e80cbcb6ce106"

SRC_URI = "https://downloads.sourceforge.net/project/scribus/scribus-devel/${PV}/scribus-${PV}.tar.xz \
           file://scribus-1.5.4-findcairo.patch"
SRC_URI[md5sum] = "fda4eb51304a41ff52081a1311b3bae5"
SRC_URI[sha256sum] = "6480925250b2bb07028e2f378c02b67fe3e33206743671e03c07c701cd05da03"

# removed: cairo-native
# removed: qttools 
DEPENDS = "icu cairo freetype libvisio fontconfig libfreehand tiff boost cups \
           libpagemaker virtual/libgl jpeg libcdr zlib librevenge libxml2 libmspub \
           poppler librsvg sqlite3 hunspell libdrm libcdr expat libxml2 libjpeg-turbo \
           zlib lcms pixman libpng harfbuzz ghostscript libmspub libxcb libxrender \
           libx11 libxext openssl mesa gnutls glib-2.0 graphite2 expat xz util-linux \
           libxau libxdmcp libxshmfence libgcrypt libxdamage libxfixes libxxf86vm libdrm \
           libidn libunistring nettle gmp libxau \
           qtbase qtbase-native qttools-native"

inherit cmake pkgconfig cmake_qt5 python-dir

#EXTRA_OECMAKE = "-DCMAKE_MODULE_PATH=${S}/cmake/modules"

# CMAKE_MODULE_PATH += " ${S}/cmake/modules"
#export CAIRO_DIR = "${S}/cmake/modules"

#do_configure() {
# echo 'HERE I AM'
# pwd
# touch ${WORKDIR}/TESTFILE
# cp -f ${WORKDIR}/FindCAIRO.cmake ${WORKDIR}/scribus-${PV}/cmake/modules/
#)

SUMMARY = "Desktop publishing"
HOMEPAGE = "https://www.scribus.net/"

