# 180423 do_configure failed;
# ERROR: libbluray not found using pkg-config
# ...very odd, it is there!!!! have removed libbluray
# ...now it is telling me cannot find schroedinger-1.0.pc ...what is going on!!!
# ...trying --pkg-config=, see .bb YES, FIXED IT.
# note, have libsdl as dep, however ffmpeg wants sdl v2.x, only have 1.2.x

PR = "r1"

#DEPENDS += "libcdio libcdio-paranoia"
# 180422 add more...
# 180423 add just in case: liba52 faac faad libmng mpeg2dec taglib libcdr libmad libsndfile1 libmodplug
DEPENDS += "libcdio libcdio-paranoia openssl libva wavpack libvpx libvorbis \
            speex schroedinger openjpeg opencore-amr orc lame libvdpau libsdl \
            libsdl-image libsdl-mixer mesa libdrm xz bzip2 zip unzip libxcb \
            v4l-utils libdc1394 freetype fontconfig libbluray libwebp libxv\
            liba52 faac faad2 libmng mpeg2dec taglib libcdr libmad libsndfile1 libmodplug"

#PACKAGECONFIG_append = " cdio"
#PACKAGECONFIG[cdio] = "--enable-libcdio,--disable-libcdio,libcdio"
# 180422... (note, libva is vaapi)  180423 removed libbluray ...brought back
PACKAGECONFIG_append = " cdio openssl vaapi wavpack vpx libvorbis speex schroedinger \
                        opencore v4l libdc1394 lzma libwebp vdpau theora libbluray"
PACKAGECONFIG[cdio] = "--enable-libcdio,--disable-libcdio,libcdio"
PACKAGECONFIG[wavpack] = "--enable-libwavpack,--disable-libwavpack,wavpack"
PACKAGECONFIG[opencore] = "--enable-libopencore-amrnb --enable-libopencore-amrwb --enable-version3,,opencore-amr"
# PACKAGECONFIG[mp3lame] = "--enable-libmp3lame,,lame"
PACKAGECONFIG[v4l] = "--enable-libv4l2,,v4l-utils"
PACKAGECONFIG[libdc1394] = "--enable-libdc1394,--disable-libdc1394,libdc1394"
PACKAGECONFIG[libbluray] = "--enable-libbluray,,libbluray"
PACKAGECONFIG[libwebp] = "--enable-libwebp,,libwebp"
