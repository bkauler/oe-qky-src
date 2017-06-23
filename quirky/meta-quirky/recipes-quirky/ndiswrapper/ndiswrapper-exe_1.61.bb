# compile only the utility, not the kernel module.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://downloads.sourceforge.net/project/ndiswrapper/stable/ndiswrapper-${PV}.tar.gz"
SRC_URI[md5sum] = "fe6056a87dfaa1ea7a4500919baf7905"
SRC_URI[sha256sum] = "2ac1847c24cbfa4f48a800b04c9721219614f1663a4ac94af3c7939b45c47584"

S = "${WORKDIR}/ndiswrapper-${PV}"

inherit autotools-brokensep


do_configure_append() {
    sed -i -e 's%^CC =%# CC =%'  ${S}/utils/Makefile
    sed -i -e "s%^CFLAGS =%CFLAGS += %"  ${S}/utils/Makefile
    #do not compile the module...
    sed -i -e 's%^SUBDIRS = utils driver%SUBDIRS = utils%' ${S}/Makefile
    sed -i '/ driver /d' ${S}/Makefile
}

do_install() {
  oe_runmake install DESTDIR=${D}
}

HOMEPAGE = "http://ndiswrapper.sourceforge.net/"
SUMMARY = "NDIS wrapper for Linux"
