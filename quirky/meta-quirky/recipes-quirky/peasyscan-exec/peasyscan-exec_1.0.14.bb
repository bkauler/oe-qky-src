# Recipe created by recipetool
# recipetool create -o peasyscan-exec_1.0.14.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/peasyscan-sane-frontends-1.0.14.tar.bz2

# this is a hacked sane-frontends, by rcrsn51, for use in his 'peasyscan'.

PR = "r1"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

PV = "1.0.14"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/peasyscan-sane-frontends-${PV}.tar.bz2 \
           file://00-peasyscan-fix-aarch64.patch \
           file://01-hot-fix.patch \
           file://02-scan-button.patch"
SRC_URI[md5sum] = "6ef74b08e87a2d425032172931d2b135"
SRC_URI[sha256sum] = "c2c90af54c739f3b23c45b1dd197b94d0138acfc0f3a2c2be0830fea113e5501"

S = "${WORKDIR}/peasyscan-sane-frontends-${PV}"

DEPENDS = "gtk+ sane-backends libpng jpeg tiff freetype fontconfig cairo libxml2 librsvg libgphoto2 glib-2.0"
inherit autotools-brokensep pkgconfig


EXTRA_OECONF = "--disable-gimp --disable-gtktest --disable-sanetest"


# do not recreate configure...
do_configure() {
    #sane-backends did not install 'sane-config'. patch configure...
    #...ah, no, can just have --disable-sanetest, see above.
    #but configure still aborts (with 'exit 0' !!!) if sane-config missing...
    sed -i -e 's%/bin/sane-config%/bin/pkg-config%' ${S}/configure
    #might as well fix these...
    sed -i -e 's%$SANE_CONFIG $sane_config_args --cflags%pkg-config --cflags sane-backends%' ${S}/configure
    sed -i -e 's%$SANE_CONFIG $sane_config_args --ldflags%pkg-config --ldflags sane-backends%' ${S}/configure
    sed -i -e 's%$SANE_CONFIG $sane_config_args --libs%pkg-config --libs sane-backends%' ${S}/configure
    sed -i -e 's%$SANE_CONFIG $sane_config_args --prefix%echo /usr%' ${S}/configure
    sed -i -e 's%$SANE_CONFIG $sane_config_args --version%pkg-config --version sane-backends%' ${S}/configure
    
    #still having trouble with sane-config, put in...
    export SANE_CONFIG="${WORKDIR}/recipe-sysroot-native/usr/bin/pkg-config"
    #...whew, finally got a Makefile

    oe_runconf
}

do_install() {
    #only want this...
    install -d ${D}/usr/local/peasyscan
    install -m755 ${S}/src/xscanimage ${D}/usr/local/peasyscan/xscanimage-peasy
}

FILES_${PN} += "/usr/local/peasyscan"

HOMEPAGE = ""
SUMMARY = "Hacked scanner utility for peasyscan package."
