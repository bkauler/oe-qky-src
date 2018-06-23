SUMMARY = "Open Source multimedia player"
DESCRIPTION = "mpv is a fork of mplayer2 and MPlayer. It shares some features with the former projects while introducing many more."
SECTION = "multimedia"
HOMEPAGE = "http://www.mpv.io/"

# BK 20180623 added: mpg123 xvidcore
# added deps as used in xine-lib + more... removed xsp
DEPENDS = "zlib ffmpeg jpeg virtual/libx11 libxv \
           libxscrnsaver libv4l libxinerama \
           libxext fontconfig freetype libx11 librsvg libpng alsa-lib \
           libdvdnav faac faad2 flac gdk-pixbuf mesa libglu liba52 libmad libmng \
           libtheora libva libvdpau libvorbis libogg libvpx libsdl libsdl-image \
           libsdl-mixer libsdl-ttf speex libmodplug vcdimager wavpack x264 libxcb \
           libxvmc lame lcms libcdio libraw1394 libavc1394 libdc1394 mpeg2dec \
           schroedinger taglib openssl libsamplerate0 libbluray mesa libdvdread \
           libdvdcss libcddb libcdio-paranoia libarchive libdrm libwebp \
           mpg123 xvidcore"

REQUIRED_DISTRO_FEATURES = "x11"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91f1cb870c1cc2d31351a4d2595441cb"

# While this item does not require it, it depends on ffmpeg which does
LICENSE_FLAGS = "commercial"

# SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/m/mpv-${PV}.tar.gz"
SRC_URI = " \
    https://github.com/mpv-player/mpv/archive/v${PV}.tar.gz;name=mpv \
    http://www.freehackers.org/~tnagy/release/waf-1.8.12;name=waf;downloadfilename=waf;subdir=${BPN}-${PV} \
"
SRC_URI[mpv.md5sum] = "8cfb48e921e58c0d9d181d96d4809beb"
SRC_URI[mpv.sha256sum] = "2ad104d83fd3b2b9457716615acad57e479fd1537b8fc5e37bfe9065359b50be"
SRC_URI[waf.md5sum] = "cef4ee82206b1843db082d0b0506bf71"
SRC_URI[waf.sha256sum] = "01bf2beab2106d1558800c8709bc2c8e496d3da4a2ca343fe091f22fca60c98b"

inherit waf pkgconfig pythonnative distro_features_check

# removed...
## Note: both lua and libass are required to get on-screen-display (controls)
#PACKAGECONFIG ??= " \
#    lua \
#    libass \
#    ${@bb.utils.filter('DISTRO_FEATURES', 'wayland', d)} \
#"
PACKAGECONFIG[drm] = "--enable-drm,--disable-drm,libdrm"
PACKAGECONFIG[gbm] = "--enable-gbm,--disable-gbm,virtual/mesa"
PACKAGECONFIG[lua] = "--enable-lua,--disable-lua,lua luajit"
PACKAGECONFIG[libass] = "--enable-libass,--disable-libass,libass"
PACKAGECONFIG[libarchive] = "--enable-libarchive,--disable-libarchive,libarchive"
PACKAGECONFIG[jack] = "--enable-jack, --disable-jack, jack"
PACKAGECONFIG[vaapi] = "--enable-vaapi, --disable-vaapi,libva"
PACKAGECONFIG[vdpau] = "--enable-vdpau, --disable-vdpau,libvdpau"
PACKAGECONFIG[wayland] = "--enable-wayland, --disable-wayland,wayland libxkbcommon"

SIMPLE_TARGET_SYS = "${@'${TARGET_SYS}'.replace('${TARGET_VENDOR}', '')}"

# removed: --disable-encoding 
EXTRA_OECONF = " \
    --prefix=${prefix} \
    --target=${SIMPLE_TARGET_SYS} \
    --confdir=${sysconfdir}/mpv \
    --datadir=${datadir} \
    --disable-manpage-build \
    --enable-gl \
    --disable-libsmbclient \
    --enable-libbluray \
    --enable-dvdread \
    --enable-dvdnav \
    --enable-cdda \
    --disable-uchardet \
    --disable-rubberband \
    --enable-lcms2 \
    --disable-vapoursynth \
    --disable-vapoursynth-lazy \
    --disable-debug-build \
    --disable-pulse \
    --enable-libmpv-shared \
    --enable-drm \
    --enable-alsa \
    --enable-libarchive \
    --disable-lua \
    ${PACKAGECONFIG_CONFARGS} \
"

adjust_waf_perms() {
    chmod +x ${S}/waf
}

do_patch[postfuncs] += "adjust_waf_perms"

FILES_${PN} += "${datadir}/icons"
