# this is the last version supporting gtk2

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

PR = "r1"
SRC_URI = "https://download.gnome.org/sources/vte/0.28/vte-${PV}.tar.bz2 \
           file://cve-2012-2738.patch \
           file://obsolete_automake_macros.patch \
           file://make_alt_work.patch \
           file://scroll_region.patch \
           file://bracketed_paste_mode_fix.patch"

SRC_URI[md5sum] = "f07a4bf943194f94b7f142db8f7f36dc"
SRC_URI[sha256sum] = "8d04e202b617373dfb47689e5e628febe2c58840b34cccc4af4feb88c48df903"

#DEPENDS = "intltool-native glib-2.0 ncurses libpcre2 libxml2-native gtk+"
DEPENDS = "intltool-native glib-2.0 ncurses libpcre libxml2-native gtk+"

inherit pkgconfig gettext pythonnative autotools distro_features_check gobject-introspection

CFLAGS += "-D_GNU_SOURCE -fno-strict-aliasing"

# do we want this?  --enable-introspection
EXTRA_OECONF = "--enable-introspection --disable-python --with-gtk=2.0 --disable-gnome-pty-helper"

# libtool adds "-nostdlib" when g++ is used. This breaks PIE builds.
# Use libtool-cross (which has a hack to prevent that) instead.
EXTRA_OEMAKE_class-target = "LIBTOOL=${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool"

PACKAGES =+ "libvte"
FILES_libvte = "${libdir}/*.so.* ${libdir}/girepository-1.0/*"

#do_configure_append () {
# sed -i -e 's/ -shared / -Wl,-O1,--as-needed\0/g' ${B}/libtool
#}

HOMEPAGE = "https://github.com/GNOME/vte"
SUMMARY = "VTE is a library implementing a terminal emulator widget for GTK+ and a minimal sample application"
