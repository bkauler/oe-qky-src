# Recipe created by recipetool
# recipetool create -o inkscapelite_0.36.3-p06.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/inkscapelite-0.36.3.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/inkscapelite-0.36.3.tar.bz2 \
           file://01-inkscapelite-glib.h.patch \
           file://02-inkscapelite-export-dynamic.patch.disabled \
           file://03-inkscapelite-fix-hruler.patch \
           file://04-inkscapelite-fix-vruler.patch \
           file://05-inkscapelite-rulerfontfix-jamesbond.patch \
           file://06-inkscapelite-texttoolcrash-jamesbond.patch"
SRC_URI[md5sum] = "816615d99d1d9673a14c1465c2467924"
SRC_URI[sha256sum] = "e83476d9c8a3af0c47d7d0934991587060fede4ab3cb23e2a92ca4b6f2404088"

S = "${WORKDIR}/${BPN}-0.36.3"

# NOTE: the following prog dependencies are unknown, ignoring: gmsgfmt freetype-config
# NOTE: unable to map the following pkg-config dependencies: libgnomeprintui-2.2 libgnomeprint-2.2
#       (this is based on recipes that have previously been built and packaged)
# NOTE: the following library dependencies are unknown, ignoring: dnet_stub shadow lthread dnet ipc dld compat png pam posix kimgio bsd ucb
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "libxft gtk+ libx11 intltool-native fontconfig flex-native libice libxml2 libart-lgpl"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig gettext autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--with-popt --with-xft --without-gnome-print --disable-mmx"


HOMEPAGE = ""
SUMMARY = "A Gtk SVG Scaleable Vector Graphic application"
