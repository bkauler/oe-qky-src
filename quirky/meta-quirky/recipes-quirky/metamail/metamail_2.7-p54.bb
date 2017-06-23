# Recipe created by recipetool
# recipetool create -o metamail_2.7-p54.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/metamail-2.7.tar.bz2

# BK 170614 note, the orig pkg only has a Makefile, patches introduce autoconf.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=d42af252d1bccf0a4d53d5e6bf635b44"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/metamail-2.7.tar.bz2 \
           file://1-metamail_2.7-54.patch \
           file://2-metamail.automake.patch \
           file://3-metamail.uue.getline.patch"
SRC_URI[md5sum] = "285d7efd4048711be55d8d9faba22541"
SRC_URI[sha256sum] = "204b9f209dacad239bd9d3b61a54b3f7b7f0ec45f94bfae351e5a517f195d9bb"

S = "${WORKDIR}/${BPN}-2.7"

DEPENDS = "ncurses"
inherit autotools-brokensep pkgconfig

do_configure_prepend() {
    chmod 755 ${S}/bootstrap
    chmod 755 ${S}/configure
    touch ${S}/NEWS
    touch ${S}/AUTHORS
    touch ${S}/ChangeLog
}


HOMEPAGE = "http://bmrc.berkeley.edu/~trey/emacs/metamail.html"
SUMMARY = "MIME decoder"
