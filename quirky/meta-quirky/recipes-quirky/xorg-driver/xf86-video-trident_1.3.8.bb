# Recipe created by recipetool
# recipetool create -o xf86-video-trident_1.3.8.bb https://www.x.org/archive/individual/driver/xf86-video-trident-1.3.8.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=2e9eb6db89324a99415a93a059157da7"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-trident-${PV}.tar.gz"
SRC_URI[md5sum] = "ab4d563512f41a8b7d785e1b86a2c365"
SRC_URI[sha256sum] = "d67f5a7bb41fb5eee7db4c8d26b2c2b314945d721dd5ea019e70ac998c1c1e21"

DEPENDS += "xserver-xorg xproto libpciaccess xextproto fontsproto libdrm mesa"

inherit pkgconfig autotools

EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Trident video driver"
