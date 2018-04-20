# Recipe created by recipetool
# recipetool create -o normalize_0.7.7.bb http://savannah.nongnu.org/download/normalize/normalize-0.7.7.tar.bz2

PR = "r1"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

SRC_URI = "http://savannah.nongnu.org/download/normalize/normalize-${PV}.tar.bz2 \
           file://normalize-fix-aarch64.patch"
SRC_URI[md5sum] = "1749b16fc7a08aa5d0cf9f76eeaa8436"
SRC_URI[sha256sum] = "ef9d8558515cc942518981d3db8fa2490fba6d6b5b74e0a3b75336fbc66c6bd8"

# note, with 'audiofile' pkg can support more audio formats.
DEPENDS = "libmad lame libogg flac libvorbis gtk+ glib-2.0"

inherit gettext perlnative autotools-brokensep

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--with-mad --disable-xmms --disable-gtktest --disable-glibtest"

# do not recreate configure...
do_configure() {
    oe_runconf
}

HOMEPAGE = "http://normalize.nongnu.org/"
SUMMARY = "An audio file volume normalizer"
