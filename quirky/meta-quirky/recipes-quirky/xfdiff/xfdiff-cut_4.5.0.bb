# Recipe created by recipetool
# recipetool create -o xfdiff-cut_4.5.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xfdiff-cut-4.5.0.tar.bz2

PR = "r1"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xfdiff-cut-${PV}.tar.bz2 \
           file://xfdiff-fix-aarch64.patch"
SRC_URI[md5sum] = "989d1520ad6b4c89733827df06f47793"
SRC_URI[sha256sum] = "f9b037ac5222058a5f7204eb803612fc6078190f17d1eb6ed1cb8971f641a5d1"

DEPENDS = "intltool-native gtk+ glib-2.0 libtubo diffutils patch libpng"

inherit autotools-brokensep pkgconfig gettext

#EXTRA_OECONF = ""

#do_configure_prepend() {
#    oe_runmake distclean
#}

#do_configure() {
#    oe_runconf
#}



HOMEPAGE = ""
SUMMARY = "Graphical diff"
