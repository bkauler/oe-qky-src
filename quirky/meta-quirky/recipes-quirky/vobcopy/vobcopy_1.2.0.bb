# Recipe created by recipetool
# recipetool create -o vobcopy_1.2.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/vobcopy-1.2.0.tar.bz2

SUMMARY = "vobcopy copies DVD .vob files to harddisk"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=dfda322b7902a3ad2d15f4f9cadcc9ab"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/vobcopy-${PV}.tar.bz2 \
           file://02-pointer-type.patch"
SRC_URI[md5sum] = "88f735ccd051093ff40dab4597bc586e"
SRC_URI[sha256sum] = "892504d195d06a80ab283db642eb2ccbf9f1dc6ba5ff0fdfcf7a9cb660f48106"

DEPENDS = "libdvdread"


# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e 's%^DESTDIR =%# DESTDIR =%' Makefile
    sed -i -e 's%^CC     %# CC     %' Makefile
    sed -i -e 's%^PREFIX .*%PREFIX = /usr%' Makefile
    sed -i -e 's%^CFLAGS %# CFLAGS %' Makefile
    sed -i -e 's%^LDFLAGS .*%LDFLAGS += -ldvdread %' Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install DESTDIR=${D}
    install -d ${D}/usr/share/doc/nls/vobcopy
    install -m644 vobcopy.pot ${D}/usr/share/doc/nls/vobcopy
}


HOMEPAGE = "http://vobcopy.org"
