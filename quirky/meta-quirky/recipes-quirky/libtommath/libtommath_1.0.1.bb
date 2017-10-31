LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f72771f4af5e8c382974750f9f8701ad"

SRC_URI = "https://github.com/libtom/libtommath/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "591552b883e395748d696a8e2b2b7092"
SRC_URI[sha256sum] = "db2b6e6b512aac5cc9be7e4ffdd15d971c3f03d3fa35f91607bfe1a7fa75a7a7"

# NOTE: the following library dependencies are unknown, ignoring: gcov
#       (this is based on recipes that have previously been built and packaged)

# NOTE: this is a Makefile-only piece of software.

do_configure () {
	sed -i '/ CC = /d' makefile_include.mk
	sed -i '/^LD=/d' makefile_include.mk
	sed -i '/^AR=/d' makefile_include.mk
	sed -i '/^RANLIB=/d' makefile_include.mk
	sed -i -e 's%/usr/local%/usr%' makefile_include.mk
}

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install DESTDIR=${D}
}

HOMEPAGE = "http://www.libtom.net/LibTomMath/"
SUMMARY = "Portable number theoretic multiple-precision integer library"
