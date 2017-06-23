# Recipe created by recipetool
# recipetool create -o powerapplet-tray_2.6.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/powerapplet_tray-2.6.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://powerapplet_tray.c;md5=87a8d17a97305c5d5f31064b5103eaaf"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/powerapplet_tray-${PV}.tar.bz2"
SRC_URI[md5sum] = "a2c75d8bce5f86ca405ad4cd6ca6bf05"
SRC_URI[sha256sum] = "d35356a70342910225ebbcc394fc7271e9be5546b97763baa53aef0ea536b2ca"

S = "${WORKDIR}/powerapplet_tray-${PV}"

# NOTE: no Makefile found.
DEPENDS = "gtk+"
inherit pkgconfig gettext

do_configure () {
    if [ -f powerapplet_tray ];then
     rm -f powerapplet_tray
    fi
    if [ -f powerapplet_tray.pot ];then
     rm -f powerapplet_tray.pot
    fi
}

do_compile () {
    ${CC} `pkg-config --cflags --libs gtk+-2.0` powerapplet_tray.c -o powerapplet_tray ${CFLAGS} ${LDFLAGS}
    xgettext --keyword="_" powerapplet_tray.c  -o powerapplet_tray.pot
}

do_install () {
    install -d ${D}/root/Startup
    install -m755 powerapplet_tray ${D}/root/Startup
    install -d ${D}/usr/share/doc/nls/powerapplet_tray
    install -m644 powerapplet_tray.pot ${D}/usr/share/doc/nls/powerapplet_tray
}

FILES_${PN} += '/root/Startup'

HOMEPAGE = ""
SUMMARY = ""
