# Recipe created by recipetool
# recipetool create -o gpart_0.1h.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gpart-0.1h.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0c56db0143f4f80c369ee3af7425af6e"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gpart-${PV}.tar.bz2 \
           file://errno.patch \
           file://largefile.patch \
           file://ntfs.patch \
           file://vfat.patch"
SRC_URI[md5sum] = "8c62420f489c2b741f034c14812a7b7b"
SRC_URI[sha256sum] = "c91f298ef8d278ddf76bb820d8d97fdb7b92487eaf718a6d8ddc955896d635e3"

# BK 170611 Makefile only. does not create a separate $B (build) dir.

do_configure () {
    sed -e 's%/usr/local%/usr%' inst.defs
    echo 'MAKEDEP = $(CC) -M
INSTALL = install
RM      = rm -f
prg     = gpart
version = 0.1h' > make.defs
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/usr/sbin
    install -m755 src/gpart ${D}/usr/sbin
}


HOMEPAGE = "http://home.pages.de/~michab/gpart/"
SUMMARY = "Partition table recovery tool"
