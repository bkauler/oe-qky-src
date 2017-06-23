# Recipe created by recipetool
# recipetool create -o xf86-video-s3virge_1.10.7.bb https://www.x.org/archive/individual/driver/xf86-video-s3virge-1.10.7.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=09743e0f5c076a765cd16697b5b1effb"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-s3virge-${PV}.tar.gz"
SRC_URI[md5sum] = "564239d4da6b5748a912448c309c9ab2"
SRC_URI[sha256sum] = "7778c137a2439c9640afccbd49745a2bcbff5f6c4696720861e7432d6a925c07"

DEPENDS += "libpciaccess xextproto xserver-xorg fontsproto xproto libdrm mesa libx11"

inherit pkgconfig autotools

EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg driver for S3 ViRGE based video cards"
