# Recipe created by recipetool
# recipetool create -o xf86-video-tdfx_1.4.7.bb https://www.x.org/archive/individual/driver/xf86-video-tdfx-1.4.7.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=41f74bf6ac6803f497df136f0896153a"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-tdfx-${PV}.tar.gz"
SRC_URI[md5sum] = "4d785981d052d47d2e6fd0fd726d66f5"
SRC_URI[sha256sum] = "2ce16b23de0736c11e597338c27a914944ac86c302398625b26c498cc09e226a"

DEPENDS += "xserver-xorg xf86driproto fontsproto libdrm xproto libpciaccess"

inherit pkgconfig autotools

#EXTRA_OECONF = ""
# ref: http://lists.openembedded.org/pipermail/openembedded-commits/2009-July/104205.html
# ref: tmp-glibc/work/core2-64-oe-linux/xf86-video-*/*/recipe-sysroot/usr/include/xorg
EXTRA_OECONF = "ac_cv_file__usr_include_xorg_dri_h=yes \
                ac_cv_file__usr_include_xorg_sarea_h=yes \
                ac_cv_file__usr_include_xorg_dristruct_h=yes \
                ac_cv_file__usr_include_xorg_damage_h=yes \
                ac_cv_file__usr_include_xorg_exa_h=yes"


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg tdfx video driver"
