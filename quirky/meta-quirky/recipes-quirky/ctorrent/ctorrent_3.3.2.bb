# Recipe created by recipetool
# recipetool create -o ctorrent_3.3.2.bb http://www.rahul.net/dholmes/ctorrent/ctorrent-dnh3.3.2.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://www.rahul.net/dholmes/ctorrent/ctorrent-dnh${PV}.tar.gz"
SRC_URI[md5sum] = "59b23dd05ff70791cd6449effa7fc3b6"
SRC_URI[sha256sum] = "c87366c91475931f75b924119580abd06a7b3cb3f00fef47346552cab1e24863"

S = "${WORKDIR}/${BPN}-dnh${PV}"

DEPENDS = "zlib openssl"
inherit autotools pkgconfig

SROOT = "${WORKDIR}/recipe-sysroot"

EXTRA_OECONF = "--with-ssl=${SROOT}/usr/lib"


HOMEPAGE = ""
SUMMARY = "BitTorrent client."
