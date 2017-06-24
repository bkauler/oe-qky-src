# Recipe created by recipetool
# recipetool create -o bcrypt_1.1.bb http://bcrypt.sourceforge.net/bcrypt-1.1.tar.gz

LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=844f803f897dfa1aebdbb0427e6f0597"

SRC_URI = "http://bcrypt.sourceforge.net/bcrypt-${PV}.tar.gz"
SRC_URI[md5sum] = "8ce2873836ccd433329c8df0e37e298c"
SRC_URI[sha256sum] = "b9c1a7c0996a305465135b90123b0c63adbb5fa7c47a24b3f347deb2696d417d"

DEPENDS = "zlib"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e "s%/usr/local%/usr%" Makefile
    sed -i -e 's%^CC = %# CC = %' Makefile
    sed -i -e 's%^CFLAGS = %CFLAGS += %' Makefile
    sed -i -e 's%^LDFLAGS = .*%LDFLAGS += -lz%' Makefile
    sed -i -e 's%^%%' Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    #oe_runmake install DESTDIR=${D}
    install -d ${D}/usr/bin
    install -m755 bcrypt ${D}/usr/bin
    install -d ${D}/usr/share/doc
    install -m644 README ${D}/usr/share/doc/bcrypt.txt
}


HOMEPAGE = "http://bcrypt.sourceforge.net/"
SUMMARY = "A utility to encrypt files."
