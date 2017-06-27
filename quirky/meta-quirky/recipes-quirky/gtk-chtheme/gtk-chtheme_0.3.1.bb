# Recipe created by recipetool
# recipetool create -o gtk-chtheme_0.3.1.bb http://plasmasturm.org/code/gtk-chtheme/gtk-chtheme-0.3.1.tar.bz2

SUMMARY = "Gtk+ 2.0 theme preview and selection made slick."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://plasmasturm.org/code/gtk-chtheme/gtk-chtheme-${PV}.tar.bz2 \
           file://01-gtk-chtheme-0.3.1-implicit.patch \
           file://02-gtk-chtheme-0.3.1-asneeded.patch \
           file://03-gtk-chtheme-0.3.1-qgtkstyle.patch"
SRC_URI[md5sum] = "f688053bf26dd6c4f1cd0bf2ee33de2a"
SRC_URI[sha256sum] = "26f4b6dd60c220d20d612ca840b6beb18b59d139078be72c7b1efefc447df844"

# BK 170611 Makefile only.
DEPENDS = "gtk+"
inherit pkgconfig

do_configure () {
    sed -i -e 's%^CFLAGS := %# CFLAGS := %' Makefile
    sed -i -e 's%^LDFLAGS = %LDFLAGS += %' Makefile
    #buildPi cross-compile, remove strip:
    sed -i '/strip/d' Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install DESTDIR=${D}
}


HOMEPAGE = "http://plasmasturm.org/code/gtk-chtheme/"
