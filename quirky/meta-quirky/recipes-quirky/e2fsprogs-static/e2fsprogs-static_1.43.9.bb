# Recipe created by recipetool

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://lib/uuid/COPYING;md5=58dcd8452651fc8b07d1f65ce07ca8af"

SRC_URI = "https://downloads.sourceforge.net/project/e2fsprogs/e2fsprogs/v${PV}/e2fsprogs-${PV}.tar.gz"
SRC_URI[md5sum] = "8749ba4fbc25d1b13753b79f1f84b69d"
SRC_URI[sha256sum] = "5be0ffc01b9720a3f3ccfc86396016baf1334b98751fefa09e0c63eaffdc3897"

DEPENDS = "file util-linux attr"

inherit perlnative texinfo gettext autotools

S = "${WORKDIR}/e2fsprogs-${PV}"
CFLAGS += " -static"
LDFLAGS += " -static"

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-fuse2fs --disable-nls --disable-tdb --disable-mmp --disable-uuidd --disable-defrag --disable-imager --enable-libblkid --enable-libuuid --disable-bmap-stats --disable-debugfs --disable-backtrace"

# warning: -s (strip) does not work for aarch64 target...
do_install () {
 install -d ${D}/usr/bin
 install -d ${D}/usr/sbin
 install -m 755 ${B}/e2fsck/e2fsck ${D}/usr/sbin
 install -m 755 ${B}/misc/badblocks ${D}/usr/sbin
 install -m 755 ${B}/misc/blkid ${D}/usr/sbin
 install -m 755 ${B}/misc/chattr ${D}/usr/bin
 install -m 755 ${B}/misc/dumpe2fs ${D}/usr/sbin
 install -m 755 ${B}/misc/e2freefrag ${D}/usr/sbin
 install -m 755 ${B}/misc/e4crypt ${D}/usr/sbin
 install -m 755 ${B}/misc/lsattr ${D}/usr/bin
 install -m 755 ${B}/misc/mke2fs ${D}/usr/sbin
 install -m 755 ${B}/misc/tune2fs ${D}/usr/sbin
 install -m 755 ${B}/resize/resize2fs ${D}/usr/bin
}

HOMEPAGE = "http://e2fsprogs.sourceforge.net/"
SUMMARY = "ext2/3/4 filesystem utilities"
