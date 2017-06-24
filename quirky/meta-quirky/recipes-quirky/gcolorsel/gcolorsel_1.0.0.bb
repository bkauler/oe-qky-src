# Recipe created by recipetool
# recipetool create -o gcolorsel_1.0.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gcolorsel-1.0.0.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gcolorsel-${PV}.tar.bz2"
SRC_URI[md5sum] = "f9259ac6e4194585d70025205fae0576"
SRC_URI[sha256sum] = "6bfcbe1de8bcb0f0e0f50200dedd10d1a891694904a90ca10a3ee01e3f8cb3ef"

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
    install gcolorsel ${D}/usr/bin
}


HOMEPAGE = "http://nixbit.com/software/gcolorsel-review/"
SUMMARY = "It is a program to select colors with a GTK+ 2.0 interface"
