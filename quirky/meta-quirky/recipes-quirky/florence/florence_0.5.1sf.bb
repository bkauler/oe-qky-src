# Recipe created by recipetool
# recipetool create -o florence_0.5.1sf.bb https://downloads.sourceforge.net/project/florence/florence/0.5.1/florence-0.5.1.tar.bz2

# BK 170618 meta-gnome/recipes-support has florence, version 0.5.4, but this needs gstreamer.
# i am building without gstreamer, so using older version.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "https://downloads.sourceforge.net/project/florence/florence/0.5.1/florence-0.5.1.tar.bz2 \
           file://0001-Add-nonet-option-to-xmllint-and-xsltproc-calls.patch \
           file://0003-Explicitly-link-libX11-to-florence_applet.patch"
SRC_URI[md5sum] = "56d12e5b47c100d9df172aa5ddc0f609"
SRC_URI[sha256sum] = "7b06ed84ef2b7b22d8d2cf0c7d013a05409bd82028240ac8719a68b192d5bc62"

S = "${WORKDIR}/${BPN}-0.5.1"

# need gconf-native to fix install...
DEPENDS = "libxtst libx11 gtk+ intltool-native gconf libglade libxml2 cairo librsvg glib-2.0 glib-2.0-native gnome-doc-utils-stub gconf-native"

# need gconf class to fix install...
inherit pkgconfig gettext autotools gconf

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--without-ramble --without-panelapplet --without-at-spi --without-notification --without-docs --disable-gtktest --disable-scrollkeeper --disable-schemas-install"


HOMEPAGE = ""
SUMMARY = ""
