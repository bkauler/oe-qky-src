# Recipe created by recipetool

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=de10de48642ab74318e893a61105afbb \
                    file://archival/libarchive/bz/LICENSE;md5=28e3301eae987e8cfe19988e98383dae"

SRC_URI = "http://busybox.net/downloads/busybox-${PV}.tar.bz2 \
           file://BBconfig-V1.30.1-INITRAMFS"
SRC_URI[md5sum] = "4f72fc6abd736d5f4741fc4a2485547a"
SRC_URI[sha256sum] = "3d1d04a4dbd34048f4794815a5c48ebb9eb53c5277e09ffffc060323b95dfbdc"

S = "${WORKDIR}/busybox-${PV}"

DEPENDS = "kern-tools-native flex-native bison-native"

export EXTRA_CFLAGS = "${CFLAGS}"
export EXTRA_LDFLAGS = "${LDFLAGS}"

EXTRA_OEMAKE = "CC='${CC}' LD='${CCLD}' V=1 ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX} SKIP_STRIP=y HOSTCC='${BUILD_CC}' HOSTCPP='${BUILD_CPP}'"

do_configure () {
 cp -a -f ${WORKDIR}/BBconfig-V1.30.1-INITRAMFS ${S}/.config
}

do_compile () {
 oe_runmake
}

do_install () {
 #oe_runmake install
 install -d ${D}/bin
 install -m 755 busybox ${D}/bin
}

SUMMARY = "swiss-army-knife utilities"
HOMEPAGE = "https://busybox.net/"
