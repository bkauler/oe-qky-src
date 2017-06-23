# Recipe created by recipetool
# recipetool create -o gnome-menus-2.14.3.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/g/gnome-menus-2.14.3.tar.bz2

# BK 20170609 note, use old version for quirky/puppy, as later has broken divided menus.
# only needed for xdg-puppy.

LICENSE = "LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/g/gnome-menus-${PV}.tar.bz2"
SRC_URI[md5sum] = "9926e7ad14255d1a08c7e774052f8a3a"
SRC_URI[sha256sum] = "0bc939a5c8347cfcbd83087f05f517b3a093515a93c104b833f2b05564df14d9"

S = "${WORKDIR}/gnome-menus-${PV}"

DEPENDS = "libxml2 gconf popt gtk+ intltool-native glib-2.0-native glib-2.0"
# error: "glib-gettextize: command not found"
# but it is there, installed by 'glib-2.0' ...fix set dep 'glib-2.0-native'
# error: intltoolize: command not found ...fix, set dep 'intltool-native'

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
# removed: pythonnative 
inherit pkgconfig gettext autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-python --enable-compile-warnings=no"

do_configure_prepend() {
    #there is a syntax error in the generated 'configure' script
    sed -i 's%^GNOME_COMPILE_WARNINGS.*%%' ${S}/configure.in
}
