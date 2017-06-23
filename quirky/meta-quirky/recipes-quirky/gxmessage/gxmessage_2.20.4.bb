# Recipe created by recipetool
# recipetool create -o gxmessage_2.20.4.bb http://homepages.ihug.co.nz/~trmusson/stuff/gxmessage-2.20.4.tar.gz

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://homepages.ihug.co.nz/~trmusson/stuff/gxmessage-${PV}.tar.gz"
SRC_URI[md5sum] = "dbef00c5e9dd1fb3463b08044be7ae8e"
SRC_URI[sha256sum] = "ba2150e6b8c545fbedbee87d7e42e91094bf0cb4a69e6c1b221d191b5b0d203c"

DEPENDS = "gtk+ intltool-native glib-2.0 glib-2.0-native"

inherit gettext pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""


HOMEPAGE = "http://homepages.ihug.co.nz/~trmusson/programs.html#gxmessage"
SUMMARY = "A utility for creating X11 dialog boxes"
