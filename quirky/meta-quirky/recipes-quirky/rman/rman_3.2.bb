# Recipe created by recipetool
# recipetool create -o rman_3.2.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/rman-3.2.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/rman-${PV}.tar.bz2"
SRC_URI[md5sum] = "44021d86e55aa4fbfc648bd74d3732ca"
SRC_URI[sha256sum] = "afc420235b7ffca9643eeb66722c7108d3437dcf20a4c520d27b3b8ebf99c495"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e 's%^BINDIR = .*%BINDIR = /usr/bin%' ${S}/Makefile
    sed -i -e 's%^MANDIR = .*%MANDIR = /usr/share/man/man1%' ${S}/Makefile
    sed -i -e 's%^CC = %# CC = %' ${S}/Makefile
    sed -i -e 's%^CFLAGS = %CFLAGS += %' ${S}/Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 ${B}/rman ${D}/usr/bin 
}


HOMEPAGE = "http://sourceforge.net/projects/polyglotman/"
SUMMARY = "A manual page translator to HTML ASCII TkMan DocBook ..."
