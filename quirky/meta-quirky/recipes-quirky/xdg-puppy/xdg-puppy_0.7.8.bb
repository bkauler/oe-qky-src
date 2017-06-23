# Recipe created by recipetool
# recipetool create -o xdg-puppy_0.7.8.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/x/xdg_puppy-0.7.8.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/x/xdg_puppy-${PV}.tar.gz"
SRC_URI[md5sum] = "5a589410124c9bae6d78d092927f7949"
SRC_URI[sha256sum] = "858118db2433564a9295d94a3377e3e6b064ff439876d6910b6ce27f613fcfdf"

S = "${WORKDIR}/xdg_puppy-${PV}"

#  glib-2.0-native
DEPENDS = "gtk+ libx11 gnome-menus glib-2.0 libxext libxpm"

# weird. ref: http://lists.openembedded.org/pipermail/openembedded-core/2017-February/132307.html
inherit pkgconfig

do_configure () {
    true
}

# BK notes. these are for x86_64 target build:
# CC=x86_64-oe-linux-gcc  -m64 -march=core2 -mtune=core2 -msse3 -mfpmath=sse --sysroot=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/xdg-puppy/0.7.8-r0/recipe-sysroot
# CFLAGS= -O2 -pipe -g -feliminate-unused-debug-types -fdebug-prefix-map=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/xdg-puppy/0.7.8-r0=/usr/src/debug/xdg-puppy/0.7.8-r0 -fdebug-prefix-map=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/xdg-puppy/0.7.8-r0/recipe-sysroot-native= -fdebug-prefix-map=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/xdg-puppy/0.7.8-r0/recipe-sysroot= 
# LDFLAGS=-Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed

# BK 170611 had $STAGING_INCDIR and $STAGING_LIBDIR prefix for libs and headers in CFLAGS below,
# however is for classic oe, no longer valid. then thought to have these prefixes:
SINC = "${WORKDIR}/recipe-sysroot/usr/include"
SLIB = "${WORKDIR}/recipe-sysroot/usr/lib"
# however, the "--sysroot" in CC makes any prefix unecessary. Bullsh*! that's what read online,
# but do need them.

# note, staging path: /mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/xdg-puppy/0.7.8-r0/recipe-sysroot
# usr/include/gnome-menus/gmenu-tree.h needs this: -DGMENU_I_KNOW_THIS_IS_UNSTABLE
CFLAGS += "-DGMENU_I_KNOW_THIS_IS_UNSTABLE -I${SINC}/glib-2.0 -I${SLIB}/glib-2.0/include -I${SINC}/gnome-menus"
LDFLAGS += "-lglib-2.0 -lgnome-menu"

do_compile () {
    cd fvwm-xdgmenu
    # complains implicit declaration of functions 'free', 'strcmp'...
    sed -i -e 's%^#include <gmenu-tree.h>%#include <gmenu-tree.h>\n#include <stdlib.h>\n#include <string.h>%' fvwm-xdgmenu.c
    ${CC} -c ${CFLAGS} fvwm-xdgmenu.c
    ${CC} -o fvwm-xdgmenu fvwm-xdgmenu.o ${LDFLAGS}
    cd ..

    cd icewm-xdgmenu
    # complains implicit declaration of function 'strcmp'...
    sed -i -e 's%^#include <gmenu-tree.h>%#include <gmenu-tree.h>\n#include <stdlib.h>\n#include <string.h>%' icewm-xdgmenu.c
    ${CC} -c ${CFLAGS} icewm-xdgmenu.c
    ${CC} -o icewm-xdgmenu icewm-xdgmenu.o ${LDFLAGS}
    cd ..

    cd jwm-xdgmenu
    # complains implicit declaration of function 'strcmp'...
    sed -i -e 's%^#include <gmenu-tree.h>%#include <gmenu-tree.h>\n#include <stdlib.h>\n#include <string.h>%' jwm-xdgmenu.c
    ${CC} -c ${CFLAGS} jwm-xdgmenu.c
    ${CC} -o jwm-xdgmenu jwm-xdgmenu.o ${LDFLAGS}
    cd ..

    cd openbox-xdgmenu
    # complains implicit declaration of function 'strcmp'...
    sed -i -e 's%^#include <gmenu-tree.h>%#include <gmenu-tree.h>\n#include <stdlib.h>\n#include <string.h>%' ob-xdgmenu.c
    ${CC} -c ${CFLAGS} ob-xdgmenu.c
    ${CC} -o ob-xdgmenu ob-xdgmenu.o ${LDFLAGS}
    cd ..

    cd windowmaker-xdgmenu
    # complains implicit declaration of function 'strcmp'...
    sed -i -e 's%^#include <gmenu-tree.h>%#include <gmenu-tree.h>\n#include <stdlib.h>\n#include <string.h>%' wm-xdgmenu.c
    ${CC} -c ${CFLAGS} wm-xdgmenu.c
    ${CC} -o wm-xdgmenu wm-xdgmenu.o ${LDFLAGS}
    cd ..
    
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 fvwm-xdgmenu/fvwm-xdgmenu ${D}/usr/bin
    install -m755 icewm-xdgmenu/icewm-xdgmenu ${D}/usr/bin
    install -m755 jwm-xdgmenu/jwm-xdgmenu ${D}/usr/bin
    install -m755 openbox-xdgmenu/ob-xdgmenu ${D}/usr/bin
    install -m755 windowmaker-xdgmenu/wm-xdgmenu ${D}/usr/bin
}


HOMEPAGE = "http://barryk.org/news/"
SUMMARY = "Menu generation utilities for window managers in Puppy Linux"
