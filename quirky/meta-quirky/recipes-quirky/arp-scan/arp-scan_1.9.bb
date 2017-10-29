LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/royhills/arp-scan/releases/download/${PV}/arp-scan-${PV}.tar.gz"
SRC_URI[md5sum] = "38584d6c1edfa9f6b41d496e4a5539f1"
SRC_URI[sha256sum] = "ce908ac71c48e85dddf6dd4fe5151d13c7528b1f49717a98b2a2535bd797d892"

DEPENDS = "libpcap"

inherit autotools pkgconfig

EXTRA_OECONF = ""

HOMEPAGE = "https://github.com/royhills/arp-scan"
SUMMARY = "Utility to scan network of a certain interface for alive hosts"
