# Recipe created by recipetool
# recipetool create -o nenscript_1.13.3.bb http://www.ai.mit.edu/projects/im/magnus/nenscript/nenscript-1.13.3.tar.bz2

LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/PD;md5=b3597d12946881e13cb3b548d1173851"

SRC_URI = "http://www.ai.mit.edu/projects/im/magnus/nenscript/nenscript-${PV}.tar.bz2"
SRC_URI[md5sum] = "606f0966b893150ce70baed025a192f0"
SRC_URI[sha256sum] = "4e8811598891f956cbd54de0fb99744f71f9d68fe143d025ec91983df557e46e"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e "s%^INSTALLDIR	=.*%INSTALLDIR	= ${D}/usr%" makefile
    sed -i -e 's%^CFLAGS	=%CFLAGS	+=%' makefile
    sed -i -e 's%^LFLAGS	=%# LFLAGS	=%' makefile
    sed -i -e 's%/usr/ucb/install%install%' makefile
    sed -i -e 's%555%755%' makefile
    sed -i -e 's%444%644%' makefile
    #cross-compile, stripping fails...
    sed -i -e 's% \-s % %' makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/usr/bin
    install -d ${D}/usr/man/man1
    oe_runmake install
}


HOMEPAGE = "http://risacher.org/nenscript/"
SUMMARY = "Converts text files to PostScript."
