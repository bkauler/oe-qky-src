# Recipe created by recipetool
# recipetool create -o ssh-gui_0.7.1.bb https://downloads.sourceforge.net/project/ssh-gui/ssh-gui/0.7.1/ssh-gui-0.7.1.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=30bb5ec2200686035d5c720ca4fd9793"

SRC_URI = "https://downloads.sourceforge.net/project/ssh-gui/ssh-gui/${PV}/ssh-gui-${PV}.tar.gz \
           file://01-ssh-gui-compile-fix.patch"
SRC_URI[md5sum] = "50e47bae6dd1a0d2a5e6ba881d591d4c"
SRC_URI[sha256sum] = "8d6123e14023064a4e0c72aaa716f64ad83b44f1bef7cda81d54c87bddde4db2"

# NOTE: this is a Makefile-only piece of software.
DEPENDS = "gtk+ libxml2 glib-2.0 openssh openssl"
inherit pkgconfig

do_configure () {
    sed -i -e 's%^CC=%# CC=%' Makefile
    sed -i -e 's%^CFLAGS=%CFLAGS += %' Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}/usr/sbin
    install -m755 ssh-gui ${D}/usr/sbin
}


HOMEPAGE = "https://sourceforge.net/projects/ssh-gui/"
SUMMARY = "SSHGUI is a frontend for ssh."
