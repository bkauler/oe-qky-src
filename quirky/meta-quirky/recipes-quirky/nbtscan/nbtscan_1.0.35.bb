# Recipe created by recipetool
# recipetool create -o nbtscan_1.0.35.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/nbtscan-1.0.35.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

# BK 170614 official source is http://www.unixwiz.net/tools/
# however, pkg expansion is to ./, use source from here
SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/nbtscan-${PV}.tar.bz2"
SRC_URI[md5sum] = "0e025252483c5e1b065ede252af276f0"
SRC_URI[sha256sum] = "83fe51a7307a990aba8ecb2f0390ba391460b6fe62921686ece8fd811f031c44"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e 's%^  CFLAGS =%  CFLAGS +=%' makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/usr/sbin
    install -m755 nbtscan ${D}/usr/sbin
}


HOMEPAGE = "http://www.inetcat.net/software/nbtscan.html"
SUMMARY = "Scans for open NETBIOS nameservers on a local or remote TCPIP network."
