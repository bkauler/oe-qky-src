DESCRIPTION = "File manager at the core of the ROX desktop"
HOMEPAGE = "http://rox.sf.net"
LICENSE = "GPLv2"
SECTION = "x11/applications"
DEPENDS = "gtk+ shared-mime-info"
RDEPENDS_${PN} = "shared-mime-info"
PR = "r1"

LIC_FILES_CHKSUM = "file://../../README;md5=02172a117c24c52b026358d2edfb3590"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/r/rox-filer-2011-10-22-has_configure-patched_quirky_20171022.tar.gz"

inherit autotools-brokensep mime pkgconfig

S = "${WORKDIR}/rox-filer-2011-10-22-has_configure-patched_quirky_20171022/ROX-Filer/src"

# do not recreate configure...
do_configure() {
    #has code to prevent compiling, remove...
    sed -i -e 's% \-f configure % -f configureXXX %' ${S}/configure
    #needs -lm -ldl
    sed -i -e 's%\-lX11 %-lX11 -lm -ldl %' ${S}/configure
    oe_runconf
}

#note, this not needed, will do this anyway...
do_compile() {
	oe_runmake
}

do_install() {
    install -d ${D}/usr/local/apps/ROX-Filer
    install -m755 ../ROX-Filer ${D}/usr/local/apps/ROX-Filer
    install -m644 ../AppInfo.xml ${D}/usr/local/apps/ROX-Filer
    install -m755 ../AppRun ${D}/usr/local/apps/ROX-Filer
    install -m644 ../Options.xml ${D}/usr/local/apps/ROX-Filer
    install -m644 ../style.css ${D}/usr/local/apps/ROX-Filer
    install -m644 ../subclasses ${D}/usr/local/apps/ROX-Filer
    install -m644 ../Templates.ui ${D}/usr/local/apps/ROX-Filer
    install -m644 ../.DirIcon ${D}/usr/local/apps/ROX-Filer/
    install -d ${D}/usr/local/apps/ROX-Filer/images
    install -D ../images/* ${D}/usr/local/apps/ROX-Filer/images
}

FILES_${PN} += "/usr/local/apps/ROX-Filer"

SRC_URI[md5sum] = "7a6914e7db5243e6d43e7c8ccffb8734"
SRC_URI[sha256sum] = "f43088dbb2fbb216cea276710a2ba2f04cb461884a931fc0c79290eb4237808f"

SUMMARY = "Draganddrop based filemanager"
