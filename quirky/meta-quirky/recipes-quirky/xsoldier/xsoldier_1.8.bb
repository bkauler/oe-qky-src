# Recipe created by recipetool
# recipetool create -o xsoldier_1.8.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xsoldier-1.8.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xsoldier-${PV}.tar.bz2"
SRC_URI[md5sum] = "8d3f7672bf441106cdbedee4216f6f00"
SRC_URI[sha256sum] = "5a100bc3fbbe3d39d53587d8f800bc244c7eec40893af9989a8455131fa3d52d"

# note, can optionally use sdl
DEPENDS = "libx11 libxpm libxau libxdmcp libxcb"

inherit autotools-brokensep pkgconfig

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.interq.or.jp/libra/oohara/xsoldier/index.html"
SUMMARY = "A shoot em up game X11based."
