# Recipe created by recipetool
# recipetool create -o puppyserialdetect_1.1h.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/puppyserialdetect-1.1h.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://puppyserialdetect.c;md5=706d982affc71a74dca5e0ebff98a809"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/puppyserialdetect-${PV}.tar.bz2"
SRC_URI[md5sum] = "53490dd562e28abe1f6ac314c3310d03"
SRC_URI[sha256sum] = "3cf247fbc82ac1f5c14b09bb4e63f5f3870be4c8cab6bf5f33026ef4dfa18184"

# NOTE: no Makefile found.

do_configure () {
    true
}

do_compile () {
    ${CC} -o puppyserialdetect ${CFLAGS} ${LDFLAGS} puppyserialdetect.c serial.c utils.c mouse.c
}

do_install () {
    install -d ${D}/sbin
    install -m755 puppyserialdetect ${D}/sbin
}


HOMEPAGE = ""
SUMMARY = "Serial mouse and modem detection console utility."
