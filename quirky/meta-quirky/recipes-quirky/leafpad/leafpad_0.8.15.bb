DESCRIPTION = "GTK+ based simple text editor"
HOMEPAGE = "http://tarot.freeshell.org/leafpad"
AUTHOR = "Tarot Osuji <tarot@sdf.lonestar.org>"
SECTION = "x11/applications"
SRC_URI = "http://savannah.nongnu.org/download/${PN}/${PN}-${PV}.tar.gz"

PR = "r0"

DEPENDS = "gtk+ intltool-native glib-2.0-native"
# error: "glib-gettextize: command not found"
# but it is there, installed by 'glib-2.0' ...fix set dep 'glib-2.0-native'
# error: intltoolize: command not found ...fix, set dep 'intltool-native'

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

inherit autotools pkgconfig

# Printing feature requires libgnomeprintui-2.2
EXTRA_OECONF = " --enable-chooser --disable-print"


SRC_URI[md5sum] = "f3570c052f4987f4122cd48d2c629f64"
SRC_URI[sha256sum] = "f294a7894efc8eee0c0c4238f41cc97492c61dd3dcceae4fcf555e31e841d86a"

SUMMARY = "A GTK+ based simple text editor"
