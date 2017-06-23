# Recipe created by recipetool
# recipetool create -o libgnomecanvas_2.30.3.bb http://ftp.gnome.org/pub/GNOME/sources/libgnomecanvas/2.30/libgnomecanvas-2.30.3.tar.gz

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/libgnomecanvas/2.30/libgnomecanvas-${PV}.tar.gz"
SRC_URI[md5sum] = "3dbf66a8c492f4e044991669671234e2"
SRC_URI[sha256sum] = "a8ca85e734ab03ecf1fba7d99e01ae2541d0df539c69a7da9414cde928c116da"

DEPENDS = "intltool-native gtk+ libglade libart-lgpl xineramaproto glib-2.0 glib-2.0-native"

inherit perlnative pkgconfig gettext autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

