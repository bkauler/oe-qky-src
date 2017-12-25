
# 171128 can't believe this, cups support is disabled!!!!

PR = "r3"

# added the last line...
DEPENDS = "glib-2.0 pango atk jpeg libpng gdk-pixbuf-native \
           cairo gdk-pixbuf \
           cups libxinerama xinput pixman freetype fontconfig"

# original...
#EXTRA_OECONF = "--enable-xkb --disable-glibtest --disable-cups --disable-xinerama"

EXTRA_OECONF = "--enable-xkb --disable-glibtest --enable-cups --enable-xinerama \
                --with-xinput=yes --enable-debug=minimum"

# 171217 this patch not needed, ref: http://bkhome.org/news/201712/gtk-stock-icons-missing.html
## 171216 another headache. the gtk developed have changed stock icon names.
## ref: http://www.murga-linux.com/puppy/viewtopic.php?p=847362#847362
#SRC_URI_append = " file://gtk_stock_icons_fix.patch"
#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
