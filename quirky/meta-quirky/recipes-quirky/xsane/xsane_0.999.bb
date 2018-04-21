# Recipe created by recipetool
# recipetool create -o xsane-0.999.bb http://www.xsane.org/download/xsane-0.999.tar.gz

# 180421 ***BROKEN***
# aarch64, configure works (no error) but no Makefile generated.

SUMMARY = "XSane is a graphical frontend for scanners. It uses the library SANE."
HOMEPAGE = "http://www.xsane.org/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://xsane.COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

# patches from debian: https://packages.ubuntu.com/artful/xsane
SRC_URI = "http://www.xsane.org/download/xsane-${PV}.tar.gz \
           file://0600-man_misleading.patch \
           file://0125-desktop_file.patch \
           file://0170-typo.patch \
           file://0605-typo_manpage.patch \
           file://0130-fix_options_handling_fix.patch \
           file://0140-fix_pdf_xref.patch \
           file://0135-fix_pdf_floats.patch \
           file://0610-fix_broken_links.patch \
           file://0910-fix_message_typo.patch \
           file://0900-i18n_po_update_es_add_gl.patch \
           file://0905-i18n_po_update_fr.patch \
           file://0150-fix_preview_mouse_events.patch \
           file://0155-fix_spin_button_pagesize.patch \
           file://0160-fix_tighten_default_umask.patch \
           file://0145-fix_png15.patch \
           file://0165-xsane-0.999-lcms2.patch \
           file://0001-lcms2_configure.patch \
           file://0005-m4.patch"
SRC_URI[md5sum] = "9927f21e1ab6ba96315e7f0e30746deb"
SRC_URI[sha256sum] = "5782d23e67dc961c81eef13a87b17eb0144cae3d1ffc5cf7e0322da751482b4b"

S = "${WORKDIR}/xsane-${PV}"

DEPENDS = "zlib libjpeg-turbo tiff gtk+ sane-backends libpng lcms"

# removed autotools-brokensep
inherit pkgconfig gettext autotools-brokensep

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--enable-gtk2 --disable-gtktest --disable-sanetest"

# use the existing 'configure' script...
XXXXdo_configure () {
 oe_runconf
}

# not needed, see libpng15 patch above
## ref: http://www.linuxfromscratch.org/blfs/view/svn/pst/xsane.html
#do_configure_prepend() {
# sed -i -e 's/png_ptr->jmpbuf/png_jmpbuf(png_ptr)/' ${S}/src/xsane-save.c
#}
