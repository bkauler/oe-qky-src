# Recipe created by recipetool

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://distro.ibiblio.org/easyos/source/oe/pyro/network_tray-${PV}.tar.gz"
SRC_URI[md5sum] = "209f7b448eb657f8f63c3cb8a49cbb77"
SRC_URI[sha256sum] = "1182539180d9ecc9773e0ba2c182c81bc2ecaa39961e4c45947aea81ece3b759"

S = "${WORKDIR}/network_tray-${PV}"

# NOTE: no Makefile found.
DEPENDS = "gtk+"
inherit pkgconfig gettext

do_configure () {
    if [ -f network_tray ];then
     rm -f network_tray
    fi
    if [ -f network_tray.pot ];then
     rm -f network_tray.pot
    fi
}

do_compile () {
    ${CC} -Wl,--no-as-needed `pkg-config --cflags --libs gtk+-2.0` network_tray.c -o network_tray ${CFLAGS} ${LDFLAGS}
    xgettext --keyword="_" network_tray.c  -o network_tray.pot
}

do_install () {
    install -d ${D}/root/Startup
    install -m755 network_tray ${D}/root/Startup
    install -d ${D}/usr/share/doc/nls/network_tray
    install -m644 network_tray.pot ${D}/usr/share/doc/nls/network_tray
    install -d ${D}/usr/local/lib/X11/mini-icons
    install -m644 networkblank.xpm ${D}/usr/local/lib/X11/mini-icons
    install -m644 networkboth.xpm ${D}/usr/local/lib/X11/mini-icons
    install -m644 networkdead.xpm ${D}/usr/local/lib/X11/mini-icons
    install -m644 networkin.xpm ${D}/usr/local/lib/X11/mini-icons
    install -m644 networkout.xpm ${D}/usr/local/lib/X11/mini-icons
}

FILES_${PN} += '/root/Startup /usr/local/lib/X11/mini-icons'

HOMEPAGE = "http://barryk.org/news"
SUMMARY = "Tray applet for Puppy and derivatives, show network activity"

