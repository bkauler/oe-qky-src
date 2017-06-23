# Recipe created by recipetool
# recipetool create -o ijs_0.35.bb https://www.openprinting.org/download/ijs/download/ijs-0.35.tar.bz2

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;md5=6f2f06909c6fd797a9521cd23168ecd0"

SRC_URI = "https://www.openprinting.org/download/ijs/download/ijs-${PV}.tar.bz2"
SRC_URI[md5sum] = "896fdcb7a01c586ba6eb81398ea3f6e9"
SRC_URI[sha256sum] = "11a5f5084488c480f3ff5a24d64d7147bb64272bf60a0ba51330a56c5b50cab9"

# NOTE: the following prog dependencies are unknown, ignoring: db2ps ps2pdf
DEPENDS = "ghostscript"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""


HOMEPAGE = "http://www.linuxprinting.org/ijs/"
SUMMARY = "A protocol for transmission of raster page images."
