# Recipe created by recipetool
# recipetool create -o xf86-video-glint_1.2.9.bb https://www.x.org/archive/individual/driver/xf86-video-glint-1.2.9.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=724772f5b1ac0f483904fa55275a5b85"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-glint-${PV}.tar.gz"
SRC_URI[md5sum] = "e52104e5c09bfcd727184bb7c7c03183"
SRC_URI[sha256sum] = "a96be6e7a165e65992b207f15f427dc55ea4f1fb2fb6914e2f639e5048bba699"

DEPENDS += "xextproto libpciaccess xproto xserver-xorg"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg GLINTPermedia video driver"
