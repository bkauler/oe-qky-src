# Recipe created by recipetool
# recipetool create -o gutenprint_5.2.13pre1.bb https://downloads.sourceforge.net/project/gimp-print/gutenprint-5.2/5.2.13-pre1/gutenprint-5.2.13-pre1.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "https://downloads.sourceforge.net/project/gimp-print/gutenprint-5.2/5.2.13-pre1/gutenprint-5.2.13-pre1.tar.bz2 \
           file://xmli18n-tmp.h"
SRC_URI[md5sum] = "dc29c3302434026679900da7bd2f2278"
SRC_URI[sha256sum] = "52c6860189df75c403d0951e8467512e8992ff8c7ce226be77c11c5e9b09e392"

S = "${WORKDIR}/${BPN}-5.2.13-pre1"

DEPENDS = "readline libtool libusb1 gtk+ flex-native bison-native bzip2 xz gzip cups poppler ghostscript ijs cups-filters gimp"

inherit perlnative pkgconfig gettext autotools

# BK 170612 compiles binary 'src/xml/libs/[lt-]extract-strings' which then tries to run,
# but won't run as cross-compile. i compiled gutenprint in host which created 'xmli18n-tmp.h'
# which have in 'files' folder. see hack below. ***NEED PERMANENT FIX***

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-test --without-doc --disable-samples --enable-libgutenprintui2 --disable-nls"

# BK ah, just having "oe_runconf" in here avoids the rebuilding of 'configure' script
# ...fixes do_configure...
do_configure() {
#    gnu-configize
#    libtoolize --force
    sed -i -e 's%^	\./extract-strings .*%	cat ${WORKDIR}/xmli18n-tmp.h > $@.tmp%' ${S}/src/xml/Makefile.in
    oe_runconf
}

HOMEPAGE = "http://gutenprint.sourceforge.net/"
SUMMARY = "High quality drivers for Canon Epson Lexmark Sony Olympus and PCL"
