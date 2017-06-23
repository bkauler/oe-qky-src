# Recipe created by recipetool
# recipetool create -o xf86-video-i128_1.3.6.bb https://www.x.org/archive/individual/driver/xf86-video-i128-1.3.6.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=47dae2fb2926bd08adffd5128f45190c"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-i128-${PV}.tar.gz \
           file://build_fix-i128.patch"
SRC_URI[md5sum] = "eba826760a2768dff6fd8ca4bc9bb8fd"
SRC_URI[sha256sum] = "07410a0697805d85101a0248f145087ac242ecd41b5f9e30c774768f08871791"

DEPENDS = "libpciaccess xproto xserver-xorg fontsproto"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Number Nine i128 video driver"
