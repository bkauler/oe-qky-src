# Recipe created by recipetool
# recipetool create -o xf86-video-sis_0.10.9.bb https://www.x.org/archive/individual/driver/xf86-video-sis-0.10.9.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=cbbdd887d04deb501076c22917e2030d"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-sis-${PV}.tar.gz"
SRC_URI[md5sum] = "48ae561a49e2478d1d6510a4cab488f8"
SRC_URI[sha256sum] = "7696cbc5991b770824842b0183498a5911f924f4963dcc867a0e6657c0f6cffe"

DEPENDS += "xproto xserver-xorg libpciaccess xf86dgaproto libdrm xf86driproto xextproto fontsproto mesa"

inherit pkgconfig autotools

#EXTRA_OECONF = ""
# ref: http://lists.openembedded.org/pipermail/openembedded-commits/2009-July/104205.html
# ref: tmp-glibc/work/core2-64-oe-linux/xf86-video-*/*/recipe-sysroot/usr/include/xorg
EXTRA_OECONF = "ac_cv_file__usr_include_xorg_dri_h=yes \
                ac_cv_file__usr_include_xorg_sarea_h=yes \
                ac_cv_file__usr_include_xorg_dristruct_h=yes"


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg sis video driver"

