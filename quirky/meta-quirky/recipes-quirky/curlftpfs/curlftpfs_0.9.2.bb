# Recipe created by recipetool
# recipetool create -o curlftpfs_0.9.2.bb https://downloads.sourceforge.net/project/curlftpfs/curlftpfs/0.9.2/curlftpfs-0.9.2.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "https://downloads.sourceforge.net/project/curlftpfs/curlftpfs/${PV}/curlftpfs-${PV}.tar.gz"
SRC_URI[md5sum] = "b452123f755114cd4461d56c648d9f12"
SRC_URI[sha256sum] = "4eb44739c7078ba0edde177bdd266c4cfb7c621075f47f64c85a06b12b3c6958"

DEPENDS = "glib-2.0 fuse curl zlib openssl openssh"

inherit pkgconfig autotools

SROOT = "${WORKDIR}/recipe-sysroot"

EXTRA_OECONF = "--with-libcurl=${SROOT}/usr/lib"


HOMEPAGE = "http://curlftpfs.sourceforge.net"
SUMMARY = "A filesystem for accessing FTP hosts based on FUSE and libcurl"
