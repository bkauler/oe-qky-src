DESCRIPTION = "Free multithreaded file transfer client (FTP/HTTP/SSH)."
HOMEPAGE = "http://www.gftp.org/"
SECTION = "x11/network"

DEPENDS = "gtk+ openssl"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3305ea8f1515c82aff287ba72bc88dd8"

inherit autotools gettext pkgconfig

# 170507 BK 2nd two patches failed, so use my ready-patched source...
#SRC_URI = "http://www.gftp.org/gftp-${PV}.tar.bz2 \
#           file://0-configure.patch \
#           file://1-gftp_2.0.19-2ubuntu1.patch \
#           file://2-gftp-2.0.19-expand-path-sigsegv.patch \
#           file://3-gftp-2.0.19-ttuuxxx-icons.patch \
#           "

#SRC_URI[md5sum] = "5183cb4955d94be0e03c892585547c64"
#SRC_URI[sha256sum] = "5306a46be96d6f4d23906cb1836fb3d732039621a6c7fcfa921acc21ac110bfd"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/g/gftp-2.0.19-patched_2ubuntu1_expandedpathsigsegv.tar.bz2 \
           file://oe-configure-in.patch \
           "

S = "${WORKDIR}/gftp-2.0.19-patched_2ubuntu1_expandedpathsigsegv"

SRC_URI[md5sum] = "d8f6114352f522e8d6aeeda5ba4b635e"
SRC_URI[sha256sum] = "2cd86fd33edfdc94e56f3af4f37627e1fcfcdb2b11cf07ce3a054ec3546f41bd"

EXTRA_OECONF = "--disable-textport"

SUMMARY = "A multithreaded ftp client for X"
