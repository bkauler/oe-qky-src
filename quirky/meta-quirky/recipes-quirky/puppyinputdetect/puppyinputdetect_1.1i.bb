# Recipe created by recipetool
# recipetool create -o puppyinputdetect_1.1i.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/puppyinputdetect-1.1i.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.c;md5=ecc99078ca6611c5a02c33473395a577"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/puppyinputdetect-${PV}.tar.bz2"
SRC_URI[md5sum] = "9ad4ef5f94bd6843b1fe573a3ef1cb6c"
SRC_URI[sha256sum] = "2f52fc537656953cef1478529cf80cc8e36d904bd46f00e91a0e64ef9b594712"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    true
}

do_compile () {
    ${CC} -o puppyinputdetect ${CFLAGS} ${LDFLAGS} main.c proc.c
}

do_install () {
    install -d ${D}/sbin
    install -m755 puppyinputdetect ${D}/sbin
}


HOMEPAGE = ""
SUMMARY = "usb  ps2 mouse and keyboard detection console utility."
