LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=79808397c3355f163c012616125c9e26"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/m/mdview-${PV}.tar.gz"
SRC_URI[md5sum] = "b7dd50ca3d5f8b61a202a4ec10bc9ec9"
SRC_URI[sha256sum] = "7fe07a7caeaaf43d9687474f61bcc7bf09e622083575858e5e04471ced3865c8"

# NOTE: this is a Makefile-only piece of software.

DEPENDS = "gtk+"
inherit pkgconfig

do_configure () {
	true
}

do_compile () {
	${CC} *.c -o mdview ${CFLAGS} ${LDFLAGS} `pkg-config --cflags --libs gtk+-2.0`
}

do_install () {
	install -d ${D}/usr/bin
	install -m 755 mdview ${D}/usr/bin
}

HOMEPAGE = "http://www.lightofdawn.org/blog/?viewDetailed=00141"
SUMMARY = "Simple markdown viewer, using only gtk+"
