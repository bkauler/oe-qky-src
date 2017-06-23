# Recipe created by recipetool
# recipetool create -o xf86-video-savage_2.3.9.bb https://www.x.org/archive/individual/driver/xf86-video-savage-2.3.9.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-savage-${PV}.tar.gz"
SRC_URI[md5sum] = "da9877c7df07719ac329866ca748e84f"
SRC_URI[sha256sum] = "a9af88154582fdad528b106ed86df74b690f921462540bac4ba12c26b26be766"

DEPENDS += "libdrm fontsproto xextproto xserver-xorg xf86driproto libpciaccess xproto mesa libxext"

inherit pkgconfig autotools

#EXTRA_OECONF = ""
# ref: http://lists.openembedded.org/pipermail/openembedded-commits/2009-July/104205.html
# ref: tmp-glibc/work/core2-64-oe-linux/xf86-video-r128/2_6.10.2-r0/recipe-sysroot/usr/include/xorg
EXTRA_OECONF = "ac_cv_file__usr_include_xorg_dri_h=yes \
                ac_cv_file__usr_include_xorg_sarea_h=yes \
                ac_cv_file__usr_include_xorg_dristruct_h=yes \
                ac_cv_file__usr_include_xorg_damage_h=yes \
                ac_cv_file__usr_include_xorg_exa_h=yes"


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg savage video driver"
