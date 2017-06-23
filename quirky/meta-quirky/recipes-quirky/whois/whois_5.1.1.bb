# Recipe created by recipetool
# recipetool create -o whois_5.1.1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/whois_5.1.1.tar.bz2

SUMMARY = "Enhanced WHOIS client"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/whois_${PV}.tar.bz2 \
           file://hotfix.patch"
SRC_URI[md5sum] = "6ee6b433e94fa4ab609aded86b9ba60e"
SRC_URI[sha256sum] = "97216b0501f130a0c3263b91565d1dddebdfb40dc2031f37284788507267b47d"

DEPENDS = "libidn perl-native"
inherit pkgconfig gettext

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    true
}

do_compile () {
    oe_runmake
}

do_install () {
    #oe_runmake install DESTDIR=${D}
    install -d ${D}/usr/bin
    install -m755 whois ${D}/usr/bin
}


HOMEPAGE = "http://www.linux.it/~md/software/"
