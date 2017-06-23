# Recipe created by recipetool
# recipetool create -o glipper-lite_2013-technosaurus.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/glipper-lite-2013-technosaurus.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.c;md5=ee3901a4b0e548543bb2da28bddc0431"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/glipper-lite-${PV}.tar.bz2"
SRC_URI[md5sum] = "7ffe93ee5182e13b764460f07162288e"
SRC_URI[sha256sum] = "776b17cf660c5f6e3e5e5d0cc7c94906ebe4547994815b98b6ffa14782f7c3ec"

DEPENDS = "gtk+ libx11 glib-2.0 libpng"

SINC = "${WORKDIR}/recipe-sysroot/usr/include"
SLIB = "${WORKDIR}/recipe-sysroot/usr/lib"

CFLAGS += "-I${SINC}/gtk-2.0 -I${SINC}/atk-1.0 -I${SINC}/gdk-pixbuf-2.0 \
           -I${SINC}/pango-1.0 -I${SINC}/cairo -I${SINC}/glib-2.0 \
           -I${SINC}/pixman-1 -I${SINC}/freetype2 \
           -I${SLIB}/gtk-2.0/include -I${SLIB}/glib-2.0/include \
           -DGTK_NO_CHECK_CASTS -DG_DISABLE_CAST_CHECKS  -DHAVE_CONFIG_H"
LDFLAGS += "-lgtk-x11-2.0 -lgdk-x11-2.0 -lX11 -lgobject-2.0 -lglib-2.0"

do_configure () {
    true
}

do_compile () {
    ${CC} -c main.c ${CFLAGS}
    ${CC} -c eggaccelerators.c ${CFLAGS}
    ${CC} -o glipper eggaccelerators.o main.o ${LDFLAGS}
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 glipper ${D}/usr/bin
}


HOMEPAGE = ""
SUMMARY = "GlipperLite is a clipboard manager."
