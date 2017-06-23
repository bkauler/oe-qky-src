DESCRIPTION="JWM (Joe's Window Manager) http://www.joewing.net/projects/jwm/"
SECTION = "x11/wm"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "virtual/libx11 \
           libxext libxmu libxinerama libxpm jpeg libpng \
           librsvg cairo libxft libfribidi \
"

inherit autotools pkgconfig gettext

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/jwm-976.tar.bz2"

SRC_URI[md5sum] = "6dc96f33b7b3b54128f942bcc67d02a0"
SRC_URI[sha256sum] = "577ebe637b5eb848dae4bd3dfbd33326198c05bac904430399e4dd6ccd2bde98"

B = "${S}"

EXTRA_OECONF = "--disable-confirm"

HOMEPAGE = "http://www.joewing.net/programs/jwm"
SUMMARY = "Joes Window Manager"
