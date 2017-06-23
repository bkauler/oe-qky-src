# Recipe created by recipetool
# recipetool create -o cddetect-quick_2008-1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/cddetect_quick-2008-1.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://cddetect.c;md5=81a375bd6ed9e7516b665a7971796886"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/cddetect_quick-${PV}.tar.bz2"
SRC_URI[md5sum] = "6ebe6a49108d62e221ab4b2fb626b00a"
SRC_URI[sha256sum] = "0aee6a1aa78860443bec8030c7aad6cbd597de510a9fdf69fdfd69de28561b4d"

S = "${WORKDIR}/cddetect_quick-${PV}"

# NOTE: no Makefile found.

do_configure () {
    true
}

do_compile () {
    ${CC} -c cddetect.c ${CFLAGS}
    ${CC} -o cddetect_quick cddetect.o ${LDFLAGS}
}

do_install () {
    install -d ${D}/sbin
    install -m755 cddetect_quick ${D}/sbin
}


HOMEPAGE = ""
SUMMARY = ""
