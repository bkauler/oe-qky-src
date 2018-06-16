# Recipe created by recipetool

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/main/a/appstream-glib/appstream-glib_${PV}.orig.tar.xz \
      file://01_xappstreamignore.patch \
      file://02_yaml-icon-spec-compliant.patch \
      file://03_Return-proper-warnings-when-using-libyaml.patch \
      file://04_app_kind_strings.patch \
      file://05_all_component_types.patch \
      file://0001-Skip-loading-desktop-data-from-Snap-directory.patch"
SRC_URI[md5sum] = "db006ec0f8371d6fa1b600a43f19a5d0"
SRC_URI[sha256sum] = "ee32f3e4d20b7e8fe58da85f277d2e1821ab845de23cdb61bda4e50c84b9c308"

DEPENDS = "gcab gperf libxslt rpm libarchive gdk-pixbuf util-linux \
        json-glib glib-2.0 gtk+3 intltool-native pango libsoup-2.4 \
        fontconfig freetype gcab-native libyaml"

inherit pkgconfig gettext autotools

EXTRA_OECONF = "--disable-man --disable-gtk-doc-html --enable-static=no --enable-introspection=no"

# Without it, parsing XML files fails (https://github.com/hughsie/fwupd/issues/38).
RDEPENDS_${PN} += "shared-mime-info"

SUMMARY = "GObjects and helper methods to make it easy to read and write AppStream metadata"
HOMEPAGE = "http://people.freedesktop.org/~hughsient/appstream-glib/"

