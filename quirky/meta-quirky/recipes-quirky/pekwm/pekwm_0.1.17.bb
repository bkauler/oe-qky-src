# Recipe created by recipetool
# recipetool create -o pekwm_0.1.17.bb http://ponce.cc/slackware/sources/repo/pekwm-0.1.17.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://ponce.cc/slackware/sources/repo/pekwm-${PV}.tar.bz2"
SRC_URI[md5sum] = "514c04ff1c6123635c00e57443b5e86f"
SRC_URI[sha256sum] = "8a1fd3bf9f38e8c7bb2b2864c090f986b60cec2281ecf1bba462d120fb327d00"

DEPENDS = "libxinerama libxext libjpeg-turbo libxpm libpng12 libx11 libxft libxrandr \
           fontconfig freetype libxcb libxrender libxau libxdmcp expat libice libsm"

inherit pkgconfig autotools

EXTRA_OECONF = ""

SUMMARY = "Small and light window manager for X"
HOMEPAGE = "http://www.pekwm.org/"
