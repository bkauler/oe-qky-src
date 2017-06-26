# Recipe created by recipetool
# recipetool create -o mtpaint_3.49.12.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/m/mtpaint-3.49.12.tar.gz

# note, Mark Tyler is the original author: http://mtpaint.sourceforge.net/
# now maintained by 'wjaguar'.

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/m/mtpaint-${PV}.tar.gz \
           file://mtpaint-freetype-config.patch \
           file://mtpaint-3.44.89-path.patch"
SRC_URI[md5sum] = "7cdcead2e9cd1dbea1c54544cb3bc60e"
SRC_URI[sha256sum] = "1c3ba7c96213b14439c4c2203fe43865eb876c0f3e306d5addee6c1cb5b735f9"

DEPENDS = "libx11 gtk+ gifsicle giflib libxpm jpeg tiff jasper lcms fontconfig libpng zlib"
inherit pkgconfig gettext

# NOTE: this is a Makefile-only piece of software. ...that's what OE thinks anyway.

do_configure () {
    #note, most of these options not really needed, as will autodetect...
    ./configure --cpu=${TARGET_ARCH} intl man GIF jpeg tiff jasper lcms2 gtk2 cflags
}

do_compile () {
	oe_runmake
}

do_install () {
    oe_runmake install DESTDIR=${D}
}

SUMMARY = "A simple GTK+1/2 painting program"
HOMEPAGE = "https://github.com/wjaguar/mtPaint"
