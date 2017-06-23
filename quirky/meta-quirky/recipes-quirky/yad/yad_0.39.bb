# Recipe created by recipetool
# recipetool create -o yad_0.39.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/y/yad-0.39.0.tar.bz2

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/y/yad-${PV}.0.tar.bz2"
SRC_URI[md5sum] = "b636bae6eee5772ecbebab5cf8910d6c"
SRC_URI[sha256sum] = "98400e25ffe6a77f8e0137ff52edb4f41d71e48c9baaba783ff4633a99b23803"

S = "${WORKDIR}/${BPN}-${PV}.0"

DEPENDS = "intltool-native glib-2.0 gtk+ gtksourceview2 libxml2 libpng libxpm glib-2.0-native"

inherit pkgconfig gettext autotools

# --disable-gio 
EXTRA_OECONF = "--with-gtk=gtk2 --enable-sourceview --disable-spell --disable-html --with-rgb=/usr/share/X11/rgb.txt"


HOMEPAGE = ""
SUMMARY = "A Gtk+ dialog tool"
