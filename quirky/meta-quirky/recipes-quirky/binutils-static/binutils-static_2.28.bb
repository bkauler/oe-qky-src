# Recipe created by recipetool
#
LICENSE = "LGPLv3 & GPLv3"
LIC_FILES_CHKSUM = "file://COPYING3.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
                    file://COPYING3;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://ftp.gnu.org/gnu/binutils/binutils-${PV}.tar.bz2"
SRC_URI[md5sum] = "9e8340c96626b469a603c15c9d843727"
SRC_URI[sha256sum] = "6297433ee120b11b4b0a1c8f3512d7d73501753142ab9e2daa13c5a3edd32a72"

S = "${WORKDIR}/binutils-${PV}"

# NOTE: the following prog dependencies are unknown, ignoring: expect yacc gm4 runtest gnum4 byacc lex
DEPENDS = "bison-native m4-native flex-native"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit texinfo autotools-brokensep

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-nls --enable-64-bit-bfd --disable-werror"

do_configure() {
 oe_runconf
}

do_compile() {
    oe_runmake configure-host
    oe_runmake LDFLAGS="${LDFLAGS} -all-static"
}

SUMMARY = "GNU binary utilities"
HOMEPAGE = "http://www.gnu.org/software/binutils/"
