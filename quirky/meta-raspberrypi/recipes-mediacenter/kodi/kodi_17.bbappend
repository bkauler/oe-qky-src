
# 'avahi' snuck back in, remove... remove 'samba'...
# 170531 raspberrypi build, add 'virtual/egl', 'virtual/libgles2'
DEPENDS = " \
            cmake-native \
            curl-native \
            gperf-native \
            jsonschemabuilder-native \
            nasm-native \
            swig-native \
            unzip-native \
            yasm-native \
            zip-native \
            boost \
            bzip2 \
            curl \
            dcadec \
            enca \
            expat \
            faad2 \
            ffmpeg \
            fontconfig \
            fribidi \
            giflib \
            jasper \
            libass \
            libcdio \
            libcec \
            libmad \
            libmicrohttpd \
            libmms \
            libmodplug \
            libpcre \
            libplist \
            libsamplerate0 \
            libsdl-image \
            libsdl-mixer \
            libsquish \
            libssh \
            libtinyxml \
            libusb1 \
            libxslt \
            lzo \
            mpeg2dec \
            python \
            sqlite3 \
            taglib \
            virtual/egl \
            virtual/libsdl \
            wavpack \
            yajl \
            zlib \
            virtual/egl \
            virtual/libgles2 \
            ${@enable_glew(bb, d)} \
          "

# i think that 'samba' also brought in 'krb5', 'libpam'
PACKAGECONFIG[avahi] = "--enable-avahi,--disable-avahi,avahi"
PACKAGECONFIG[samba] = "--enable-samba,--disable-samba,samba"

# this had "--disable-optical-drive", why? removed...
EXTRA_OECONF = " \
    --disable-debug \
    --disable-libcap \
    --disable-ccache \
    --disable-mid \
    --enable-libusb \
    --enable-alsa \
    --enable-airplay \
    --with-ffmpeg=shared \
    --enable-texturepacker=no \
    ac_cv_path_JAVA_EXE=/bin/true \
"

# note, 'libplist' brings in dep 'swig'.
