# Recipe created by recipetool
# recipetool create -o homebank_4.6.3.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/h/homebank-4.6.3.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/h/homebank-${PV}.tar.gz"
SRC_URI[md5sum] = "5b5003ac949243a762d02efa70c9182c"
SRC_URI[sha256sum] = "02757e79994fc952419a47b0f009d224045f652b891352ec2050bc6d9306564e"

DEPENDS = "gtk+ glib-2.0 intltool-native libofx glib-2.0-native"

inherit pkgconfig gettext autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--with-ofx"


HOMEPAGE = "http://homebank.free.fr/"
SUMMARY = ""
