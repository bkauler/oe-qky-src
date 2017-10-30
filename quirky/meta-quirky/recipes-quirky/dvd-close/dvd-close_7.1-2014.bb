LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/dvd_close-${PV}.tar.bz2"
SRC_URI[md5sum] = "74a24208f4d899340b54615686f486fd"
SRC_URI[sha256sum] = "f0d2fc55676080e02cc094bb49a55d44ca04650bea127b1d26d1f0f01469a715"

S = "${WORKDIR}/dvd_close-${PV}"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
	true
}

do_compile () {
	${CXX} -o close close.cpp ${CXXFLAGS} ${LDFLAGS} -fno-exceptions -D_REENTRANT
}

do_install () {
	install -d ${D}/usr/bin
	install -m 755 close ${D}/usr/bin
}

HOMEPAGE = "http://www.murga-linux.com/puppy/viewtopic.php?p=155668"
SUMMARY = "Utility to close optical madia tray"
