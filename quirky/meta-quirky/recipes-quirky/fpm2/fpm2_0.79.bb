# Recipe created by recipetool
# recipetool create -o fpm2_0.79.bb http://als.regnet.cz/fpm2/download/fpm2-0.79.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "http://als.regnet.cz/fpm2/download/fpm2-${PV}.tar.bz2 \
           file://0001-Add-POTFILES.skip.patch \
           "
SRC_URI[md5sum] = "a1f28d5e3fffc78bf5c70a99287ce443"
SRC_URI[sha256sum] = "d55e9ce6be38a44fc1053d82db2d117cf3991a51898bd86d7913bae769f04da7"

DEPENDS = "intltool-native glib-2.0 glib-2.0-native libxml2 gtk+"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit gettext pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-debug"


HOMEPAGE = "http://als.regnet.cz/fpm2/"
SUMMARY = "An application that allows you to securely store your passwords."
