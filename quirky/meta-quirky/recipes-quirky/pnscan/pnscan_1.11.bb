LICENSE = "GPL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76d2667df44a60aa2ece84148097b345"

SRC_URI = "ftp://ftp.lysator.liu.se/pub/unix/pnscan/pnscan-${PV}.tar.gz"
SRC_URI[md5sum] = "2fcb161470929d8c35bdb2c67f5030e4"
SRC_URI[sha256sum] = "d39d01d0b2ea061958a6b7a786cc959a206b8c8d74752e9168956dd981808e94"

# NOTE: this is a Makefile-only piece of software.
# note: there is EXTRA_OEMAKE_append = " ", but think can just append directly onto oe_runmake
# note: that "-lnsl" in Makefile lead me "up the garden path" -- it isn't actually used!!!

do_configure () {
	#sed -i -e 's%/usr/local%/usr%' ${B}/Makefile
	#sed -i '/^DESTDIR=/d' ${B}/Makefile
	true
}

do_compile () {
	#oe_runmake lnx
	#...um, the Makefile is too messy. do it directly:
    ${CC} -c pnscan.c ${CFLAGS} -lpthread -lnsl
    ${CC} -c bm.c ${CFLAGS} -lpthread -lnsl
    ${CC} -c version.c ${CFLAGS} -lpthread -lnsl
    ${CC} -o pnscan pnscan.o bm.o version.o ${LDFLAGS} ${CFLAGS} -lpthread -lnsl
}

do_install () {
	#oe_runmake install-all DESTDIR=${D}/usr
	#...not working properly, just do this:
	install -d ${D}/usr/bin
	install -m 755 pnscan ${D}/usr/bin
}

HOMEPAGE = "https://github.com/ptrrkssn/pnscan"
SUMMARY = "pnscan is a tool that can be used to survey TCP network service"
