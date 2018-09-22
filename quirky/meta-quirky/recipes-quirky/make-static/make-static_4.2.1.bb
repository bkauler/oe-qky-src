LICENSE = "GPLv3 & LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://tests/COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://glob/COPYING.LIB;md5=4a770b67e6be0f60da244beb2de0fce4"
require make.inc

S = "${WORKDIR}/make-${PV}"
CFLAGS += " -static"
LDFLAGS += " -static"

EXTRA_OECONF += "--without-guile --disable-nls"

SRC_URI[md5sum] = "15b012617e7c44c0ed482721629577ac"
SRC_URI[sha256sum] = "d6e262bf3601b42d2b1e4ef8310029e1dcf20083c5446b4b7aa67081fdffc589"

#trying to fix won't link statically...
do_compile_prepend() {
    sed -i -e 's%^AM_LDFLAGS =.*%AM_LDFLAGS = %' ${B}/Makefile
}

#BBCLASSEXTEND = "native nativesdk"
