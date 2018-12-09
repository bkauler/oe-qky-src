# Recipe created by recipetool
# recipetool create -o qpdf_8.2.1.bb http://downloads.sourceforge.net/qpdf/qpdf-8.2.1.tar.gz

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "http://downloads.sourceforge.net/qpdf/qpdf-${PV}.tar.gz"
SRC_URI[md5sum] = "a11c1f99753934be7d60c0ab43821bbc"
SRC_URI[sha256sum] = "f445d3ebda833fe675b7551378f41fa1971cc6f7a7921bbbb94d3a71a404abc9"

DEPENDS = "zlib libpcre libxslt libjpeg-turbo libxslt-native"

# BK configure doesn't create makefile, it already exists, need this...
inherit autotools-brokensep

# BK config fails, cannot access /dev/urandom when cross-compiling, disable...
EXTRA_OECONF = "--disable-html-doc --disable-pdf-doc --without-random"

# BK note: qpdf is required by pkg 'cups-filters'.

HOMEPAGE = "http://qpdf.sourceforge.net"
SUMMARY = "A utility for structural contentpreserving transformations on PDF files."
