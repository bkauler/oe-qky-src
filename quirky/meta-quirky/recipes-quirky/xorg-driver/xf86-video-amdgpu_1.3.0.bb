# Recipe created by recipetool
# recipetool create -o xf86-video-amdgpu_1.3.0.bb https://www.x.org/archive/individual/driver/xf86-video-amdgpu-1.3.0.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=aabff1606551f9461ccf567739af63dc"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-amdgpu-${PV}.tar.gz"
SRC_URI[md5sum] = "c0c3d95fb2865008f1347bf9f38c0f44"
SRC_URI[sha256sum] = "05f4a1bbd3a0653551cb9871a554ec4b84c35d00a8fb101f772fc154253eb1e0"

# NOTE: unable to map the following pkg-config dependencies: glamor-egl glamor
#       (this is based on recipes that have previously been built and packaged)
DEPENDS += "libdrm xf86driproto eudev xextproto mesa xproto fontsproto xserver-xorg"

inherit pkgconfig autotools

EXTRA_OECONF = ""

HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg amdgpu AMD Radeon video driver"
