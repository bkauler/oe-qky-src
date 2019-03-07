# Recipe created by recipetool
# recipetool create -o idump-static_20180513.bb http://distro.ibiblio.org/easyos/source/oe/pyro/idump-20180513.tar.gz

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=c91ac29f40136aa91c40bcfa5d2c96e0"

SRC_URI = "http://distro.ibiblio.org/easyos/source/oe/pyro/idump-${PV}.tar.gz"
SRC_URI[md5sum] = "b6bf5d8a048e56a8b7efd6577739ecfb"
SRC_URI[sha256sum] = "85fb49567d8beebdeeee2b539a7edd618838ba9404703e31883e7b594dc16b8a"

S = "${WORKDIR}/idump-${PV}/static"

# 'static' folder has source without any dependencies, inbuilt png, jpeg, gif...
DEPENDS = ""

# note, could have done it this way...
# LDFLAGS += " -static"

do_configure () {
 sed -i -e 's%^CC%# CC%' makefile
 sed -i -e 's%^LDFLAGS%# LDFLAGS%' makefile
 sed -i -e 's%^CFLAGS%# CFLAGS%' makefile
 sed -i '/native/d' makefile
 mv -f makefile Makefile
}

do_compile () {
 #some CFLAGS from original makefile...
 oe_runmake idump CFLAGS="${CFLAGS} -std=c99 -pedantic -Os" LDFLAGS="${LDFLAGS} -static"
}

do_install () {
 install -d ${D}/usr/sbin
 install -m 755 idump ${D}/usr/sbin
}

HOMEPAGE = "https://github.com/uobikiemukot/idump"
SUMMARY = "Tiny image viewer for Linux framebuffer"
