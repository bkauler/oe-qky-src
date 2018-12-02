# Recipe created by recipetool
# 181119 v3.4: fix for NetworkManager, has all interfaces up.

PR = "r1"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://distro.ibiblio.org/easyos/source/oe/pyro/network_tray-${PV}.tar.gz"
SRC_URI[md5sum] = "202921b7d69d5672b0f8e5e738729d6f"
SRC_URI[sha256sum] = "ca399d14db056fd57be5739fa661fb446ce25e7db234172a187aa1d9596e261d"

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

HOMEPAGE = "http://bkhome.org/news"
SUMMARY = "Tray applet for Puppy and derivatives, show network activity"

