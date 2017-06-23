# Recipe created by recipetool
# recipetool create -o xf86-video-nouveau_1.0.15.bb https://www.x.org/archive/individual/driver/xf86-video-nouveau-1.0.15.tar.bz2

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641deddaa80fe7ca88e944e1fd94a94"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-nouveau-${PV}.tar.bz2"
SRC_URI[md5sum] = "717203cb87029cddcbccf7398f9ad8c3"
SRC_URI[sha256sum] = "aede10fd395610a328697adca3434fb14e9afbd79911d6c8545cfa2c0e541d4c"

DEPENDS += "xextproto eudev libdrm libpciaccess mesa"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://nouveau.freedesktop.org/wiki/"
SUMMARY = "The new Xorg driver for nVidia video chips"
