# Recipe created by recipetool

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://Artistic-2.0;md5=7806296b9fae874361e6fb10072b7ee3"

SRC_URI = "http://downloads.sourceforge.net/qpdf/qpdf-${PV}.tar.gz"
SRC_URI[md5sum] = "e014bd3ecf1c4d1a520bbc14d84ac20e"
SRC_URI[sha256sum] = "a9fdc7e94d38fcd3831f37b6e0fe36492bf79aa6d54f8f66062cf7f9c4155233"

DEPENDS = "zlib libpcre libxslt"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
# BK configure doesn't create makefile, it already exists, need this...
inherit autotools-brokensep

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
# BK config fails, cannot access /dev/urandom when cross-compiling, disable...
EXTRA_OECONF = "--disable-html-doc --disable-pdf-doc --without-random"

# BK note: qpdf is required by pkg 'cups-filters'.


HOMEPAGE = "http://qpdf.sourceforge.net"
SUMMARY = "A utility for structural contentpreserving transformations on PDF files."
