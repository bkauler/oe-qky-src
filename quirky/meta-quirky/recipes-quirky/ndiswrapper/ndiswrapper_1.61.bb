# Recipe created by recipetool
# recipetool create -o ndiswrapper_1.61.bb https://downloads.sourceforge.net/project/ndiswrapper/stable/ndiswrapper-1.61.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://downloads.sourceforge.net/project/ndiswrapper/stable/ndiswrapper-${PV}.tar.gz"
SRC_URI[md5sum] = "fe6056a87dfaa1ea7a4500919baf7905"
SRC_URI[sha256sum] = "2ac1847c24cbfa4f48a800b04c9721219614f1663a4ac94af3c7939b45c47584"

inherit module

MODULES_INSTALL_TARGET = "install"
EXTRA_OEMAKE += "KBUILD=${STAGING_KERNEL_DIR}"

# BK 170617 can't figure out how to compile the userland utility. CFLAGS etc are
# setup for the kernel. will split this pkg into two.

SROOT = "${WORKDIR}/recipe-sysroot"

# BK 170617 x86_64, oe sets KBUILD = /mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work-shared/pcx86-64/kernel-source
# looks for .config but not there. it is at 
# /mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work-shared/pcx86-64/kernel-build-artifacts/.config

do_configure_append() {
    sed -i -e 's%$(KBUILD)/.config%$(KBUILD)/../kernel-build-artifacts/.config%' driver/Makefile
    sed -i -e 's%$(KBUILD)/include/generated%$(KBUILD)/../kernel-build-artifacts/include/generated%' driver/Makefile
    #...good, fixes compile of kernel module.
    #now fix utility...
    #sed -i -e 's%^CC =%# CC =%'  utils/Makefile
    #sed -i -e "s%^CFLAGS =%CFLAGS += -I${SROOT}/usr/include %"  utils/Makefile
    #no, do not compile the utility...
    sed -i -e 's%^SUBDIRS = utils driver%SUBDIRS = driver%' Makefile
    sed -i '/ utils /d' Makefile
}

do_install() {
  oe_runmake install DESTDIR=${D}
}

HOMEPAGE = "http://ndiswrapper.sourceforge.net/"
SUMMARY = "NDIS wrapper for Linux"
