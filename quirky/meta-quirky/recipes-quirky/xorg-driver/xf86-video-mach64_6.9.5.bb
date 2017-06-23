# Recipe created by recipetool
# recipetool create -o xf86-video-mach64_6.9.5.bb https://www.x.org/archive/individual/driver/xf86-video-mach64-6.9.5.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=be79d1b174a1e5b7e9303201e18d45f4"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-mach64-${PV}.tar.gz"
SRC_URI[md5sum] = "4864011b2ec48849aaea78c05536eedb"
SRC_URI[sha256sum] = "38672f863f4a08c20f30c248555e12dca38fc25793af5214b9e229e6c4fa460d"

DEPENDS += "xproto xf86driproto libdrm fontsproto libpciaccess xextproto xserver-xorg mesa"

inherit pkgconfig autotools

# only because configure is broken for cross-compile...
#EXTRA_OECONF = "--disable-dri"
# no, do it this way:
# ref: http://lists.openembedded.org/pipermail/openembedded-commits/2009-July/104205.html
EXTRA_OECONF = "ac_cv_file__usr_include_xorg_dri_h=yes \
                ac_cv_file__usr_include_xorg_sarea_h=yes \
                ac_cv_file__usr_include_xorg_dristruct_h=yes \
                ac_cv_file__usr_include_xorg_damage_h=yes"


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg driver for ATi Mach64 video chips"
