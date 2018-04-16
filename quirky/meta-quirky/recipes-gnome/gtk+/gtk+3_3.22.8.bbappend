
# 180401 ditto, probalems as per gtk2...

# added last line...
DEPENDS = "glib-2.0 cairo pango atk jpeg libpng gdk-pixbuf \
           gdk-pixbuf-native \
           cups libxinerama xinput pixman freetype fontconfig"

# original...
#EXTRA_OECONF = " --enable-introspection --disable-gtk-doc --disable-glibtest \
#                 --disable-xinerama --enable-modules --disable-cups \
#                 --disable-colord \
#                 --enable-glx --enable-opengl --disable-wayland-backend \
#                 --enable-x11-backend --enable-nls"

EXTRA_OECONF = " --enable-introspection --disable-gtk-doc --disable-glibtest \
                 --enable-xinerama --enable-modules --enable-cups \
                 --disable-colord \
                 --enable-glx --enable-opengl --disable-wayland-backend \
                 --enable-x11-backend --enable-nls"

