# Recipe created by recipetool
# recipetool create -o xf86-video-siliconmotion_1.7.9.bb https://www.x.org/archive/individual/driver/xf86-video-siliconmotion-1.7.9.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=3893e77db70569921f6d79c387b5748a"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-siliconmotion-${PV}.tar.gz"
SRC_URI[md5sum] = "0265ba2c63cb1648b19a1f814d5d0c26"
SRC_URI[sha256sum] = "8be99373a431cfbdeb6b88e42bd9b4bc48a883ba607e49c9eec3702d5e7bd1c7"

DEPENDS += "xextproto fontsproto xserver-xorg xproto libpciaccess libdrm mesa"

inherit pkgconfig autotools

EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Silicon Motion video driver"
