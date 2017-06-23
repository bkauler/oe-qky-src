# Recipe created by recipetool
# recipetool create -o xload_1.1.2.bb https://www.x.org/archive/individual/app/xload-1.1.2.tar.bz2

require recipes-graphics/xorg-app/xorg-app-common.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=95a73d76a420c774909b0df8cd45cbe3"

SRC_URI = "https://www.x.org/archive/individual/app/xload-${PV}.tar.bz2"
SRC_URI[md5sum] = "b9e9808db18acecf4cdec134d86b157c"
SRC_URI[sha256sum] = "83f8e6260435f1df2e2e5036bb3325688b79f0b33069ef445eff5058d127e078"

DEPENDS += "libxt libxaw libxmu libxpm xproto libxau libxext"

inherit pkgconfig autotools gettext

#EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "System load average display for X"
