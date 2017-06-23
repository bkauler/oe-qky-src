# Recipe created by recipetool
# recipetool create -o minixcal_1.1.1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/minixcal-1.1.1.tar.bz2

SUMMARY = "Calendar applet, written in gtk2. Excellent as tray applet"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb723b61539feef013de476e68b5c50a"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/minixcal-${PV}.tar.bz2"
SRC_URI[md5sum] = "08736c22bb138b52ac9070e1c0512fcb"
SRC_URI[sha256sum] = "efc0dd6c90f66b955edbc3f5b277f82b265cb8292c4f30c0b05b2b1f0271c1d2"

# NOTE: no Makefile found.
DEPENDS = "gtk+ libx11"
inherit pkgconfig

do_configure () {
    true
}

do_compile () {
    if [ -f minixcal ];then
     rm -f minixcal
    fi
    ${CC} minixcal.c -o minixcal `pkg-config --cflags gtk+-2.0` `pkg-config --libs gtk+-2.0` -lX11 ${CFLAGS} ${LDFLAGS}
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 minixcal ${D}/usr/bin
}


HOMEPAGE = ""
