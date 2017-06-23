# Recipe created by recipetool
# recipetool create -o xf86-video-neomagic_1.2.9.bb https://www.x.org/archive/individual/driver/xf86-video-neomagic-1.2.9.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=3a6358ddf387f4be24801a5337a021a8"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-neomagic-${PV}.tar.gz"
SRC_URI[md5sum] = "6502a5d5d87abfb946a5edb83d8af7e8"
SRC_URI[sha256sum] = "378a6d307307a6f9a350514c6aa62c8d46ad43b8dc3aa86f941bf25d9e53fc22"

DEPENDS += "libpciaccess xproto fontsproto xserver-xorg libdrm mesa"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Neomagic video driver"
