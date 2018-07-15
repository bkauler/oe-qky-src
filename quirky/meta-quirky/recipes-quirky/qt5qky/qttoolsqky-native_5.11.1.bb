# Recipe created by recipetool

# ***NOTICE***
# this recipe requires the host to have /usr/bin/qmake
# note, an alternative approach might be: github.com/tsuna/autotroll

LICENSE = "GPLv3 & GPLv2 & LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
                    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \
                    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
                    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI = "http://download.qt.io/official_releases/qt/5.11/${PV}/submodules/qttools-everywhere-src-${PV}.tar.xz"
SRC_URI[md5sum] = "41aea9500d21bd03bfa718b1d715cbba"
SRC_URI[sha256sum] = "b7fb186f92aedb922c4e7f57ff276bbf90caf0087a2a980f704bad9ac44514fe"

S = "${WORKDIR}/qttools-everywhere-src-${PV}"
PN = "qttools-native"

inherit native autotools-brokensep

do_configure() {
 /usr/bin/qmake -o Makefile qttools.pro
}

do_compile() {
 oe_runmake
}

XXXdo_install() {
 oe_runmake install INSTALL_ROOT=${D}
}

# or...
do_install() {
 mkdir -p ${D}${bindir}
 mkdir -p ${D}${libdir}/qt5/plugins
 mkdir -p ${D}${libdir}/qt5/mkspecs
 mkdir -p ${D}${libdir}/qt5/qml
 mkdir -p ${D}${datadir}/mime/image
 mkdir -p ${D}${datadir}/qt5
 mkdir -p ${D}${includedir}/qt5
 aDIR="."
  for asubDIR in bin lib plugins include mkspecs
  do
   case ${asubDIR} in
    bin)
     cp -a -f --remove-destination ${aDIR}/bin/* ${D}${bindir}/
    ;;
    lib)
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
   esac
  done
}

# is this needed?
NATIVE_INSTALL_WORKS = "1"

INSANE_SKIP_${PN} = "installed-vs-shipped file-rdeps"
FILES_${PN} += "${bindir}/* ${libdir}/* ${datadir}/* ${includedir}/*"
SUMMARY = "Host tools for Qt5 widget library"
HOMEPAGE = "https://www.qt.io/"
