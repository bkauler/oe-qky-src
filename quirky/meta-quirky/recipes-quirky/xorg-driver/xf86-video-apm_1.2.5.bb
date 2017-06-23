# Recipe created by recipetool
# recipetool create -o xf86-video-apm_1.2.5.bb https://www.x.org/archive/individual/driver/xf86-video-apm-1.2.5.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0b302c1eb730ff7a191f2cbdc952f689"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-apm-${PV}.tar.gz \
           file://build_fix-apm.patch"
SRC_URI[md5sum] = "ec198922293a34d3f0956f21e6d3a07c"
SRC_URI[sha256sum] = "8cbde30ecbad6e27f54745443ead630d99d620ec759fc99ef58ab876f796c9c3"

DEPENDS += "libpciaccess xextproto"

inherit pkgconfig autotools

# um, this is probably not good... take it out...
# EXTRA_OECONF = "--enable-xaa"


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Alliance ProMotion video driver"
