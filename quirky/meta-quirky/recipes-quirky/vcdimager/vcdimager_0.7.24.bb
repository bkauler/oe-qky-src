# Recipe created by recipetool
# recipetool create -o vcdimager_0.7.24.bb ftp://mirrors.kernel.org/gnu/vcdimager/vcdimager-0.7.24.tar.gz

# BK 170618 patch is a hack.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "ftp://mirrors.kernel.org/gnu/vcdimager/vcdimager-${PV}.tar.gz \
           file://01-vcdimager-hack-bitwise.patch"
SRC_URI[md5sum] = "3af22978fd79c79d5fda6513b6811145"
SRC_URI[sha256sum] = "075d7a67353ff3004745da781435698b6bc4a053838d0d4a3ce0516d7d974694"

DEPENDS = "libcdio libcdio-paranoia libxml2 popt zlib bzip2"

inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-xmltest"


HOMEPAGE = "http://www.gnu.org/software/vcdimager/"
SUMMARY = "Fullfeatured mastering suite for Super Video CDs"
