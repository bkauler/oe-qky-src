
# remove 'avahi'...
DEPENDS = "libfribidi libtool libgcrypt libgcrypt-native \
   dbus dbus-glib libxml2 gnutls \
   tremor faad2 ffmpeg flac fluidsynth alsa-lib \
   lua-native lua libidn \
   jpeg xz libmodplug mpeg2dec \
   libmtp libopus orc libsamplerate0 libusb1 schroedinger taglib \
   tiff"

# why has faad been disabled? remove --disable-faad
EXTRA_OECONF = "\
    --enable-run-as-root \
    --enable-xvideo \
    --disable-screen --disable-caca \
    --enable-httpd --enable-vlm \
    --enable-freetype \
    --enable-tremor \
    --enable-v4l2 --disable-aa \
    --enable-dbus \
    --without-contrib \
    --without-kde-solid \
    --enable-realrtsp \
    --disable-libtar \
    ac_cv_path_MOC=${STAGING_BINDIR_NATIVE}/moc4 \
    ac_cv_path_RCC=${STAGING_BINDIR_NATIVE}/rcc4 \
    ac_cv_path_UIC=${STAGING_BINDIR_NATIVE}/uic4 \
"