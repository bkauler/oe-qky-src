# Recipe created by recipetool
# recipetool create -o xf86-video-mga_1.6.5.bb https://www.x.org/archive/individual/driver/xf86-video-mga-1.6.5.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=bc1395d2cd32dfc5d6c57d2d8f83d3fc"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-mga-${PV}.tar.gz"
SRC_URI[md5sum] = "b2413e3620dcb321967460f17a1ec184"
SRC_URI[sha256sum] = "ae1ddf8d4780f6c5313fe0d23826e302fc65556a6ebcaca751c755c9761928ff"

DEPENDS += "xproto xf86driproto fontsproto xserver-xorg libpciaccess libdrm mesa"

inherit pkgconfig autotools

# because configure broken cross-compile...
#EXTRA_OECONF = "--disable-dri"
# no, do it this way:
# ref: http://lists.openembedded.org/pipermail/openembedded-commits/2009-July/104205.html
EXTRA_OECONF = "ac_cv_file__usr_include_xorg_dri_h=yes \
                ac_cv_file__usr_include_xorg_sarea_h=yes \
                ac_cv_file__usr_include_xorg_dristruct_h=yes"


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Matrox video driver"
