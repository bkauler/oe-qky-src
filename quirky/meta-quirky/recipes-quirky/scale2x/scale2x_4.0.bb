# Recipe created by recipetool
# recipetool create -o scale2x_4.0.bb https://github.com/amadvance/scale2x/releases/download/v4.0/scale2x-4.0.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "https://github.com/amadvance/scale2x/releases/download/v${PV}/scale2x-${PV}.tar.gz"
SRC_URI[md5sum] = "097fc4e4436d1de14cceaee45021b880"
SRC_URI[sha256sum] = "996f2673206c73fb57f0f5d0e094d3774f595f7e7e80fcca8cc045e8b4ba6d32"

DEPENDS = "zlib libpng"

inherit autotools pkgconfig

#EXTRA_OECONF = ""


HOMEPAGE = ""
SUMMARY = "Scale PNG images x2 x4"
