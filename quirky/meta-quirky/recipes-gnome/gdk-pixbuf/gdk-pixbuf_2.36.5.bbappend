
# 181222 gdk-pixbuf was configured with:
# --with-libjpeg --without-libjasper --with-libpng --without-libtiff --without-x11
# was unable to compile zarfy (input521/0-zarfy), coz of missing x11 functions.

# recipe is here: meta/recipes-gnome/gdk-pixbuf

PR = "r1"

# add tiff... jpeg2000 is jasper, nah, need jasper-native
GDK_PIXBUF_LOADERS = "png jpeg tiff"
# add x11...
PACKAGECONFIG_class-target = "${GDK_PIXBUF_LOADERS} x11"
