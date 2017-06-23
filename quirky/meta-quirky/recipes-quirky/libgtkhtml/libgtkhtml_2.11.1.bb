# Recipe created by recipetool
# recipetool create -o libgtkhtml_2.11.1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/libgtkhtml-2.11.1.tar.bz2

# BK 170612 note, libgtkhtml 2.x is used by 'surfer' and 'notecase' for html rendering.

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/libgtkhtml-${PV}.tar.bz2 \
           file://disable-gnome-vfs.patch"
SRC_URI[md5sum] = "a1d1a197dcff8c4571659deef5495e24"
SRC_URI[sha256sum] = "3ca77a0d0f15e94fb654097c2f78cf928194d4c4bf64ff7b2ba408d29c924a57"

DEPENDS = "libxml2 gtk+ gdk-pixbuf libpng"

inherit pkgconfig gettext autotools

# to avoid 'gail' dep:
EXTRA_OECONF = "--disable-accessibility"


HOMEPAGE = "http://www.gnome.org"
SUMMARY = "A HTML engine for GNOME2"
