# Recipe created by recipetool
# recipetool create -o mhwaveedit_1.4.23.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/mhwaveedit-1.4.23.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/mhwaveedit-${PV}.tar.bz2"
SRC_URI[md5sum] = "72d12ebdd38777ba597db0cf6158ceef"
SRC_URI[sha256sum] = "2352175b63092fda786ca26095b2f6ff6d257a6fcfb18401213a0c932b991904"

DEPENDS = "gtk+ libsamplerate0 glib-2.0 libsndfile1 alsa-lib libpng"

inherit pkgconfig gettext autotools

# 
EXTRA_OECONF = "--with-default-driver=alsa --without-arts --with-default-mixerapp=defaultaudiomixer \
 --without-pulse --without-esound --without-jack --disable-ladspa --without-sdl"

do_configure_prepend() {
    chmod 755 ${S}/config.guess
    chmod 755 ${S}/config.rpath
    chmod 755 ${S}/config.sub
    chmod 755 ${S}/cvscompile
    chmod 755 ${S}/depcomp
}

do_compile_prepend() {
    sed -i -e 's%^LDFLAGS =%LDFLAGS +=%' ${B}/Makefile
}

HOMEPAGE = "http://gna.org/projects/mhwaveedit/"
SUMMARY = "A graphical program for editing playing and recording sound files."
