# Recipe created by recipetool
# recipetool create -o sgml-common_0.6.3.bb ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/sgml-common-0.6.3.tgz

# BK 170611 sgml-common is required by opensp, which is required by libofx, which is
# optional requirement of grisbi and homebank.

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/sgml-common-${PV}.tgz \
           file://sgml-common-0.6.3-manpage-1.patch"
SRC_URI[md5sum] = "103c9828f24820df86e55e7862e28974"
SRC_URI[sha256sum] = "7dc418c1d361123ffc5e45d61f1b97257940a8eb35d0bfbbc493381cc5b1f959"

inherit autotools-brokensep

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""


HOMEPAGE = ""
SUMMARY = ""
