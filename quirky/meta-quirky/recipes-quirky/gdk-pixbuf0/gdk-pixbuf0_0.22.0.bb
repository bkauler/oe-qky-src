# Recipe created by recipetool
# recipetool create -o gdk-pixbuf0_0.22.0.bb https://download.gnome.org/sources/gdk-pixbuf/0.22/gdk-pixbuf-0.22.0.tar.gz
# arch linux patches: https://aur.archlinux.org/cgit/aur.git/tree/?h=gdk-pixbuf

SUMMARY = "image support for gtk1"
HOMEPAGE = "https://download.gnome.org/sources/gdk-pixbuf/0.22/"

LICENSE = "LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

# removed:
#           file://arch-gdk-pixbuf-bmp_rej.patch 
#           file://arch-gdk-pixbuf-bmp_secure.patch 

SRC_URI = "https://download.gnome.org/sources/gdk-pixbuf/0.22/gdk-pixbuf-${PV}.tar.gz \
           file://arch-gdk-pixbuf-loaders.patch \
           file://arch-gdk-pixbuf.patch;striplevel=0 \
           file://arch-libpng15.patch \
           file://glib-config \
           file://gtk-config \
           "
SRC_URI[md5sum] = "4db0503b5a62533db68b03908b981751"
SRC_URI[sha256sum] = "75e5e4f9bb1c5187056955038ce99577d637a5c5dee3c99c5fad199bf6bf12be"

S = "${WORKDIR}/gdk-pixbuf-${PV}"

# remove libpng12, as have libpng15 patch
DEPENDS = "giflib tiff libx11 libjpeg-turbo libpng libxpm glib1 gtk1 libxi libxext libxcb libxau libxdmcp"

inherit autotools-brokensep pkgconfig gettext

EXTRA_OECONF = "--disable-gtk-doc --disable-gtktest --disable-glibtest --disable-gtk-doc --enable-modules"

# "reconfig" is broken, just run 'configure'...
do_configure() {
 #this is not the right way to do it, glib1 should provide this...
 chmod 755 ${WORKDIR}/glib-config
 export GLIB_CONFIG="${WORKDIR}/glib-config"
 #ditto...
 chmod 755 ${WORKDIR}/gtk-config
 export GTK_CONFIG="${WORKDIR}/gtk-config"
 #unable to compile a test binary, so disables building of dynamically loaded modules...
 sed -i -e 's%dynworks=false%dynworks=true%' configure
 oe_runconf
}

do_compile_prepend() {
 #cannot compile demo when cross-compile...
 echo -e 'all:\n\ninstall:\n\nuninstall:\n\nclean:\n\n' > ${S}/demo/Makefile
}

FILES_${PN} += "${libdir}/* ${datadir}/gnome"
