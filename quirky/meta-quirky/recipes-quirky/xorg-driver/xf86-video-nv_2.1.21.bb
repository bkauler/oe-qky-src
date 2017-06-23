# Recipe created by recipetool
# recipetool create -o xf86-video-nv_2.1.21.bb https://www.x.org/archive/individual/driver/xf86-video-nv-2.1.21.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f26d42045c078fef2e284111eabdd31"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-nv-${PV}.tar.gz"
SRC_URI[md5sum] = "d2de3fc4990249bac07123ea3614b56e"
SRC_URI[sha256sum] = "12d5a3d1e19e9c3197a9344fc1a62bc6693a81dd6f7d7756f5028ff28ba7f61b"

DEPENDS += "xproto fontsproto libpciaccess xserver-xorg xextproto libdrm mesa"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg driver for nVidia video chips"
