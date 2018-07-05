# Recipe created by recipetool
# recipetool create -o lxpanel_0.2.9.0.bb https://downloads.sourceforge.net/project/lxde/LXPanel%20%28desktop%20panel%29/LXPanel%200.2.9/lxpanel-0.2.9.0.tar.gz

# BK 20180705
# this is a very old version. Using it with Xephyr server in a container, in EasyOS.
# the patches are "Puppy specific".

LICENSE = "OSL-1.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183 \
                    file://src/plugins/netstatus/COPYING;md5=c746ccd4faefa5cf51ad670932374939"

SRC_URI = "https://downloads.sourceforge.net/project/lxde/LXPanel%20%28desktop%20panel%29/LXPanel%200.2.9/lxpanel-${PV}.tar.gz \
     file://01-lxpanel-0.2.9.0-puppy-icon-paths2.patch \
     file://02-lxpanel-0.2.9.0-puppy-xdg-menu-bk.patch"
SRC_URI[md5sum] = "74f7582c093ce5df0b14429be11b70c5"
SRC_URI[sha256sum] = "91b205b8f2b1b97ff1159ebeed4e94973e96a48f9b5fa51367855c2d3e608d63"

DEPENDS = "wireless-tools intltool-native alsa-lib libx11 \
           gtk+ pango gdk-pixbuf fontconfig freetype libxrender libxi \
           libxrandr libxcursor libxext libxcomposite libxdamage libxfixes harfbuzz \
           pixman libpng libxcb libffi libpcre util-linux expat graphite2 libxau \
           libxdmcp glib-2.0 glib-2.0-native libxft libxpm libxmu"

inherit pkgconfig gettext autotools

# as this pkg is very old, needs this hack (or could have patched the source)...
do_configure_prepend() {
 ln -snf gdk-pixbuf ${WORKDIR}/recipe-sysroot/usr/include/gdk-pixbuf-2.0/gdk-pixbuf-xlib
 ln -snf gdk-pixbuf.h ${WORKDIR}/recipe-sysroot/usr/include/gdk-pixbuf-2.0/gdk-pixbuf/gdk-pixbuf-xlib.h
}

# final link step fails, needs this...
LDFLAGS += " -lgmodule-2.0 -lX11"

EXTRA_OECONF = "--with-plugins=none --disable-libiw --disable-alsa"

SUMMARY = "Lightweight panel for X"
HOMEPAGE = "https://wiki.lxde.org/en/LXPanel"

