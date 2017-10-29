DESCRIPTION="JWM (Joe's Window Manager) http://www.joewing.net/projects/jwm/"
SECTION = "x11/wm"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c2938cf0f6887d0bca0cea7cac3e097f"

DEPENDS = "virtual/libx11 \
           libxext libxmu libxinerama libxpm jpeg libpng \
           librsvg cairo libxft libfribidi \
"

inherit autotools pkgconfig gettext

SRC_URI = "https://joewing.net/projects/jwm/releases/jwm-2.3.7.tar.xz"

SRC_URI[md5sum] = "95b297a89dedf45ef037c2596ad7d699"
SRC_URI[sha256sum] = "745d2f5df3a4ce9ecc8e75445edb3fbe31dd46c0c26d129cc14de7ad8b665326"

B = "${S}"

EXTRA_OECONF = "--disable-confirm"

HOMEPAGE = "http://www.joewing.net/programs/jwm"
SUMMARY = "Joes Window Manager"
