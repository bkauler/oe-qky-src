# Recipe created by recipetool
# recipetool create -o gmeasures_0.7-pi18n.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gmeasures-0.7.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gmeasures-0.7.tar.bz2 \
           file://gmeasures-0.7-i18n.patch"
SRC_URI[md5sum] = "e9cc1f390e7f3493c3d8b75637872179"
SRC_URI[sha256sum] = "cbf301b3f9337bf76e7a0f72b78d9b1fef65925824ec8608cfee3009b0cca9a9"

S = "${WORKDIR}/${BPN}-0.7"

DEPENDS = "gtk+"

# xgettext reads files in src, so need autotools-brokensep...
inherit gettext pkgconfig autotools-brokensep

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

do_install() {
    cd ${B}/src
    install -d ${D}/usr/bin
    install -m755 gmeasures ${D}/usr/bin
    xgettext -d gmeasures -s -o gmeasures.pot --keyword=_ main.c interface.c
    install -d ${D}/usr/share/doc/nls/gmeasures
    install -m644 gmeasures.pot ${D}/usr/share/doc/nls/gmeasures
    cd ${B}
}

HOMEPAGE = ""
SUMMARY = "A simple utility to convert weights and measures and temperature."
