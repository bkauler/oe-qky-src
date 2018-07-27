SUMMARY = "Lightweight CLI text editor for programmers"
HOMEPAGE = "http://triptico.com/software/mp.html"
SECTION = "console/utils"
PRIORITY = "optional"

# 180727 BK note, the menu does not work with version 3.2.13, though, in the
#        past we have had opposite situation. don't know the cause.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/m/mp-${PV}.tar.gz \
	file://mp.desktop \
	file://mprc \
	file://mp.xpm"
SRC_URI[md5sum] = "e6366f1351211f6dabc22bb3f5ec6f99"
SRC_URI[sha256sum] = "daaebaf7eacf7919c7383581cdd2f0450d359434866b6d18d686d0edb589c952"

S = "${WORKDIR}/mp-${PV}"
PR = "r0"

DEPENDS = "ncurses libpcre"

inherit base

do_configure () {
    ./config.sh --without-gtk --with-included-regex --prefix=/usr --without-gettext --without-i18n
}

do_compile() {
	oe_runmake mp
}

do_install() {
	install -d ${D}/usr/bin
	install -d ${D}/etc
	#oe_runmake install DESTDIR=${D} PREFIX=/usr
	install -d ${D}/usr/share/applications
	install -d ${D}/usr/share/pixmaps
	install -m755 mp ${D}/usr/bin
	install -m644 ../mp.desktop ${D}/usr/share/applications
	install -m644 ../mp.xpm ${D}/usr/share/pixmaps
	install -m644 ../mprc ${D}/etc
}

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "/usr/share/mp*/mp_*"
