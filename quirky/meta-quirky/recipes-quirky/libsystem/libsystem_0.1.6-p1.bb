# Recipe created by recipetool
# recipetool create -o libsystem_0.1.6-p1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/libSystem-0.1.6-patched1.tar.bz2

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/libSystem-0.1.6-patched1.tar.bz2"
SRC_URI[md5sum] = "a8cfc8a3666653bc530644f293f6b962"
SRC_URI[sha256sum] = "c50c82ecfef9ae2268120d2754bc74f738374951d64e2025580712d851ac2789"

S = "${WORKDIR}/libSystem-0.1.6-patched1"

DEPENDS = "openssl gnet"

# BK note, Makefile only.

do_configure () {
    sed -i -e 's%^CC	=%# CC	=%' ${S}/src/Makefile
    sed -i -e 's%^CFLAGS	=%CFLAGS	+=%' ${S}/src/Makefile
    sed -i -e 's%^CC	=%# CC	=%' ${S}/tools/Makefile
    sed -i -e 's%^CFLAGS	=%CFLAGS	+=%' ${S}/tools/Makefile
    sed -i -e 's%^LDFLAGS	=%LDFLAGS	+=%' ${S}/tools/Makefile
}

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install DESTDIR=${D}
}


HOMEPAGE = ""
SUMMARY = "A system library needed by surfer web browser."
