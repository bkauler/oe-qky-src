# Recipe created by recipetool
# recipetool create -o bluepup-tray_20160922.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/b/bluepup_tray-20160922.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/b/bluepup_tray-${PV}.tar.gz"
SRC_URI[md5sum] = "750efc91d62dd6124ea1eeddd1d0b89c"
SRC_URI[sha256sum] = "3f9130e2fafb38c84cdd71ec0afe5be1ebc724c2c61c05f8858ce6903f9cbed8"

S = "${WORKDIR}/bluepup_tray-${PV}"

inherit pkgconfig gettext

DEPENDS = "gtk+ gdk-pixbuf libxpm"

do_configure () {
 true
}

do_compile () {
 ${CC} ${CFLAGS} ${LDFLAGS} -Wl,--no-as-needed bluepup_tray.c -o bluepup_tray `pkg-config --cflags --libs gtk+-2.0`
 xgettext --keyword="_" bluepup_tray.c -o bluepup_tray.pot
}

do_install () {
 install -d ${D}/usr/local/bluepup
 install -m755 bluepup_tray ${D}/usr/local/bluepup
 install -m644 bluetooth-off.xpm ${D}/usr/local/bluepup
 install -m644 bluetooth-on.xpm ${D}/usr/local/bluepup
 install -d ${D}/usr/share/doc/nls/bluepup_tray
 install -m644 bluepup_tray.pot ${D}/usr/share/doc/nls/bluepup_tray
}

HOMEPAGE = "http://bkhome.org/news/201604/bluepup-bluetooth-management.html"
SUMMARY = "Tray applet used by BluePup in EasyOS and Quirky Linux"