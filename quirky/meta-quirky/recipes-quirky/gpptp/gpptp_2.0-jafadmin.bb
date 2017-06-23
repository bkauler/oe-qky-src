# Recipe created by recipetool
# recipetool create -o gpptp_2.0-jafadmin.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gpptp-2.0-jafadmin.tar.bz2

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/gpptp-${PV}.tar.bz2"
SRC_URI[md5sum] = "687d3e96604ab66082743f12f3621d5f"
SRC_URI[sha256sum] = "5fc34aa87791d18b2c94972d88fa486c7967f1c102e99a8e381952f5690c4952"

# BK 170611 Makefile only.
# CC = x86_64-oe-linux-gcc  -m64 -march=core2 -mtune=core2 -msse3 -mfpmath=sse --sysroot=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot
# CFLAGS =  -O2 -pipe -g -feliminate-unused-debug-types -fdebug-prefix-map=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0=/usr/src/debug/gpptp/2.0-jafadmin-r0 -fdebug-prefix-map=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot-native= -fdebug-prefix-map=/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot= 
# LDFLAGS = -Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed
# pwd = /mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/gpptp-2.0-jafadmin
# -lgtk-x11-2.0 -lgdk-x11-2.0 -lpangocairo-1.0 -latk-1.0 -lcairo -lgdk_pixbuf-2.0 -lgio-2.0 -lpangoft2-1.0 -lpango-1.0 -lgobject-2.0 -lglib-2.0 -lfontconfig -lfreetype
# -pthread -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/gtk-2.0 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/lib/gtk-2.0/include -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/pango-1.0 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/atk-1.0 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/cairo -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/pixman-1 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/libpng16 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/gdk-pixbuf-2.0 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/libpng16 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/pango-1.0 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/harfbuzz -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/pango-1.0 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/glib-2.0 -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/lib/glib-2.0/include -I/mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/gpptp/2.0-jafadmin-r0/recipe-sysroot/usr/include/freetype2

DEPENDS = "gtk+"
inherit pkgconfig

do_configure () {
    #test...
    #echo "CC = ${CC}" > ${TMPDIR}/VARS.LOG
    #echo "CFLAGS = ${CFLAGS}" >> ${TMPDIR}/VARS.LOG
    #echo "LDFLAGS = ${LDFLAGS}" >> ${TMPDIR}/VARS.LOG
    #echo -n "pwd = " >> ${TMPDIR}/VARS.LOG
    #pwd >> ${TMPDIR}/VARS.LOG
    #pkg-config --libs gtk+-2.0 >> ${TMPDIR}/VARS.LOG
    #pkg-config --cflags gtk+-2.0 >> ${TMPDIR}/VARS.LOG
    true
}

do_compile () {
    #path prefix gets appended when run pkg-config (see test above)
    ${CC} -o gpptp gpptp.c ${CFLAGS} ${LDFLAGS} `pkg-config --libs gtk+-2.0` `pkg-config --cflags gtk+-2.0`
    ${CC} -o mk-vpn-key mk-vpn-key.c ${CFLAGS} ${LDFLAGS}
}

do_install () {
    install -d ${D}/usr/sbin
    install -m755 gpptp ${D}/usr/sbin
    install -m755 mk-vpn-key ${D}/usr/sbin
}


HOMEPAGE = ""
SUMMARY = "Linux PPTP Client"
