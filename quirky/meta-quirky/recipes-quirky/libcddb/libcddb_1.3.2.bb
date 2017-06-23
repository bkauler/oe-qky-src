# Recipe created by recipetool:
# recipetool create -o libcddb_1.3.2.bb https://sourceforge.net/projects/libcddb/files/libcddb/1.3.2/libcddb-1.3.2.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e29c688d912da12b66b73e32b03d812"

SRC_URI = "https://sourceforge.net/projects/libcddb/files/libcddb/${PV}/libcddb-${PV}.tar.bz2"
SRC_URI[md5sum] = "8bb4a6f542197e8e9648ae597cd6bc8a"
SRC_URI[sha256sum] = "35ce0ee1741ea38def304ddfe84a958901413aa829698357f0bee5bb8f0a223b"

# BK libcdio and libcddb seem to have circular dependencies. follow LFS and remove this:
#DEPENDS = "libcdio libcdio-paranoia"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig gettext autotools

# and remove this...
#EXTRA_OECONF = "--with-cdio"


HOMEPAGE = "http://libcddb.sourceforge.net"
SUMMARY = "Libcddb is a C library to access at a CDDB server"
