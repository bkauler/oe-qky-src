# Recipe created by recipetool
# recipetool create -o xine-lib_1.2.8.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/x/xine-lib-1.2.8.tar.bz2

LICENSE = "LGPLv2 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=b29c0845cfd8eb68f25dd58c624c161f \
                    file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/x/xine-lib-${PV}.tar.bz2"
SRC_URI[md5sum] = "981f509f5f765e19610f62e82f55d24e"
SRC_URI[sha256sum] = "7dfc11a36ba9569588da349b5998c61aad0ce505e8bb919a7771c4414d45a6d0"

# just added in case: lame lcms libcdio libraw1394 libavc1394 libdc1394 mpeg2dec
DEPENDS = "zlib libxext fontconfig freetype libx11 librsvg libpng ffmpeg alsa-lib libdvdnav faac faad2 flac gdk-pixbuf mesa libglu liba52 libmad libmng libtheora libva libvdpau libvorbis libogg libvpx libsdl libsdl-image libsdl-mixer libsdl-ttf speex libmodplug vcdimager wavpack x264 libxcb libxvmc lame lcms libcdio libraw1394 libavc1394 libdc1394 mpeg2dec"

inherit pkgconfig gettext perlnative autotools

SROOT = "${WORKDIR}/recipe-sysroot"
# note, broken finding flac headers, have put in explicit path.

# haven't got v4l, remove:  --enable-libv4l --enable-v4l2
# haven't got, removed:  --enable-bluray
EXTRA_OECONF = "--disable-dxr3 --disable-gnomevfs --disable-samba --enable-antialiasing --without-imagemagick --with-freetype --with-fontconfig --without-esound --without-jack --with-libflac --enable-faad --with-real-codecs-path=/usr/lib/codecs --with-w32-path=/usr/lib/codecs --without-caca --without-pulseaudio --with-alsa --enable-mad --enable-faad --enable-a52dec --enable-vdpau --enable-dvb --disable-directfb --disable-aalib --with-xcb --with-external-dvdnav --disable-ipv6 --with-sdl --enable-vpx --enable-mad --enable-opengl --enable-glu --enable-xvmc --enable-vaapi --disable-vcd --with-libFLAC-includes=${SROOT}/usr/include/FLAC"

# ref: http://www.linuxfromscratch.org/blfs/view/svn/multimedia/xine-lib.html
do_configure_prepend() {
    sed -i -e 's|wand/magick_wand.h|MagickWand/MagickWand.h|' ${S}/src/video_dec/image.c
    sed -i -e 's/\(xcb-shape >= 1.0\)/xcb \1/' ${S}/m4/video_out.m4
}

SUMMARY = "multimedia player library"
HOMEPAGE = "https://www.xine-project.org/home"
