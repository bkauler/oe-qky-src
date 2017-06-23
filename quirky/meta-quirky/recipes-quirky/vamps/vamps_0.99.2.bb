# Recipe created by recipetool
# recipetool create -o vamps_0.99.2.bb https://downloads.sourceforge.net/project/vamps/Vamps/0.99.2/vamps-0.99.2.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

SRC_URI = "https://downloads.sourceforge.net/project/vamps/Vamps/${PV}/vamps-${PV}.tar.gz"
SRC_URI[md5sum] = "7d438185a2ae95ebb245472d9fa47d06"
SRC_URI[sha256sum] = "9bac71441db55c04a642c786d6427efdb65aa27f4b1719ffa34ebc3869572694"

DEPENDS = "libdvdread"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e "s%^PREFIX    .*%PREFIX    = ${D}/usr%" vamps/Makefile
    sed -i -e 's%^CC         =%# CC         =%' vamps/Makefile
    sed -i -e 's%^CFLAGS    ?= %CFLAGS    += %' vamps/Makefile
    sed -i -e "s%^PREFIX    .*%PREFIX    = ${D}/usr%" play_cell/Makefile
    sed -i -e 's%^CC         =%# CC         =%' play_cell/Makefile
    sed -i -e 's%^CFLAGS    ?= %CFLAGS    += %' play_cell/Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install
}


HOMEPAGE = "http://sourceforge.net/projects/vamps/"
SUMMARY = "Fast MPEG requantiser for Linux"
