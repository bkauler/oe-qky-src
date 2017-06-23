# Recipe created by recipetool
# recipetool create -o uget_1.8.2.bb https://downloads.sourceforge.net/project/urlget/uget%20%28stable%29/1.8.2/uget-1.8.2.tar.gz

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

SRC_URI = "https://downloads.sourceforge.net/project/urlget/uget%20%28stable%29/${PV}/uget-${PV}.tar.gz"
SRC_URI[md5sum] = "42be57f08f41ffe4f5c4b60a4e8aa079"
SRC_URI[sha256sum] = "268ad65137d72d7ad9aacba71dadb29ea0a1e7b7d4549a0ac89cf1cfcb66e5db"

DEPENDS = "glib-2.0 gtk+ intltool-native curl openssh openssl libxml2 glib-2.0-native"

inherit pkgconfig gettext autotools

EXTRA_OECONF = "--disable-notify --without-gtk3 --disable-gstreamer"


HOMEPAGE = "http://urlget.sourceforge.net/"
SUMMARY = "uGet is a GTK Open Source download manager application."
