# Recipe created by recipetool

LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e8dee932c26f2dab503abf70c96d8bb"

SRC_URI = "https://storage.googleapis.com/downloads.webmproject.org/releases/webp/libwebp-${PV}.tar.gz"
SRC_URI[md5sum] = "b49ce9c3e3e9acae4d91bca44bb85a72"
SRC_URI[sha256sum] = "06503c782d9f151baa325591c3579c68ed700ffc62d4f5a32feead0ff017d8ab"

DEPENDS = "giflib zlib jpeg tiff libpng libsdl libsdl-image mesa"

#inherit cmake
inherit autotools pkgconfig gettext

#EXTRA_OECMAKE = "--disable-static"
EXTRA_OECONF = "--disable-static"
