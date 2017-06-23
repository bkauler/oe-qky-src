# Recipe created by recipetool
# recipetool create -o gnet_2.0.8.bb http://ftp.gnome.org/pub/GNOME/sources/gnet/2.0/gnet-2.0.8.tar.bz2

# BK note, 'gnet', 'libsystem' and 'libgtkhtml' are deps of 'helpsurfer'.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3dd751ebf11428ec1875fe5cd212d069"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/gnet/2.0/gnet-${PV}.tar.bz2 \
           file://disable-abstract-socket-test.patch"
SRC_URI[md5sum] = "93327d2fca333d7e54ba2cf54e071165"
SRC_URI[sha256sum] = "14034c7ef571a93f2aca21b2280fa86b35ef5730541d3eb57557dd42d7cc506b"

DEPENDS = "glib-2.0"

inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-gtk-doc"

# requires patch:
# checking for abstract socket namespace availability... configure: error: in `/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gnet/2.0.8-r0/build':
# configure: error: cannot run test program while cross compiling
HOMEPAGE = "http://freshmeat.net/projects/gnet/"
SUMMARY = "A network library"
