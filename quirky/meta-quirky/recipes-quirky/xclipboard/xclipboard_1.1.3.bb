# Recipe created by recipetool
# recipetool create -o xclipboard_1.1.3.bb https://www.x.org/releases/individual/app/xclipboard-1.1.3.tar.gz

require recipes-graphics/xorg-app/xorg-app-common.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=2b08d9e2e718ac83e6fe2b974d4b5fd8"

SRC_URI = "https://www.x.org/releases/individual/app/xclipboard-${PV}.tar.gz"
SRC_URI[md5sum] = "cee91df9df1b5d63034681546fd78c0b"
SRC_URI[sha256sum] = "a8c335cf166cbb27ff86569503db7e639f85741ad199bfb3ba45dd0cfda3da7f"

#  libx11
DEPENDS += "xproto libxt libxaw libxmu libxkbfile libxpm"

#inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "X clipboard client"
