LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=79808397c3355f163c012616125c9e26"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/hardinfo-${PV}.tar.bz2"
SRC_URI[md5sum] = "cd2870aee63c8230a4f8fc29a59f6716"
SRC_URI[sha256sum] = "447a67c45404d13e5aa2534faf1be0e1b790dd900f2a82407e1a3531ad151c88"

# libsoup is an optional dep
DEPENDS = "gtk+ zlib"
inherit cmake pkgconfig gettext

EXTRA_OECMAKE = "-DCMAKE_INSTALL_PREFIX=/usr"

HOMEPAGE = "https://github.com/lpereira/hardinfo"
SUMMARY = "A system profiler and benchmark for Linux systems"
