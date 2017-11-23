LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

# 171123
PR = "r1"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xine-ui-${PV}.tar.bz2"
SRC_URI[md5sum] = "462a7b5db1ef7b7a7384c2dc208ce3f1"
SRC_URI[sha256sum] = "ccaccfaabb91323a27463fcea859094001f090aaf0d02b8a9c4a875b06a076a6"

# 171123 change libpng to libpng12
DEPENDS = "libxinerama libpng12 curl libxext libx11 libxscrnsaver xine-lib libjpeg-turbo libxxf86vm libxtst libxv libxft openssl"

inherit gettext pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--enable-xft --disable-lirc --without-aalib --without-caca"

# 171123 running in Pyro64 0.5.2, xine-ui reported this:
# "libpng warning: application built with libpng-1.2.54 but running with 1.6.28"
# try this fix (see also change above):
do_configure_prepend() {
 ln -snf libpng12.pc ${WORKDIR}/recipe-sysroot/usr/lib/pkgconfig/libpng.pc
}

HOMEPAGE = "https://www.xine-project.org/"
SUMMARY = "Media player, xlib based gui for xine-lib"

