LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

# 180418 warning: finally got it to build for aarch64
# however, there is a wrong install path for locales. ...so doing manual install.

PR = "r0"

SRC_URI = "http://sourceforge.net/projects/xine/files/xine-ui/${PV}/xine-ui-${PV}.tar.xz"
SRC_URI[md5sum] = "b3b4839c73edfa0da7c7331455cfee29"
SRC_URI[sha256sum] = "ca20ab40aa386f609562de1b86a379ea3bf605813ceebe64b845bb1b23fc7244"

# 171123 change libpng to libpng12
DEPENDS = "libxinerama libpng12 curl libxext libx11 libxscrnsaver xine-lib libjpeg-turbo libxxf86vm libxtst libxv libxft openssl libxt"

inherit gettext pkgconfig autotools

EXTRA_OECONF = "--enable-xft --disable-lirc --without-aalib --without-caca"

# 171123 running in Pyro64 0.5.2, xine-ui reported this:
# "libpng warning: application built with libpng-1.2.54 but running with 1.6.28"
# try this fix (see also change above):
do_configure_prepend() {
 ln -snf libpng12.pc ${WORKDIR}/recipe-sysroot/usr/lib/pkgconfig/libpng.pc
}

do_compile_prepend() {
 #180418 aarch64 hack, it wants stubs-32.h
 if [ ! -f ${WORKDIR}/recipe-sysroot/usr/include/gnu/stubs-32.h ];then
  ln -s stubs-64.h ${WORKDIR}/recipe-sysroot/usr/include/gnu/stubs-32.h
 fi
 
 #this snuck through, absolute path -I/usr/include, quick hack...
 for aMake in `find ${B} -type f -name Makefile`
 do
  sed -i -e "s%I/usr/include%I${STAGING_INCDIR}%g" ${aMake}
  sed -i -e "s%^includedir = .*%includedir = ${STAGING_INCDIR}%" ${aMake}
  sed -i -e "s%^oldincludedir = .*%oldincludedir = ${STAGING_INCDIR}%" ${aMake}
  sed -i -e "s%^prefix = /usr%prefix = ${WORKDIR}/recipe-sysroot/usr%" ${aMake}
 done
 
 # -I/usr/include still getting through! desparate...
 #sed -i -e 's%^CFLAGS = %CFLAGS = -nostdinc %' ${B}/Makefile
 sed -i -e 's% -I$(prefix)/include % %' ${B}/Makefile
}

#nah, can't be bothered, can fix locale path afterward...
#do_install() {
# install -d ${D}/usr/bin
# install -m755 ${B}/src/xitk/xine ${D}/usr/bin
# install -m755 ${B}/src/xitk/xine-remote ${D}/usr/bin
# install -m755 ${B}/src/fb/fbxine ${D}/usr/bin
#
#}

HOMEPAGE = "https://www.xine-project.org/"
SUMMARY = "Media player, xlib based gui for xine-lib"

