# Recipe created by recipetool
# recipetool create -o xf86-video-tga_1.2.2.bb https://www.x.org/archive/individual/driver/xf86-video-tga-1.2.2.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=f8de17b8a7460e29fa09e86125aaad20"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-tga-${PV}.tar.gz \
           file://xf86-video-tga-0001-mibstore.patch"
SRC_URI[md5sum] = "97dd74919c5f9a8485466cc7d2f94b86"
SRC_URI[sha256sum] = "6aa14ea8ba315c1b242bab23797bac0126ec9d76210881c85ecc53dd55b303e2"

DEPENDS += "xproto libpciaccess xextproto fontsproto xserver-xorg libdrm mesa"

inherit pkgconfig autotools

EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg driver for DEC TGA graphics adapters"
