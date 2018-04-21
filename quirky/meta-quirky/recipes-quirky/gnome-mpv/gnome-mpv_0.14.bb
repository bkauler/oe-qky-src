# Recipe created by recipetool

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8006d9c814277c1bfc4ca22af94b59ee"

SRC_URI = "https://github.com/gnome-mpv/gnome-mpv/releases/download/v${PV}/gnome-mpv-${PV}.tar.xz"
SRC_URI[md5sum] = "bd8fd399ef92bd129386f8b886e1f81d"
SRC_URI[sha256sum] = "23c9bde58da8ccf0e36c30b7d94d504aca9502288e4bb8ad5425022c4be3720e"

DEPENDS = "gtk+3 glib-2.0 mpv libepoxy glib-2.0-native"

inherit pkgconfig gettext autotools-brokensep

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

# do_install fails:
#  msgfmt: cannot locate ITS rules for io.github.GnomeMpv.appdata.xml.in
# have no idea about this, try a workaround hack...
do_install_prepend() {
 sed -i -e 's%^	$(AM_V_GEN)$(MSGFMT) --xml --template .*%	%' ${S}/data/Makefile
 #is this a stupid thing to do?...
 cp -a -f ${S}/data/io.github.GnomeMpv.appdata.xml.in ${S}/data/io.github.GnomeMpv.appdata.xml
}
