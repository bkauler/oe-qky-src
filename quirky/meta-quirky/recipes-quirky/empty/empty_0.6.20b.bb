# Recipe created by recipetool
# recipetool create -o empty_0.6.20b.bb https://sourceforge.net/projects/empty/files/empty/empty-0.6.20b/empty-0.6.20b.tgz

LICENSE = "GPL-1.0"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=92bdef9f92d08cb685e9ebdd4766a874"

SRC_URI = "https://sourceforge.net/projects/empty/files/empty/empty-${PV}/empty-${PV}.tgz"
SRC_URI[md5sum] = "d576754795ab4eb1c528ca2a98b5d545"
SRC_URI[sha256sum] = "7e6636e400856984c4405ce7bd0843aaa3329fa3efd20c58df8400a9eaa35f09"


do_configure () {
	sed -i -e 's%^CC%# CC%' Makefile
	sed -i -e 's%^PREFIX%# PREFIX%' Makefile
}

do_compile () {
	oe_runmake all
}

do_install () {
	#oe_runmake install PREFIX=${PREFIX}
	install -d ${D}/usr/bin
	install -m755 empty ${D}/usr/bin
}

HOMEPAGE = "http://empty.sourceforge.net/"
SUMMARY = "run processes under pseudo-terminal sessions"
