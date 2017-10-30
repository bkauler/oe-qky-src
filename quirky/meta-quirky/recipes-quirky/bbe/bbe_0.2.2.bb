LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

SRC_URI = "https://downloads.sourceforge.net/project/bbe-/bbe/${PV}/bbe-${PV}.tar.gz \
           file://bbe-10-manpage.patch \
           file://bbe-20-html.patch"

SRC_URI[md5sum] = "b056d0bfd852384aced73d4533887d4b"
SRC_URI[sha256sum] = "baaeaf5775a6d9bceb594ea100c8f45a677a0a7d07529fa573ba0842226edddb"

inherit autotools pkgconfig

HOMEPAGE = "https://sourceforge.net/projects/bbe-/"
SUMMARY = "bbe is a sed-like editor for binary files"

