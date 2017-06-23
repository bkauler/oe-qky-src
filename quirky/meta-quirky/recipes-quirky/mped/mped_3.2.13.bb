DESCRIPTION = "Lightweight text editor for programmers."
HOMEPAGE = "http://triptico.com/software/mp.html"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"

DEPENDS = "ncurses"
SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/mp-${PV}.tar.bz2 \
	file://mp.desktop \
	file://mprc \
	file://mp.xpm "

S = "${WORKDIR}/mp-${PV}"
PR = "r0"

inherit base

do_configure () {
    true
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
	install -m755 mp_doccer/mp_doccer ${D}/usr/bin
	install -m644 ../mp.desktop ${D}/usr/share/applications
	install -m644 ../mp.xpm ${D}/usr/share/pixmaps
	install -m644 ../mprc ${D}/etc
}

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "/usr/share/mp*/mp_*"

SRC_URI[md5sum] = "ac49b82f2abc4b170d7956c76764835a"
SRC_URI[sha256sum] = "970ce44a58ffbfceb27b3e90ee715c8c26c1d5c7126c8d131509df7fa1da0c29"

SUMMARY = ""
