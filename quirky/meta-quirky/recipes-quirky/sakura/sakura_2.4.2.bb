LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL;md5=40b505c793557ad69a6307d6b00940a5"

PR = "r1"

# patch to compile manually...
SRC_URI = "http://www.pleyades.net/david/projects/sakura/sakura-${PV}.tar.bz2 \
           file://sakura-2.4.2-compile-hack.patch"

SRC_URI[md5sum] = "46669519c77f7402b2de24cdefe251bb"
SRC_URI[sha256sum] = "c5e6242ca4afba3ad43731939f7d2a728bd40056a93de50f34e5bf76a696fad6"

DEPENDS = "gtk+ glib-2.0 vte"

# REMOVE THIS:
#inherit cmake pkgconfig
## do_compile fail: "src/sakura.c:24:20: fatal error: stdlib.h: No such file or directory"
## tried this, no go:  -DCMAKE_NO_SYSTEM_FROM_IMPORTED=1
#EXTRA_OECMAKE = "-DCMAKE_INSTALL_PREFIX=/usr -DCMAKE_NO_SYSTEM_FROM_IMPORTED=1"
## re above error, try this
#SINC = "${WORKDIR}/recipe-sysroot/usr/include"
#CFLAGS += "-I${SINC}"

inherit pkgconfig

do_configure () {
    true
}

do_compile () {
    ${CC} -o sakura src/sakura.c ${CFLAGS} ${LDFLAGS} `pkg-config --cflags --libs gtk+-2.0 vte` -lX11
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 sakura ${D}/usr/bin
}


HOMEPAGE = "http://www.pleyades.net/david/projects/sakura"
SUMMARY = "sakura is a terminal emulator based on GTK and libvte"
