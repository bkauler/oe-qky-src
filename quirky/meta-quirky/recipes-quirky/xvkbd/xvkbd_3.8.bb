# Recipe created by recipetool
# recipetool create -o xvkbd_3.8.bb http://t-sato.in.coocan.jp/xvkbd/xvkbd-3.8.tar.gz

# BK 170619 In host, ran "xmkmf" in the xvkbd source, which generates Makefile,
# then recorded the steps when ran "make", created 'compile-xvkbd'.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://t-sato.in.coocan.jp/xvkbd/xvkbd-${PV}.tar.gz \
           file://compile-xvkbd"
SRC_URI[md5sum] = "0d683f68c92f22cd9a7ffcb6d82c81b6"
SRC_URI[sha256sum] = "2ca43d4f2eebd66aef7c89a17e019146f14ccfe85c731a818202a85fd6e2259b"

# NOTE: no Makefile found.
DEPENDS = "libx11 libxaw libxmu libxt libsm libice libxpm libxext libxtst"

do_configure () {
    true
}

do_compile () {
    chmod 777 ../compile-xvkbd
    eval ../compile-xvkbd
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 xvkbd ${D}/usr/bin
    install -d ${D}/etc/X11/app-defaults
    for aFILE in XVkbd XVkbd-belgian XVkbd-common XVkbd-danish XVkbd-fitaly XVkbd-french2 XVkbd-french XVkbd-german XVkbd-greek XVkbd-hebrew XVkbd-icelandic XVkbd-italian XVkbd-jisx6002 XVkbd-jisx6004 XVkbd-korean XVkbd-latin1 XVkbd-norwegian XVkbd-portuguese XVkbd-russian XVkbd-slovene XVkbd-small XVkbd-spanish XVkbd-strip XVkbd-swedish XVkbd-swissgerman XVkbd-turkish XVkbd-turkishF XVkbd-uk
    do
      install -m644 ${aFILE}.ad ${D}/etc/X11/app-defaults/${aFILE}
    done
}


HOMEPAGE = "http://homepage3.nifty.com/tsato/xvkbd/"
SUMMARY = "A virtual keyboard for X"
