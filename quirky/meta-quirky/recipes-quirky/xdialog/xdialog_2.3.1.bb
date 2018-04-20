DESCRIPTION = "Xdialog is a X11 replacement for the dialog text utility."

DEPENDS = "gtk+ openssh openssl"

PR = "r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xdialog-2.3.1-patched_20150811.tar.bz2 \
	   file://fix-duplicates.patch \
	   file://xdialog-fix-aarch64.patch"

S = "${WORKDIR}/xdialog-2.3.1-patched_20150811"

inherit autotools gettext pkgconfig

# avoid rebuilding 'configure' script...
do_configure() {
	oe_runconf
}

SRC_URI[md5sum] = "dd54dea164727c0b0dd32e6cfbc5f1a3"
SRC_URI[sha256sum] = "a7aec90ff7f9c9efee006699de1f519360272b4b41277a8c206466813cf937f0"

EXTRA_OECONF = "--with-gtk2 --disable-gtktest"

HOMEPAGE = "http://xdialog-gtk.cjb.net/"
SUMMARY = "A utility for creating X11 dialog boxes"
