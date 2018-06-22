# Recipe created by recipetool
# recipetool create -o picscale_0.1c.bb http://distro.ibiblio.org/easyos/source/oe/pyro/picscale-0.1c.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SRC_URI = "http://distro.ibiblio.org/easyos/source/oe/pyro/picscale-${PV}.tar.gz"
SRC_URI[md5sum] = "fb58172c96973da7d80e37fbe93d2735"
SRC_URI[sha256sum] = "e5d97400f32c7cf8ce4ba0d19ae6bdd246477d01864b948527add6349096c0e5"

# NOTE: no Makefile found.
DEPENDS = "bacon gtk+ gdk-pixbuf"

do_configure () {
    true
}

do_compile () {
    
    #180622 have fixed the 0.1c source pkg...
    ##180505 syntax error line 119 picscale.bac...
    #sed -i -e 's% my_msg\$))$% my_msg$)%' picscale.bac
    
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


HOMEPAGE = "http://basic-converter.proboards.com/thread/1014/compile-picscale-openembedded"
SUMMARY = "Scale png images from the command line."
