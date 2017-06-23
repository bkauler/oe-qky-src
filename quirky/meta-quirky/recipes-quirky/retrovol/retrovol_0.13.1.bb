# Recipe created by recipetool
# recipetool create -o retrovol_0.13.1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/retrovol-0.13.1.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=85a40337d04a08e98bb23a27befc5f82"

PV = "0.13.1"
SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/retrovol-0.13.1.tar.bz2"
SRC_URI[md5sum] = "cfff4b244c0983c591e6c4182763ee9b"
SRC_URI[sha256sum] = "a56a2810430bb1b88c838865d3b2ea3b3a1db411f202e2049a55b45dfbf54bbb"

S = "${WORKDIR}/${BPN}-0.13.1"

inherit gettext autotools pkgconfig
DEPENDS = "gtk+ alsa-lib alsa-utils"

#EXTRA_OECONF = ""

do_install_append() {
    install -d ${D}/usr/share/doc/nls/retrovol
    install -m644 ${S}/po/retrovol.pot ${D}/usr/share/doc/nls/retrovol/
}

HOMEPAGE = ""
SUMMARY = "A retrolooking volume setting program for Linux."
