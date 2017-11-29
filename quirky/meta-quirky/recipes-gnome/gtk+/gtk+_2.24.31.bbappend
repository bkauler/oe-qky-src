
# 171128 can't believe this, cups support is disabled!!!!

PR = "r1"

# added the last line...
DEPENDS = "glib-2.0 pango atk jpeg libpng gdk-pixbuf-native \
           cairo gdk-pixbuf \
           cups libxinerama xinput pixman freetype fontconfig"

# original...
#EXTRA_OECONF = "--enable-xkb --disable-glibtest --disable-cups --disable-xinerama"

EXTRA_OECONF = "--enable-xkb --disable-glibtest --enable-cups --enable-xinerama \
                --with-xinput=yes --enable-debug=minimum"
