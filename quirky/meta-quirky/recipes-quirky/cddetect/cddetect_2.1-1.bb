# Recipe created by recipetool
# recipetool create -o cddetect_2.1-1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/cddetect-2.1-1.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=81bcece21748c91ba9992349a91ec11d"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/cddetect-${PV}.tar.bz2 \
           file://cddetect-2.1-1-limits.patch"
SRC_URI[md5sum] = "fe7ee931b7ac4c80739f23ca44425c2d"
SRC_URI[sha256sum] = "722a1f04d95ffdcef1f5bfe1e83378b89d6c841b6e7e108e2f5f3470721dcb55"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    true
}

do_compile () {
    ${CC} -c cddetect.c ${CFLAGS}
    ${CC} -o cddetect cddetect.o ${LDFLAGS}
}

do_install () {
    install -d ${D}/sbin
    install -m755 cddetect ${D}/sbin
}


HOMEPAGE = ""
SUMMARY = "Detect CD inserted in drive."
