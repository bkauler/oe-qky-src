# Recipe created by recipetool
# recipetool create -o ktsuss_20140304.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/ktsuss-20140304.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=775f0295586945b51d41175844976542"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/ktsuss-${PV}.tar.bz2"
SRC_URI[md5sum] = "572c7f7946f02ff89efa2a4b0e9e6fa7"
SRC_URI[sha256sum] = "dc736a588c16b7e1fa16025feea31eff5be75d8111a8f4582671b413558117cb"

DEPENDS = "glib-2.0 gtk+ sudo"

inherit pkgconfig autotools

# BK 170613 note, ktsuss can use either 'su' or 'sudo' as backend. if the latter,
# need '--enable-sudo=yes' (default is no). My build uses busybox 'su', which isn't
# present, due to how busybox is packaged, so do_configure fails. Probably could fix,
# but use 'sudo'...

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--enable-sudo=yes"


HOMEPAGE = ""
SUMMARY = "ktsuss is a graphical version frontend of su written in C and GTK+ 2"
