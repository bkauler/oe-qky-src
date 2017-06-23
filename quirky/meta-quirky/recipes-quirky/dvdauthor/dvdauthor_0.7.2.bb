# Recipe created by recipetool
# recipetool create -o dvdauthor_0.7.2.bb https://downloads.sourceforge.net/project/dvdauthor/dvdauthor-0.7.2.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://downloads.sourceforge.net/project/dvdauthor/dvdauthor-${PV}.tar.gz"
SRC_URI[md5sum] = "1173dcb8d40e74fc90c0f3a25dbd642d"
SRC_URI[sha256sum] = "3020a92de9f78eb36f48b6f22d5a001c47107826634a785a62dfcd080f612eb7"

S = "${WORKDIR}/${BPN}"

DEPENDS = "fontconfig libpng libdvdread fribidi freetype zlib libxml2"

inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-xmltest"

do_configure_prepend() {
    sed -i -e 's%$FREETYPECONFIG --cflags%pkg-config --cflags freetype2%' ${S}/configure.ac
    sed -i -e 's%$FREETYPECONFIG --libs $config_static%pkg-config --libs freetype2%' ${S}/configure.ac
}

HOMEPAGE = "http://dvdauthor.sourceforge.net/"
SUMMARY = "DVD Authoring Tools"
