# Recipe created by recipetool
# recipetool create -o gphotofs_0.5.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gphotofs-0.5.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gphotofs-${PV}.tar.bz2"
SRC_URI[md5sum] = "bf88054e726e27b9c699ac4ed594cdf6"
SRC_URI[sha256sum] = "676ec4de69a81c193ffc31bdc7b587ac2a2cc3780b14f0e7c9c4c0a517b343cc"

DEPENDS = "glib-2.0 fuse libgphoto2 glib-2.0-native"

inherit gettext pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--with-libgphoto2=auto"


HOMEPAGE = "http://www.gphoto.org/proj/gphotofs/"
SUMMARY = "The GNU Digital Still Camera Programs"
