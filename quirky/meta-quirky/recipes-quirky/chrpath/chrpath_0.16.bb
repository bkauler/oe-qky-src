# Recipe created by recipetool
# recipetool create -o chrpath_0.16.bb https://alioth.debian.org/frs/download.php/latestfile/813/chrpath-0.16.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "https://alioth.debian.org/frs/download.php/latestfile/813/chrpath-${PV}.tar.gz"
SRC_URI[md5sum] = "2bf8d1d1ee345fc8a7915576f5649982"
SRC_URI[sha256sum] = "bb0d4c54bac2990e1bdf8132f2c9477ae752859d523e141e72b3b11a12c26e7b"

inherit autotools

EXTRA_OECONF = ""

SUMMARY = "change the rpath -- where an application looks for libraries"
HOMEPAGE = "https://directory.fsf.org/wiki/Chrpath"
