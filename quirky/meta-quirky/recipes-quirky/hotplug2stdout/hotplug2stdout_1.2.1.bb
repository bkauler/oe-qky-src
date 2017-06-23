# Recipe created by recipetool
# recipetool create -o hotplug2stdout_1.2.1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/hotplug2stdout-1.2.1.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://cddetect.c;md5=3bf1e7dcb0a81100a749b695425ca76e"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/hotplug2stdout-${PV}.tar.bz2"
SRC_URI[md5sum] = "8834b21db9619a4f48c37660ba4fbb18"
SRC_URI[sha256sum] = "df815842f6bfcbaa80f574b6775646a1c8078b4f07e321690c369b2a942b6134"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    true
}

do_compile () {
    if [ -f hotplug2stdout ];then
     rm -f hotplug2stdout
    fi
    ${CC} -c hotplug2stdout.c ${CFLAGS}
    ${CC} -o hotplug2stdout hotplug2stdout.o ${LDFLAGS}
    if [ -f hotplug2stdout_notimeout ];then
     rm -f hotplug2stdout_notimeout
    fi
    ${CC} -c hotplug2stdout_notimeout.c ${CFLAGS}
    ${CC} -o hotplug2stdout_notimeout hotplug2stdout_notimeout.o ${LDFLAGS}
}

do_install () {
    install -d ${D}/sbin
    install -m755 hotplug2stdout ${D}/sbin
    install -m755 hotplug2stdout_notimeout ${D}/sbin
}


HOMEPAGE = ""
SUMMARY = "Read kernel uevents write them to stdout."
