# Recipe created by recipetool
# recipetool create -o xf86-video-i740_1.3.6.bb https://www.x.org/archive/individual/driver/xf86-video-i740-1.3.6.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=c85da4d100605ac6d8d47d47eb2bf191"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-i740-${PV}.tar.gz"
SRC_URI[md5sum] = "b3688d86d8c9b4b885525999abf698c5"
SRC_URI[sha256sum] = "0b4f5f5e34f9805e533729f60b0afea3a4a2f00407c237e2132fa161484383a9"

DEPENDS += "xproto xserver-xorg fontsproto libpciaccess"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Intel i740 video driver"
