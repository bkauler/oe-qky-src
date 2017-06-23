# Recipe created by recipetool
# recipetool create -o xcalc_1.0.6.bb https://www.x.org/releases/individual/app/xcalc-1.0.6.tar.gz

require recipes-graphics/xorg-app/xorg-app-common.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=1cc25ece7aa5c54ca7fd23b1c9111c23"

SRC_URI = "https://www.x.org/releases/individual/app/xcalc-${PV}.tar.gz"
SRC_URI[md5sum] = "a192ebb5e5f33925c71713501173d8e0"
SRC_URI[sha256sum] = "7fd5cd9a35160925c41cbadfb1ea23599fa20fd26cd873dab20a650b24efe8d1"

#  libx11
DEPENDS += "xproto libxaw libxt libxpm"

#inherit pkgconfig autotools

#EXTRA_OECONF = "--with-appdefaultdir=/usr/share/X11/app-defaults"


HOMEPAGE = "http://www.X.org"
SUMMARY = "A scientific calculator for X"
