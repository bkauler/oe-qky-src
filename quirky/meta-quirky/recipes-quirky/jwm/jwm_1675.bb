DESCRIPTION="JWM (Joe's Window Manager) http://www.joewing.net/projects/jwm/"
SECTION = "x11/wm"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c2938cf0f6887d0bca0cea7cac3e097f"

DEPENDS = "virtual/libx11 \
           libxext libxmu libxinerama libxpm jpeg libpng \
           librsvg cairo libxft libfribidi \
"

inherit autotools pkgconfig gettext

SRC_URI = "https://joewing.net/projects/jwm/snapshots/jwm-1675.tar.xz"

SRC_URI[md5sum] = "cec5e00e7badf38d59a909d394fa4aee"
SRC_URI[sha256sum] = "e5a8e3de277feda8814920f5036639ca7b4b9783b6a97cef254b3fa8fca8820e"

B = "${S}"

EXTRA_OECONF = "--disable-confirm"

HOMEPAGE = "http://www.joewing.net/programs/jwm"
SUMMARY = "Joes Window Manager"
