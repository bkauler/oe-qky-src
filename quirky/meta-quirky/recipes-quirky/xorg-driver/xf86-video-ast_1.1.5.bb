# Recipe created by recipetool
# recipetool create -o xf86-video-ast_1.1.5.bb https://www.x.org/archive/individual/driver/xf86-video-ast-1.1.5.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0b8c242f0218eea5caa949b7910a774b"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-ast-${PV}.tar.gz"
SRC_URI[md5sum] = "fd1f87b354e5af96fd086f206e268157"
SRC_URI[sha256sum] = "5b9d144e7b9783e6ea90c8b9443a5638fc2094213c0e6fc591be5505f598a1b4"

DEPENDS += "fontsproto libpciaccess xproto xserver-xorg"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg ASPEED Technology video driver"
