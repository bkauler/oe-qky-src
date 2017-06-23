# Recipe created by recipetool
# recipetool create -o unclutter_8.bb http://www.ibiblio.org/pub/X11/contrib/utilities/unclutter-8.tar.gz

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "http://www.ibiblio.org/pub/X11/contrib/utilities/unclutter-${PV}.tar.gz \
           file://fix-makefile.patch"
SRC_URI[md5sum] = "1fe32cab8dd765263679618f8704117f"
SRC_URI[sha256sum] = "33a78949a7dedf2e8669ae7b5b2c72067896497820292c96afaa60bb71d1f2a6"

S = "${WORKDIR}/${BPN}"

DEPENDS = "libx11"
inherit pkgconfig

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    #this is an awful makefile, why am i even using it?
    sed -i -e 's% CC = %# CC = %' Makefile
    sed -i -e 's% CFLAGS = % CFLAGS += %' Makefile
    sed -i -e 's%$(LKED) -o $@ %$(LKED) -o $@ $(CFLAGS) $(LDFLAGS) %' Makefile
    sed -i -e 's% INCROOT = %# INCROOT = %' Makefile
    sed -i -e 's% TOP_INCLUDES = .*% TOP_INCLUDES = %' Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    #oe_runmake install DESTDIR=${D}
    install -d ${D}/usr/bin
    install -m755 unclutter ${D}/usr/bin
    install -d ${D}/usr/share/man/man1
    install -m644 unclutter.man ${D}/usr/share/man/man1/unclutter.1
}


HOMEPAGE = "ftp://ftp.x.org/contrib/utilities/"
SUMMARY = "A small tool that hides the X cursor after a period of inactivity"
