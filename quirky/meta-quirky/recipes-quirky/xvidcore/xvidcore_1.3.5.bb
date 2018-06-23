# Recipe created by recipetool

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=713496289346a6c1c265f0e1f615ecd0"

SRC_URI = "http://downloads.xvid.org/downloads/xvidcore-${PV}.tar.gz"
SRC_URI[md5sum] = "69784ebd917413d8592688ae86d8185f"
SRC_URI[sha256sum] = "165ba6a2a447a8375f7b06db5a3c91810181f2898166e7c8137401d7fc894cf0"

S = "${WORKDIR}/${BPN}/build/generic"

#DEPENDS = ""
inherit autotools-brokensep pkgconfig

# otherwise, needs yasm
EXTRA_OECONF = " --disable-assembly"

# ref: http://www.linuxfromscratch.org/blfs/view/svn/multimedia/xvid.html
do_configure_prepend() {
 sed -i 's/^LN_S=@LN_S@/& -f -v/' platform.inc.in
}

do_install_prepend () {
 sed -i '/libdir.*STATIC_LIB/ s/^/#/' Makefile
}

SUMMARY = "XviD is an MPEG-4 compliant video CODEC"
HOMEPAGE = "https://www.xvid.com/"
