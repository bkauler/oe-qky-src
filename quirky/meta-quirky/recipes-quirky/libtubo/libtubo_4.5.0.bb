# Recipe created by recipetool
# recipetool create -o libtubo_4.5.0.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/libtubo-4.5.0.tar.bz2

# note, needed by xfdiff.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/libtubo-${PV}.tar.bz2"
SRC_URI[md5sum] = "c7739c8341407f3dffa036d68b9b3857"
SRC_URI[sha256sum] = "dd646ad30c4619819a469d67e74e1e0767caf5381c022eb193e208d87edeff8d"

DEPENDS = "gtk+"
inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-shared"

do_configure() {
    oe_runconf
}

FILES_${PN} += "/usr/lib/* /usr/include/*"

HOMEPAGE = ""
SUMMARY = "Library needed by xfdiffcut"
