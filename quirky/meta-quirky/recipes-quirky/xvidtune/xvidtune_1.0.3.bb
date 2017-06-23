# Recipe created by recipetool
# recipetool create -o xvidtune_1.0.3.bb https://www.x.org/releases/individual/app/xvidtune-1.0.3.tar.gz

require recipes-graphics/xorg-app/xorg-app-common.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=fa0b9c462d8f2f13eba26492d42ea63d"

SRC_URI = "https://www.x.org/releases/individual/app/xvidtune-${PV}.tar.gz"
SRC_URI[md5sum] = "e0c31d78741ae4aab2f4bfcc2abd4a3d"
SRC_URI[sha256sum] = "c0e158388d60e1ce054ce462958a46894604bd95e13093f3476ec6d9bbd786d4"

# libx11
DEPENDS += "libxaw libxxf86vm libxt libxmu libxpm xproto"

#inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "Video mode tuner for Xorg"
