# Recipe created by recipetool
# recipetool create -o evince_2.32.0-p20161004.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/e/evince-2.32.0-patched20161004.tar.gz

# BK 20170610 note, 2.32.0 is last version supports gtk2. patches applied.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=96f2f8d5ee576a2163977938ea36fa7b"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/e/evince-2.32.0-patched20161004.tar.gz \
           file://0001-Add-format-attribute-to-_synctex_malloc.patch \
           "
SRC_URI[md5sum] = "658777c1b2754791b4c6b02301567748"
SRC_URI[sha256sum] = "3901f21219f6c0d04d8fdcd5dcf218fefd4c96ba52ab360d4cfa326dca3015eb"

S = "${WORKDIR}/${BPN}-2.32.0-patched20161004"

DEPENDS = "poppler libxml2 cairo gconf intltool-native glib-2.0 gobject-introspection tiff glib-2.0-native gtk+ gdk-pixbuf"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit gettext pkgconfig gconf autotools

EXTRA_OECONF = "--without-keyring  --disable-scrollkeeper  --disable-dvi  --disable-djvu --disable-nautilus  --disable-dbus  --with-gtk=2.0 --disable-comics --without-gconf --enable-pixbuf --disable-gtk-doc-html --disable-help"

do_configure_prepend() {
    #remove dependency... $B is the build directory, $S is source directory
    sed -i '/gnome-icon-theme/d' ${S}/configure.ac
}

