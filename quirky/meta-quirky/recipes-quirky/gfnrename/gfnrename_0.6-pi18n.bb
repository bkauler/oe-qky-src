# Recipe created by recipetool
# recipetool create -o gfnrename_0.6-pi18n.bb http://home.hccnet.nl/paul.schuurmans/linux/download/gfnrename-0.6.tar.gz

# i18n ref: http://www.murga-linux.com/puppy/viewtopic.php?t=95490

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://home.hccnet.nl/paul.schuurmans/linux/download/gfnrename-0.6.tar.gz \
           file://gfnrename-0.6-i18n.patch"
SRC_URI[md5sum] = "5beeef1178269f808be246ec3138ea78"
SRC_URI[sha256sum] = "b1f88b7a40030b879bb6d28d54819922ec3a0c91d2f7524aaf991da89c87bfdc"

S = "${WORKDIR}/${BPN}-0.6"

DEPENDS = "gtk+"

inherit pkgconfig gettext autotools-brokensep

EXTRA_OECONF = ""

do_compile() {
    oe_runmake
    cd ${S}/src
    xgettext -d gfnrename -s -o gfnrename.pot --no-wrap --keyword=_ main.c interface.c callbacks.c
    cd ..
}

do_install() {
    install -d ${D}/usr/share/doc
    install -m644 ${S}/README ${D}/usr/share/doc/gfnrename.txt
    install -d ${D}/usr/bin
    install -m755 ${S}/src/gfnrename ${D}/usr/bin
    install -d ${D}/usr/share/doc/nls/gfnrename
    install -m644 ${S}/src/gfnrename.pot ${D}/usr/share/doc/nls/gfnrename
}


HOMEPAGE = ""
SUMMARY = "gFnRename is a simple utility to rename multiple files."
