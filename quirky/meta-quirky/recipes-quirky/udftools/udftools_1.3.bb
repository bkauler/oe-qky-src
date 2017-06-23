# Recipe created by recipetool
# recipetool create -o udftools_1.3.bb http://archive.ubuntu.com/ubuntu/pool/universe/u/udftools/udftools_1.3.orig.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/u/udftools/udftools_${PV}.orig.tar.gz"
SRC_URI[md5sum] = "0a7d470730fe293157fd17a1a2742b1a"
SRC_URI[sha256sum] = "00562a440de7b855df8127f8f798df657d53f20d9a205a7041fed37c8a07d4cb"

DEPENDS = "readline cdrkit cdrtools-native dvd+rw-tools eudev"

inherit autotools-brokensep pkgconfig

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""


HOMEPAGE = "http://sourceforge.net/projects/linux-udf/"
SUMMARY = "Filesystem utilities for UDF"
