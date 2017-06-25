# Recipe created by recipetool
# recipetool create -o freememapplet-tray_2.6.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/f/freememapplet_tray-2.6.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/f/freememapplet_tray-${PV}.tar.gz"
SRC_URI[md5sum] = "56e3284eef31ab3971e70881dbded050"
SRC_URI[sha256sum] = "75f38b9f955b39e35c3f370492da3bb492cdf5e15b5582b5a7f3a526374f2479"

S = "${WORKDIR}/freememapplet_tray-${PV}"

# NOTE: no Makefile found.
DEPENDS = "gtk+"
inherit pkgconfig gettext

do_configure () {
    if [ -f freememapplet_tray ];then
     rm -f freememapplet_tray
    fi
    if [ -f freememapplet_tray.pot ];then
     rm -f freememapplet_tray.pot
    fi
}

do_compile () {
    ${CC} -Wl,--no-as-needed `pkg-config --cflags --libs gtk+-2.0` freememapplet_tray.c -o freememapplet_tray ${CFLAGS} ${LDFLAGS}
    xgettext --keyword="_" freememapplet_tray.c  -o freememapplet_tray.pot
}

do_install () {
    install -d ${D}/root/Startup
    install -m755 freememapplet_tray ${D}/root/Startup
    install -d ${D}/usr/share/doc/nls/freememapplet_tray
    install -m644 freememapplet_tray.pot ${D}/usr/share/doc/nls/freememapplet_tray
}

FILES_${PN} += '/root/Startup'

HOMEPAGE = "http://barryk.org/news"
SUMMARY = "Tray applet for Puppy and derivatives, show free storage"

