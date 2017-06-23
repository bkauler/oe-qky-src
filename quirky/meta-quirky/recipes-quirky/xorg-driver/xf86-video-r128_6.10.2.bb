# Recipe created by recipetool
# recipetool create -o xf86-video-r128_6.10.2.bb https://www.x.org/archive/individual/driver/xf86-video-r128-6.10.2.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7afbe929192be6cccb50f81b968fd23a"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-r128-${PV}.tar.gz"
SRC_URI[md5sum] = "00eb023a9fa9be59db9c09495ad2a0ac"
SRC_URI[sha256sum] = "50ebdb90f8649b0eaa899e55436fe788f93e013555352f31e033c8664a42f018"

DEPENDS += "xf86driproto xserver-xorg xextproto libdrm xproto fontsproto libpciaccess mesa"

inherit pkgconfig autotools

# coz configure broken cross-compile...
#EXTRA_OECONF = "--disable-dri"
# no, do it this way:
# ref: http://lists.openembedded.org/pipermail/openembedded-commits/2009-July/104205.html
# ref: tmp-glibc/work/core2-64-oe-linux/xf86-video-r128/2_6.10.2-r0/recipe-sysroot/usr/include/xorg
EXTRA_OECONF = "ac_cv_file__usr_include_xorg_dri_h=yes \
                ac_cv_file__usr_include_xorg_sarea_h=yes \
                ac_cv_file__usr_include_xorg_dristruct_h=yes \
                ac_cv_file__usr_include_xorg_damage_h=yes \
                ac_cv_file__usr_include_xorg_exa_h=yes"


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg r128 video driver"
