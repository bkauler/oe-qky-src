SECTION = "console/network"
DESCRIPTION = "A small and simple WikiWikiWeb implementation written in C \
and which includes a built in webserver."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/didiwiki-${PV}.tar.bz2"

inherit autotools


SRC_URI[md5sum] = "2b302172d8644e11bc6f01cf2321c425"
SRC_URI[sha256sum] = "efa943b474ef5f98bfb91242be280072d50a345783ff8c1de7b3bb69f97fcfe0"

HOMEPAGE = ""
SUMMARY = "A small simple selfcontained personal wiki engine."
