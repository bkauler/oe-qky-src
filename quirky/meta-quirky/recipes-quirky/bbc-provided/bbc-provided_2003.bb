# Recipe created by recipetool
# recipetool create -o bbc-provided_2003.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/bbc_provided-2003.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHTS;md5=48174c0f40c461f7045c089ace16163e"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/bbc_provided-${PV}.tar.bz2"
SRC_URI[md5sum] = "05035c908c8233c03d9247d1b502d972"
SRC_URI[sha256sum] = "c10f9e0ab118c989131bdf820cc11aeb422fc50cb46446fc2c5ae32aacb48ffb"

S = "${WORKDIR}/bbc_provided-${PV}"

DEPENDS = "libjpeg-turbo popt"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    true
}

do_compile () {
    if [ -f and ];then
     rm -f and
    fi
    if [ -f or ];then
     rm -f or
    fi
    if [ -f dotquad ];then
     rm -f dotquad
    fi
    if [ -f ipcalc ];then
     rm -f ipcalc
    fi
    ${CC} -O2 -s -o and andor.c -DAND ${CFLAGS} ${LDFLAGS}
    ${CC} -O2 -s -o or andor.c -DOR ${CFLAGS} ${LDFLAGS}
    ${CC} -O2 -s -o dotquad dotquad.c ${CFLAGS} ${LDFLAGS}
    ${CC} -O2 -s -o ipcalc ipcalc.c -lpopt ${CFLAGS} ${LDFLAGS}
}

do_install () {
    #oe_runmake install 'DESTDIR=${D}'
    install -d ${D}/usr/bin
    install -m755 and ${D}/usr/bin
    install -m755 or ${D}/usr/bin
    install -m755 dotquad ${D}/usr/bin
    install -m755 ipcalc ${D}/usr/bin
}


HOMEPAGE = ""
SUMMARY = ""
