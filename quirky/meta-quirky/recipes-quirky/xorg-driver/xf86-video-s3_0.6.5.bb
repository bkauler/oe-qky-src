# Recipe created by recipetool
# recipetool create -o xf86-video-s3_0.6.5.bb https://www.x.org/archive/individual/driver/xf86-video-s3-0.6.5.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0eae1e9f9b6904bf113c02c911019b1a"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-s3-${PV}.tar.gz \
           file://build_fix-s3.patch"
SRC_URI[md5sum] = "65ccfea47e36b2799e8cdd9bda1ab6fa"
SRC_URI[sha256sum] = "37a070258a43acd610908429cc94e68b6d321860d3ff73c5b49c6bb1ad0765fa"

DEPENDS += "libpciaccess fontsproto xproto xserver-xorg libdrm mesa"

inherit pkgconfig autotools

EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg video driver for classic non ViRGE S3 chips"
