DESCRIPTION = "Extremely lightweight and fast with low memory usage"
PR = "r0"

DEPENDS = "gtk+ glib-2.0-native intltool-native"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.xz"
#http://downloads.sourceforge.net/lxde/gpicview-0.2.5.tar.xz

inherit autotools pkgconfig gettext

SRC_URI[md5sum] = "26be9b0c5a234f1afe7d83d02a4a33f4"
SRC_URI[sha256sum] = "38466058e53702450e5899193c4b264339959b563dd5cd81f6f690de32d82942"

# error: "glib-gettextize: command not found"
# but it is there, installed by 'glib-2.0' ...fix set dep 'glib-2.0-native'
# error: intltoolize: command not found ...fix, set dep 'intltool-native'


 
HOMEPAGE = "http://lxde.org"
SUMMARY = ""
