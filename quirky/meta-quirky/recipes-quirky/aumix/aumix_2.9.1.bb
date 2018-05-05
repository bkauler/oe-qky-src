# Recipe created by recipetool

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5574c6965ae5f583e55880e397fbb018"

SRC_URI = "https://sourceforge.net/projects/aumix/files/aumix/${PV}/aumix-${PV}.tar.bz2"
SRC_URI[md5sum] = "34f28ae1c94fc5298e8bb2688c4b3a20"
SRC_URI[sha256sum] = "d2ce43d532ef75072c8d4e7922e3bc06be6d97765a508d9ceb0d1766bbe70e29"

DEPENDS = "ncurses alsa-lib alsa-state alsa-utils gtk+ glib-2.0 cairo pango \
           fontconfig freetype gdk-pixbuf"

inherit pkgconfig gettext autotools

EXTRA_OECONF = "--with-ncurses --without-gpm"

do_compile_prepend() {
 #180422 aarch64 hack, it wants stubs-32.h
 if [ ! -f ${WORKDIR}/recipe-sysroot/usr/include/gnu/stubs-32.h ];then
  ln -s stubs-64.h ${WORKDIR}/recipe-sysroot/usr/include/gnu/stubs-32.h
 fi
 
 #180505 x86_64 build, reports poison...
 sed -i -e 's% -I/usr/include$%%' ${B}/src/Makefile
 sed -i -e 's% -L/usr/lib$% %' ${B}/src/Makefile
 
}

SUMMARY = "alsa mixer"
HOMEPAGE = "https://sourceforge.net/projects/aumix"
