# Recipe created by recipetool
# recipetool create -o peasyscale-exec_1.4.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/peasyscale_source-1.4.tar.bz2

# peasyscale written by rcrsn51 and MU, ref: 
# http://murga-linux.com/puppy/viewtopic.php?p=617584

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/peasyscale_source-${PV}.tar.bz2"
SRC_URI[md5sum] = "364f70891cf2b426cd405c33ad0967da"
SRC_URI[sha256sum] = "734aa4f7fa639cea42a07e4570e5f5b13ac0e79f86fe9af41d12fdf58010ce54"

S = "${WORKDIR}/peasyscale_source-${PV}"

# NOTE: this is a Makefile-only piece of software.
DEPENDS = "gtk+ gdk-pixbuf"
inherit pkgconfig

do_configure () {
    if [ -f peasyscale.bin ];then
     rm -f peasyscale.bin
    fi
}

do_compile () {
    ${CC} -o peasyscale.bin peasyscale.c `pkg-config --libs gdk-pixbuf-2.0 gdk-2.0` `pkg-config --cflags gdk-pixbuf-2.0 gdk-2.0` -lm ${CFLAGS} ${LDFLAGS}
}

do_install () {
    install -d ${D}/usr/local/bin
    install -m755 peasyscale.bin ${D}/usr/local/bin
}

FILES_${PN} += "/usr/local/bin"

HOMEPAGE = "http://murga-linux.com/puppy/viewtopic.php?p=617584"
SUMMARY = "Image scaler utility."
