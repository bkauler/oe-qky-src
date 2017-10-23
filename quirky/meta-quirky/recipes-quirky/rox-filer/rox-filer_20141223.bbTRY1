DESCRIPTION = "File manager at the core of the ROX desktop"
HOMEPAGE = "http://rox.sf.net"
LICENSE = "GPLv2"
SECTION = "x11/applications"
DEPENDS = "gtk+ shared-mime-info"
RDEPENDS_${PN} = "shared-mime-info"
PR = "r0"

LIC_FILES_CHKSUM = "file://../../README;md5=02172a117c24c52b026358d2edfb3590"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/r/rox-filer-2011-10-22-t2patched20141223.tar.gz \
           file://oe-precreate-makefile.patch \
           file://oe-precreate-config-h.patch"

# inherit autotools mime pkgconfig
inherit mime pkgconfig

S = "${WORKDIR}/rox-filer-2011-10-22-t2patched20141223/ROX-Filer/src"

do_configure () {
    true
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

SRC_URI[md5sum] = "04eb615905637e3495ff91b2ddcc2c5e"
SRC_URI[sha256sum] = "25e3e39b0796025b28ed96ea9dadc469f00f0d48733d58b14b05718a113ea248"

SUMMARY = "Draganddrop based filemanager"
