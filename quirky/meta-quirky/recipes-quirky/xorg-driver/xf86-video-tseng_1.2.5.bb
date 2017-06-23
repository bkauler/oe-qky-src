# Recipe created by recipetool
# recipetool create -o xf86-video-tseng_1.2.5.bb https://www.x.org/archive/individual/driver/xf86-video-tseng-1.2.5.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0a077234e3915957b0b4a1f0ff3f10b7"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-tseng-${PV}.tar.gz \
           file://build_fix-tseng.patch"
SRC_URI[md5sum] = "4de1e306e9edaa40ba41bd8443dd47be"
SRC_URI[sha256sum] = "046eed90ae2ba69428552703ab00160809ed9de948fd20357d61638645705e1d"

DEPENDS += "libpciaccess xproto fontsproto xserver-xorg libdrm mesa"

inherit pkgconfig autotools

EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Tseng Labs video driver"
