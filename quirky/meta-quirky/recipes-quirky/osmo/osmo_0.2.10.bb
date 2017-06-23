# Recipe created by recipetool
# recipetool create -o osmo_0.2.10.bb https://downloads.sourceforge.net/project/osmo-pim/osmo-pim/osmo-0.2.10/osmo-0.2.10.tar.gz

# BK 170618
# optional pkgs: libnotify, gringots, libical (osmo needs a patch to work with recent libnotify >=0.7.0).
# note, cannot upgrade osmo past 0.2.10, as changes from using libgtkhtml to webkit.
# (libgtkhtml is very small, and used by other pkgs,such as notecase and surfer)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "https://downloads.sourceforge.net/project/osmo-pim/osmo-pim/osmo-${PV}/osmo-${PV}.tar.gz \
           file://osmo-0.2.10-96dpi.patch"
SRC_URI[md5sum] = "a774db748228efee96186158d553ade9"
SRC_URI[sha256sum] = "4e911c52ac64a088f8a812b354084e7adedd1b54cb0435995a2cdc1d194d0845"

# NOTE: unable to map the following pkg-config dependencies:
# gtkspell-2.0 libnotify libsyncml-1.0 gringotts
DEPENDS = "pango glib-2.0 libical gtk+ libgtkhtml libxml2 cups"

# did not compile the .po files, needs '-brokensep'...
inherit pkgconfig autotools-brokensep gettext

# refer: https://bbs.archlinux.org/viewtopic.php?id=135319
LDFLAGS += "-Wl,--copy-dt-needed-entries"

EXTRA_OECONF = "--enable-backup=yes --enable-printing=yes --disable-xmltest --disable-gtktest"

do_configure_prepend() {
    sed -i -e 's%$XML2_CONFIG $xml_config_args --cflags%pkg-config --cflags libxml-2.0%' ${S}/configure
    sed -i -e 's%$XML2_CONFIG $xml_config_args --version%pkg-config --version libxml-2.0%' ${S}/configure
    sed -i -e 's%$XML2_CONFIG $xml_config_args --libs%pkg-config --libs libxml-2.0%' ${S}/configure
}

# recreating configure is broken...
do_configure() {
    oe_runconf
}

HOMEPAGE = "http://clayo.org/osmo"
SUMMARY = "diary organiser planner"
