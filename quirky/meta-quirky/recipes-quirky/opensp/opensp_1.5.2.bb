# Recipe created by recipetool
# recipetool create -o opensp_1.5.2.bb https://downloads.sourceforge.net/project/openjade/opensp/1.5.2/OpenSP-1.5.2.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=641ff1e4511f0a87044ad42f87cb1045"

SRC_URI = "https://downloads.sourceforge.net/project/openjade/opensp/${PV}/OpenSP-${PV}.tar.gz \
           file://gcc34.patch"
SRC_URI[md5sum] = "670b223c5d12cee40c9137be86b6c39b"
SRC_URI[sha256sum] = "57f4898498a368918b0d49c826aa434bb5b703d2c3b169beb348016ab25617ce"

S = "${WORKDIR}/OpenSP-${PV}"

DEPENDS = "libxml2 cups ghostscript poppler sgml-common"

inherit gettext perlnative autotools-brokensep

# ref: http://www.linuxfromscratch.org/blfs/view/8.0/pst/opensp.html
#  --enable-xml-messages
EXTRA_OECONF = "--disable-doc-build --enable-default-search-path=/usr/share/sgml --enable-http --enable-default-catalog=/etc/sgml/catalog"

do_configure_prepend() {
    sed -i 's/32,/253,/' ${S}/lib/Syntax.cxx
    sed -i 's/LITLEN          240 /LITLEN          8092/' ${S}/unicode/{gensyntax.pl,unicode.syn}
}

HOMEPAGE = "http://openjade.sourceforge.net/"
SUMMARY = ""
