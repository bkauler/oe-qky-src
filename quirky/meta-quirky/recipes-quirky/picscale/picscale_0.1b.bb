# Recipe created by recipetool
# recipetool create -o picscale_0.1b.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/picscale-0.1b.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://picscale.bac;md5=a75dda9eace8096fdf73f14bb8ede9fd"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/picscale-${PV}.tar.bz2"
SRC_URI[md5sum] = "5ebc49f67c5bfcbbb5c0a7f723da17c0"
SRC_URI[sha256sum] = "e30e6e5025c41ef433d30095907e3cd90122d4d19fd5ecdcd4d7d01c829191dc"

# NOTE: no Makefile found.
DEPENDS = "bacon gtk+ gdk-pixbuf"

do_configure () {
    true
}

do_compile () {
    
    #180505 syntax error line 119 picscale.bac...
    sed -i -e 's% my_msg\$))$% my_msg$)%' picscale.bac
    
    mkdir -p temp1
    # -n convert to C only, -a rebuild libbacon.a, -p preserve temporary files,
    # -y automatically delete temporary files, -x extract gettext strings...
    ${TMPDIR}/bacon.sh -y -n -p -d temp1 picscale.bac
    cd temp1
	${CC} -fPIC -c picscale.bac.c ${CFLAGS}
	${CC} -o picscale picscale.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 temp1/picscale ${D}/usr/bin
}


HOMEPAGE = ""
SUMMARY = "Scale png images from the command line."
