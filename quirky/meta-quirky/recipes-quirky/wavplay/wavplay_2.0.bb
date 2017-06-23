# Recipe created by recipetool
# recipetool create -o wavplay_2.0.bb https://downloads.sourceforge.net/project/wavplay/Release%20Downloads/wavplay-2.0.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "https://downloads.sourceforge.net/project/wavplay/Release%20Downloads/wavplay-${PV}.tar.gz"
SRC_URI[md5sum] = "9b1d97ae6912225083b38386347cf0b2"
SRC_URI[sha256sum] = "256ea0b581d587b482e0c928869e3896845a5299b8e124c01749b4b9edfeb552"

DEPENDS = "libx11 libxmu libxt alsa-lib"

inherit autotools-brokensep pkgconfig

# only want the cli...
EXTRA_OECONF = "--enable-nox"


HOMEPAGE = ""
SUMMARY = "A simple commandline wav file player."
