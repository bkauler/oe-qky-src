# Recipe created by recipetool
# recipetool create -o ghasher_1.2.1-p1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/ghasher-1.2.1-patched1.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e06ca24b8ae8d1a4a5607d3923823cd4"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/ghasher-1.2.1-patched1.tar.bz2"
SRC_URI[md5sum] = "c64d836e0b7332bea76d6771d3d0b0a2"
SRC_URI[sha256sum] = "19e600ef5448f9c677ab37065e6757fe4297f006cafd3a9a0a87bd4daa5b5c64"

S = "${WORKDIR}/${BPN}-1.2.1-patched1"

DEPENDS = "gtk+ libglade openssl"
#inherit scons
# hmmm, not using autotools, but need to keep build $B and source $S the same...
inherit pkgconfig gettext autotools-brokensep

# Specify any options you want to pass to scons using EXTRA_OESCONS:
#EXTRA_OESCONS = ""

# BK 170610 oh dear, problem. Makefile compiles 'text2cstring', then runs it to generate
# ghasher-glade.c. however, this will not work in a cross-compile. we probably need
# a ghasher-native pkg, but i am learning OE, don't know how to do that.
# using a ready-made file 'ghasher-glade.c'.
SRC_URI += "file://ghasher-glade.c"

# ...works. another way would be to run host 'gcc' to compile text2cstring.

do_configure() {
    ##Makefile generates this. remove if doing a recompile...
    #if [ -f ghasher-glade.c ];then
    # rm -f ghasher-glade.c
    #fi
    cp -a -f ../ghasher-glade.c ./
    touch ghasher-glade.c #give it latest modify date.
    sed -i -e 's%^gui.o: .*%gui.o: ghasher.h hash.xpm%' Makefile
    true
}

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}/usr/bin
    install -m755 ghasher ${D}/usr/bin
    install -d ${D}/usr/share/applications
    install -m644 ghasher.desktop ${D}/usr/share/applications
    install -d ${D}/usr/share/pixmaps
    install -m644 hash.xpm ${D}/usr/share/pixmaps
}

HOMEPAGE = ""
SUMMARY = "GUI MD5and others sum utility."
