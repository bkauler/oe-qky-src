# Recipe created by recipetool
# recipetool create -o qt5qky_5.10.1.bb http://download.qt.io/official_releases/qt/5.10/5.10.1/single/qt-everywhere-src-5.10.1.tar.xz

SECTION = "libs"

LICENSE = "LGPLv3 & GPLv2 & GPLv3 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.GPLv3;md5=88e2b9117e6be406b5ed6ee4ca99a705 \
                    file://LICENSE.LGPLv3;md5=e0459b45c5c4840b353141a8bbed91f0 \
                    file://.QT-FOR-DEVICE-CREATION-LICENSE-AGREEMENT;md5=2246c83efc67754b1ccdea9883f8adf9 \
                    file://LGPL_EXCEPTION.txt;md5=9625233da42f9e0ce9d63651a9d97654 \
                    file://LICENSE.GPLv2;md5=c96076271561b0e3785dad260634eaa8 \
                    file://.QT-FOR-APPLICATION-DEVELOPMENT-LICENSE-AGREEMENT;md5=2246c83efc67754b1ccdea9883f8adf9"

SRC_URI = "http://download.qt.io/official_releases/qt/5.11/${PV}/single/qt-everywhere-src-${PV}.tar.xz"
SRC_URI[md5sum] = "c6f0854d7de7bde80cfd8cc85bb7152b"
SRC_URI[sha256sum] = "39602cb08f9c96867910c375d783eed00fc4a244bffaa93b801225d17950fb2b"

S = "${WORKDIR}/qt-everywhere-src-${PV}"

inherit autotools-brokensep pkgconfig gettext

DEPENDS = "icu cairo freetype libvisio fontconfig libfreehand tiff boost cups \
           libpagemaker virtual/libgl jpeg libcdr zlib librevenge libxml2 libmspub \
           poppler librsvg sqlite3 hunspell libdrm libcdr expat libxml2 libjpeg-turbo \
           lcms pixman libpng harfbuzz ghostscript libmspub libxcb libxrender \
           libx11 libxext openssl mesa gnutls glib-2.0 graphite2 expat xz util-linux \
           libxau libxdmcp libxshmfence libgcrypt libxdamage libxfixes libxxf86vm libdrm \
           libidn libunistring nettle gmp libxau ninja re2c meson alsa-lib alsa-utils \
           at-spi2-atk at-spi2-core dbus \
           eudev mtdev dbus giflib libpcre xcb-proto qttools-native"

# ref: https://stackoverflow.com/questions/22540239/what-would-be-a-pratical-example-of-sysroot-and-prefix-options-for-qt
# ... -sysroot is where configure looks for all the deps, -extprefix is where pkg gets installed.

do_configure() {
 
 ##the patch requires this to exist...
 #touch qtbase/mkspecs/oe-device-extra.pri
 
 ##this is an experiment, in case ever want to add "native" classs...
 #if [ "$STAGING_DIR_TARGET" == "" ];then #see native.bbclass
 # SROOT="${STAGING_DIR_NATIVE}"
 # SGCC="-no-gcc-sysroot"
 #else
  SROOT="${WORKDIR}/recipe-sysroot"
 # #SROOT="${STAGING_DIR_TARGET}"
  SGCC=""
 #fi
 
 #ex: x86_64-oe-linux-gcc becomes x86_64-oe-linux-
 CCprefix="${CC%-*}-"
 QMAKE_CMDLINE=/usr/bin/qmake ./configure \
 -sysroot ${SROOT} \
 ${SGCC} \
 -device linux-generic-g++ \
 -device-option CROSS_COMPILE="${CCprefix}"  \
 -extprefix ${D} \
 -prefix ${prefix} \
 -sysconfdir ${sysconfdir}/xdg \
 -archdatadir ${libdir}/qt5 \
 -bindir ${bindir} \
 -plugindir ${libdir}/qt5/plugins \
 -importdir ${libdir}/qt5/imports \
 -headerdir ${includedir}/qt5 \
 -datadir ${datadir}/qt5 \
 -docdir ${datadir}/doc/qt5 \
 -translationdir ${datadir}/qt5/translations \
 -examplesdir ${datadir}/doc/qt5/examples \
 -confirm-license \
 -opensource \
 -system-harfbuzz \
 -system-sqlite \
 -nomake examples \
 -no-rpath \
 -skip qtwebengine \
 -no-directfb \
 -no-pulseaudio \
 -skip qttranslations \
 -skip qtserialport \
 -no-warnings-are-errors \
 -no-gstreamer \
 -no-warnings-are-errors \
 -alsa \
 -openssl -icu -fontconfig -mtdev -sql-sqlite \
 -xcb -xcb-xlib \
 -dbus -cups \
 -opengl desktop \
 -system-zlib -gif -system-libpng -system-libjpeg -system-freetype
}

