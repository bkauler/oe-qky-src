# Recipe created by recipetool
# recipetool create -o imake_1.0.7.bb https://www.x.org/releases/individual/util/imake-1.0.7.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b9c6cfb044c6d0ff899eaafe4c729367"

SRC_URI = "https://www.x.org/releases/individual/util/imake-${PV}.tar.gz"
SRC_URI[md5sum] = "186ca7b8ff0de8752f2a2d0426542363"
SRC_URI[sha256sum] = "6bda266a07eb33445d513f1e3c82a61e4822ccb94d420643d58e1be5f881e5cb"

DEPENDS = "xproto libx11"

inherit perlnative pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""


HOMEPAGE = "http://www.X.org"
SUMMARY = "A make preprocessor"
