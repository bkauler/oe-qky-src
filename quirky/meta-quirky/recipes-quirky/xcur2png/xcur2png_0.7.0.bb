# Recipe created by recipetool
# recipetool create -o xcur2png_0.7.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xcur2png-0.7.0.tar.bz2

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xcur2png-${PV}.tar.bz2"
SRC_URI[md5sum] = "cd251b170ce1241d1809d8f7eaab9649"
SRC_URI[sha256sum] = "9d3d99bcbb5d9f275cb151d518c760654741e2dec78ea62c95a504a1a24021b3"

DEPENDS = "libpng12 libxcursor libx11"

inherit pkgconfig autotools

#EXTRA_OECONF = ""

do_configure_prepend() {
    #ln -snf libpng12.so.0 ${WORKDIR}/recipe-sysroot/usr/lib/libpng.so
    cp -a -f ${WORKDIR}/recipe-sysroot/usr/lib/pkgconfig/libpng12.pc ${WORKDIR}/recipe-sysroot/usr/lib/pkgconfig/libpng.pc
    cp -a -f ${WORKDIR}/recipe-sysroot/usr/include/libpng12/* ${WORKDIR}/recipe-sysroot/usr/include/
}

HOMEPAGE = ""
SUMMARY = "Converter from X cursor to PNG image."
