# Recipe created by recipetool
# recipetool create -o cgtkcalc_2.2.4.bb http://cgtkcalc.sourceforge.net/cgtkcalc-2.2.4.tar.gz

SUMMARY = "a simple scientific calculator for complex numbers"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7783169b4be06b54e86730eb01bc3a31"

SRC_URI = "http://cgtkcalc.sourceforge.net/cgtkcalc-${PV}.tar.gz"
SRC_URI[md5sum] = "367906f66c1e887f2480cdfc8156817b"
SRC_URI[sha256sum] = "ffd3ca3ccbd902d310483d40196ac84d4bc108b72284440376980ff439297a55"

DEPENDS = "gtk+ glib-2.0 zlib"

inherit pkgconfig autotools-brokensep

EXTRA_OECONF = "--with-gtk2"

# this info is for version 2.1.9:
# refer: http://www.linuxquestions.org/questions/linux-software-2/error-compiling-%27foto%27-%5Berror-adding-symbols-dso-missing-from-command-line%5D-4175493187/
LDFLAGS += "-lm"

do_install() {
    install -d ${D}/usr/bin
    install -m755 ${S}/cgtkcalc ${D}/usr/bin
    install -d ${D}/usr/share/applications
    install -m644 ${S}/cgtkcalc.desktop ${D}/usr/share/applications
    install -d ${D}/usr/share/pixmaps
    install -m644 ${S}/cgtkcalc.png ${D}/usr/share/pixmaps
    install -d ${D}/usr/share/cgtkcalc
    install -m644 ${S}/src/HELP_STR ${D}/usr/share/cgtkcalc
}

HOMEPAGE = ""
