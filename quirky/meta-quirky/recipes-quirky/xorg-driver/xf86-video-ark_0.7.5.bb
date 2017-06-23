# Recipe created by recipetool
# recipetool create -o xf86-video-ark_0.7.5.bb https://www.x.org/archive/individual/driver/xf86-video-ark-0.7.5.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=bdb6aed1d4651e3c08a43c49b9b286d7"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-ark-${PV}.tar.gz \
           file://build_fix-ark.patch"
SRC_URI[md5sum] = "f33a56020662ce4a5c656a8f7eea6241"
SRC_URI[sha256sum] = "ce946761b5c3a0252c0c63c9d30a2fa75a86486e021be01ad10e22ea5e3a82e1"

DEPENDS += "libpciaccess"

inherit pkgconfig autotools

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg Ark Logic video driver"
