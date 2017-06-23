# Recipe created by recipetool
# recipetool create -o gtklp_1.3.3.bb https://downloads.sourceforge.net/project/gtklp/gtklp/1.3.3/gtklp-1.3.3.src.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7e3293ae916147aca9bc8eab3a2d2e84"

SRC_URI = "https://downloads.sourceforge.net/project/gtklp/gtklp/${PV}/gtklp-${PV}.src.tar.gz"
SRC_URI[md5sum] = "7f70beea1f3a2a2401973f9e0d6e4042"
SRC_URI[sha256sum] = "6e105c22b8e3e855bfba060cb3285959841f04439077b0a533f14f6aa52bfbbf"

DEPENDS = "gtk+ openssl cups ghostscript poppler"

inherit pkgconfig gettext autotools

SROOT = "${WORKDIR}/recipe-sysroot"

# --help states this supported: --with-sysroot=${SROOT} but it isn't
EXTRA_OECONF = "--enable-ssl"


HOMEPAGE = "http://gtklp.sourceforge.net/"
SUMMARY = "a graphical Frontend to CUPS"
