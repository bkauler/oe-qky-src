# Recipe created by recipetool
# https://www.x.org/archive/individual/driver/xf86-video-rendition-4.2.6.tar.gz

require recipes-graphics/xorg-driver/xorg-driver-video.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=1f82ff47b53d054af9757517c438fabb"

SRC_URI = "https://www.x.org/archive/individual/driver/xf86-video-rendition-${PV}.tar.gz"
SRC_URI[md5sum] = "6702345c506bd1339dbc6a8d7235ca6e"
SRC_URI[sha256sum] = "0da3dadfb18f335f53e88f33a6cfb5aa63d6775a63c01d60acd9953158d8c879"

DEPENDS += "libpciaccess xserver-xorg fontsproto xproto mesa libdrm"

inherit pkgconfig autotools

EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "The Xorg driver for RenditionMicron based video cards"
