# Recipe created by recipetool
# recipetool create -o mpscan_0.1.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/mpscan-0.1.0.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/mpscan-${PV}.tar.bz2"
SRC_URI[md5sum] = "b447e126edb08c50be80fe2a22032635"
SRC_URI[sha256sum] = "5c0c1b19200ab61ac6447bb188a43e50a5e0becc42ee4fe5de843e10c6f86d3e"

DEPENDS = "libx11"
inherit autotools pkgconfig

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""


HOMEPAGE = ""
SUMMARY = "Parallel network scanner that checks for open ports"
