# Recipe created by recipetool
# recipetool create -o isomaster_1.3.13.bb http://littlesvr.ca/isomaster/releases/isomaster-1.3.13.tar.bz2

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE.TXT;md5=2d92b9fe342120fdeb2efa83b95c4b18"

SRC_URI = "http://littlesvr.ca/isomaster/releases/isomaster-${PV}.tar.bz2"
SRC_URI[md5sum] = "0fe6a1d862feb954d8f760d23829e5b4"
SRC_URI[sha256sum] = "b700d10f1de240fe385e4294205e6cf5e51c0552f72efe26ae4a112a374a9e18"

# NOTE: the following library dependencies are unknown, ignoring: iniparser
#       (this is based on recipes that have previously been built and packaged)

# NOTE: this is a Makefile-only piece of software.
DEPENDS = "gtk+"
inherit pkgconfig gettext

do_configure () {
    sed -i -e 's%/usr/local%/usr%' Makefile
    sed -i -e 's%mousepad%defaulttexteditor%' Makefile
    sed -i -e 's%firefox%defaultbrowser%' Makefile
    sed -i -e 's%^export CC %# export CC %' Makefile
    sed -i -e 's%^export AR %# export AR %' Makefile
    sed -i -e 's%^CC      =%# CC      =%' iniparser-2.17/Makefile
    sed -i -e 's%^CFLAGS  = -O3 %CFLAGS  += -O2 %' iniparser-2.17/Makefile
    sed -i -e 's%^AR	    =%# AR	    =%' iniparser-2.17/Makefile
    sed -i -e 's%^LDFLAGS = %# LDFLAGS = %' iniparser-2.17/Makefile
    sed -i -e 's%^LDSHFLAGS = -shared .*%LDSHFLAGS = -shared $(LDFLAGS)%' iniparser-2.17/Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
	oe_runmake install DESTDIR=${D}
}


HOMEPAGE = "http://www.littlesvr.ca/isomaster/"
SUMMARY = "Create or customise CDDVD images make Bootable CDsDVDs."
