# Recipe created by recipetool
# recipetool create -o setvol_1.1.bb http://www.ibiblio.org/pub/Linux/apps/sound/soundcard/setvol-1.1.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;md5=8299a5d058e9b03dba357c3f3daa4978"

SRC_URI = "http://www.ibiblio.org/pub/Linux/apps/sound/soundcard/setvol-${PV}.tar.gz"
SRC_URI[md5sum] = "2ac5ed5faff6f4c06de17a381af46776"
SRC_URI[sha256sum] = "4873bff7277130e4c8180d04277323f37df7106f8b6b0e6aaf93834628bf4861"

# NOTE: no Makefile found.
DEPENDS = "alsa-lib"

do_configure () {
    if [ -f setvol ];then
     rm -f setvol
    fi
}

do_compile () {
    ${CC} -c setvol.c ${CFLAGS}
    ${CC} -o setvol setvol.o ${LDFLAGS}
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 setvol ${D}/usr/bin
    install -d ${D}/usr/share/doc
    install -m644 README ${D}/usr/share/doc/setvol.txt
}


HOMEPAGE = ""
SUMMARY = "A simple commandline volume control."