do_install() {
 #make install
 #...weird, install is to ${WORKDIR}/image, but only folders and symlinks and some files.
 #...log.do_install shows errors like this:
 #/mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.10.1-r0/qt-everywhere-src-5.10.1/qtbase/bin/qmake -install qinstall /mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.10.1-r0/qt-everywhere-src-5.10.1/qtbase/src/3rdparty/zlib/src/zconf.h /mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.10.1-r0/image/include/qt5/QtZlib/zconf.h
 #Error copying /mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.10.1-r0/qt-everywhere-src-5.10.1/qtbase/src/3rdparty/zlib/src/zconf.h to /mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.10.1-r0/image/include/qt5/QtZlib/zconf.h: Cannot create
 #besides, host 'qmake' has to run.
 #instead, do it all manually...
 mkdir -p ${D}${bindir}
 mkdir -p ${D}${libdir}/qt5/plugins
 mkdir -p ${D}${libdir}/qt5/mkspecs
 mkdir -p ${D}${libdir}/qt5/qml
 mkdir -p ${D}${datadir}/mime/image
 mkdir -p ${D}${datadir}/qt5
 mkdir -p ${D}${includedir}/qt5
 #these are the only ones i want...
 for aDIR in qtbase qtdeclarative qtmultimedia qtsvg qttools qtx11extras qtxmlpatterns
 do
  for asubDIR in bin lib plugins include mkspecs qml
  do
   if [ "$(ls ${aDIR}/${asubDIR} -1)" == "" ];then
    continue
   fi
   case ${asubDIR} in
    bin)
     #licheck* binaries are for different architectures, OE will fail QA check...
     rm -f ${aDIR}/bin/licheck*
     cp -a -f --remove-destination ${aDIR}/bin/* ${D}${bindir}/
    ;;
    lib)
     if [ -d ${aDIR}/lib/pkgconfig ];then
      #.pc files have lines like this:
      # Libs.private: -L/mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.10.1-r0/qt-everywhere-src-5.10.1/qtbase/lib -lQt5Gui -lQt5Core -lpthread -lGL
      sed -i -e 's%\-L/mnt/[^ ]*%%g' ${aDIR}/lib/pkgconfig/*.pc
      #prefix is wrong in pkgconfig/*.pc files...
      sed -i -e 's%^prefix=.*%prefix=/usr%' ${aDIR}/lib/pkgconfig/*.pc
     fi
     #so do .prl files:
     sed -i -e 's%\-L/mnt/[^ ]*%%g' ${aDIR}/lib/*.prl
     #get rid of this line (ref: http://www.linuxfromscratch.org/blfs/view/svn/x/qt5.html)
     sed -i -e '/^QMAKE_PRL_BUILD_DIR/d' ${aDIR}/lib/*.prl
     cp -a -f --remove-destination ${aDIR}/lib/* ${D}${libdir}/
    ;;
    plugins)
     cp -a -f --remove-destination ${aDIR}/plugins/* ${D}${libdir}/qt5/plugins/
    ;;
    include)
     cp -a -f --remove-destination ${aDIR}/include/* ${D}${includedir}/qt5/
    ;;
    mkspecs)
     cp -a -f --remove-destination ${aDIR}/mkspecs/* ${D}${libdir}/qt5/mkspecs/
    ;;
    qml)
     cp -a -f --remove-destination ${aDIR}/qml/* ${D}${libdir}/qt5/qml/
    ;;
   esac
  done
 done
}

XXXdo_install() {
 #oe_runmake install INSTALL_ROOT=${D}
 #...this installed:
 # /mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.11.1-r0/image/mnt/sdb1/projects/oe/pyro/oe-quirky/buildPC/tmp-glibc/work/nocona-64-oe-linux/qt5qky/5.11.1-r0/image
 # ...yikes! with binaries missing from that final 'image' folder. try this...
 oe_runmake install DESTDIR=${D}
 #...installs to 'image', but binaries still missing.
}

FILES_${PN} += "${bindir}/* ${libdir}/* ${includedir}/* ${datadir}/*"

INSANE_SKIP_${PN} = "installed-vs-shipped file-rdeps"

SUMMARY = "Qt5 widget library"
HOMEPAGE = "https://www.qt.io/"
