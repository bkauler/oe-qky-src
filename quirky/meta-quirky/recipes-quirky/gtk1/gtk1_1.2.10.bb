# Recipe created by recipetool
# recipetool create -o gtk1_1.2.10.bb https://download.gnome.org/sources/gtk+/1.2/gtk+-1.2.10.tar.gz
# old oe patches: http://git.openembedded.org/openembedded/plain/recipes/gtk+/gtk+-1.2-1.2.10/
# t2 patches: http://t2sde.org/packages/gtk+12

SUMMARY = "The original Gimp Toolkit"
HOMEPAGE = "https://download.gnome.org/sources/gtk+/1.2/"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7 \
                    file://gtk/COPYING;md5=dcf3c825659e82539645da41a7908589 \
                    file://gdk/COPYING;md5=dcf3c825659e82539645da41a7908589"

SRC_URI = "https://download.gnome.org/sources/gtk+/1.2/gtk+-${PV}.tar.gz \
           file://t2-correct-so-deps.patch \
           file://t2-gtk+-12.patch \
           file://oe-gtk+12-reconf-fix.patch \
           file://oe-no-xwc.patch \
           file://oe-small-filesel.patch \
           file://oe-timezone-fix.patch \
           file://glib-config"
SRC_URI[md5sum] = "4d5cb2fc7fb7830e4af9747a36bfce20"
SRC_URI[sha256sum] = "3fb843ea671c89b909fd145fa09fd2276af3312e58cbab29ed1c93b462108c34"

S = "${WORKDIR}/gtk+-${PV}"

DEPENDS = "libtool libxext libx11 libxi libxau libxdmcp glib1 libxcb"

inherit perlnative autotools-brokensep pkgconfig gettext

#  --with-gnu-ld
EXTRA_OECONF = "--with-xinput=xfree --disable-xim-inst --disable-glibtest --with-native-locale=yes --enable-debug=no"

# "reconfig" is broken, just run 'configure'...
do_configure() {
 #this is not the right way to do it, glib1 should provide this...
 chmod 755 ${WORKDIR}/glib-config
 export GLIB_CONFIG="${WORKDIR}/glib-config"
 oe_runconf
}

do_compile_prepend() {
 #ltconfig thinks cannot create shared libs (only broken when cross-compiling)
 #ltconfig generates libtool, hack it (examined diffs from compile in host)...
 sed -i -e 's%^build_libtool_libs=no%build_libtool_libs=yes%' ${S}/libtool
 sed -i -e 's%^need_lib_prefix=unknown%need_lib_prefix=no%' ${S}/libtool
 sed -i -e 's%^need_version=unknown%need_version=no%' ${S}/libtool
 sed -i -e 's%^version_type=none%version_type=linux%' ${S}/libtool
 sed -i -e 's%^library_names_spec=""%library_names_spec="\\${libname}\\${release}.so\\$versuffix \\${libname}\\${release}.so\\$major \\$libname.so"%' ${S}/libtool
 sed -i -e 's%^soname_spec=""%soname_spec="\\${libname}\\${release}.so\\$major"%' ${S}/libtool
 #sed -i -e 's%^%%' ${S}/libtool
}

# /usr/share/themes
FILES_${PN} += "${datadir}/themes"

