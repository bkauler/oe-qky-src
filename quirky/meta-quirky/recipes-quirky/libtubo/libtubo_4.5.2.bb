# Recipe created by recipetool
# recipetool create -o libtubo_4.5.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/libtubo-4.5.0.tar.bz2

# note, needed by xfdiff.
# 180419 libtubo 4.5.0 is the official release, 4.5.2 is a fork, with updated autotools.
#  reason we don't use a later official version, is 4.5.0 matches the early version of
#  xfdiff that we use -- the author's later xffm project has not been a happy experience.

SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/l/libtubo-${PV}.tar.gz"
SRC_URI[md5sum] = "9c8fff83612672fce1a4c5405dc96204"
SRC_URI[sha256sum] = "85eae5aa39f1678f244bc1c920c7a7bdee516e428a27537814a5667099690317"

DEPENDS = "gtk+"
inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-shared"

#reconf trouble, run the existing configure script...
do_configure() {
    # $SROOT is in configure script, to avoid host path contamination...
    SROOT="${WORKDIR}/recipe-sysroot" oe_runconf
}

do_compile() {
    SROOT="${WORKDIR}/recipe-sysroot" oe_runmake
}

FILES_${PN} += "/usr/lib/* /usr/include/*"

HOMEPAGE = "http://xffm.sourceforge.net/libtubo.html"
SUMMARY = "Library needed by xfdiff-cut"
