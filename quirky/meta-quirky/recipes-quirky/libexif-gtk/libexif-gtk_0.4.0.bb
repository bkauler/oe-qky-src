# Recipe created by recipetool
# recipetool create -o libexif-gtk_0.4.0.bb https://downloads.sourceforge.net/project/libexif/libexif-gtk/0.4.0/libexif-gtk-0.4.0.tar.gz

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "https://downloads.sourceforge.net/project/libexif/libexif-gtk/${PV}/libexif-gtk-${PV}.tar.gz"
SRC_URI[md5sum] = "61060745d612832faa2911edcc216c30"
SRC_URI[sha256sum] = "4d4ac85dab9f10304f329ab6efd7094eaf88411b76a43b3a32e50edb480fad18"

inherit gettext autotools pkgconfig

DEPENDS = "gtk+ libexif"

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""


HOMEPAGE = "http://libexif.sourceforge.net/"
SUMMARY = "GTK frontend to the libexif library"
