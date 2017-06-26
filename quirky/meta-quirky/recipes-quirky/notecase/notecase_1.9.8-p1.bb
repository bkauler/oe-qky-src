# Recipe created by recipetool
# recipetool create -o notecase_1.9.8-p1.bb https://downloads.sourceforge.net/project/notecase/notecase/1.9.8/notecase-1.9.8_src.tar.gz

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://deb/copyright;md5=b02a353a366d7ce1e6d22131ba8c0382"

SRC_URI = "https://downloads.sourceforge.net/project/notecase/notecase/1.9.8/notecase-1.9.8_src.tar.gz \
           file://01-notecase-1.9.8-gcc44-official.patch \
           file://02-notecase-1.9.8-gtksourceview.patch"
SRC_URI[md5sum] = "9fe7d2db959d4c457d53313bb8faac35"
SRC_URI[sha256sum] = "0b7e23ec97efd5cd4ada651ac93273f9e5ed2cfff027abfb4ae130039563b746"

S = "${WORKDIR}/${BPN}-1.9.8"

DEPENDS = "gtk+ zlib gtksourceview2 glib-2.0 libxml2 fontconfig freetype libx11"
inherit pkgconfig gettext
LDFLAGS_append = " -lX11"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e 's%^AUTODETECT_GNOME_VFS.*%#AUTODETECT_GNOME_VFS=1%' Makefile
    sed -i -e 's%^HAVE_GNOME_VFS.*%HAVE_GNOME_VFS=%' Makefile
    sed -i -e 's%HAVE_GNOME_VFS=1%HAVE_GNOME_VFS=%' Makefile
    #something odd, this is unset but gets set somehow in this file...
    sed -i -e 's%^#ifdef HAVE_GNOME_VFS%#ifdef HAVE_GNOME_VFSxxxxx%' src/main.cpp
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install DESTDIR=${D}
}


SUMMARY = "A hierarchical text notes manager."
HOMEPAGE = "http://notecase.sourceforge.net/index1.html"
