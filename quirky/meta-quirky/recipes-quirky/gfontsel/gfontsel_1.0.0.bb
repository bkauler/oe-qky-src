# Recipe created by recipetool
# recipetool create -o gfontsel_1.0.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gfontsel-1.0.0.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gfontsel-${PV}.tar.bz2"
SRC_URI[md5sum] = "f0d1317b8af6bfad9fcca25e342f02e6"
SRC_URI[sha256sum] = "501061c2ea2e1dda4707cca6f1dc3cad891ae22d062080fd8b62546291ce77f2"

DEPENDS = "gtk+ gdk-pixbuf"
inherit pkgconfig gettext

do_configure () {
    sed -i -e 's%/usr/local%/usr%' Makefile
    sed -i -e 's%^CC = %# CC = %' Makefile
    sed -i -e 's%^CFLAGS = %CFLAGS += %' Makefile
    sed -i -e 's%^LFLAGS = %LFLAGS = $(LDFLAGS) %' Makefile
    oe_runmake depend
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/usr/bin
    install gfontsel ${D}/usr/bin
}


HOMEPAGE = "http://nixbit.com/software/gfontsel-review/"
SUMMARY = "gfontsel is a simple wrapper around the GTK+ 2 font selection dialog."
