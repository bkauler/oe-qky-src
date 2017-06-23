# Recipe created by recipetool
# recipetool create -o modem-stats_1.0.1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/modem-stats-1.0.1.src.elf.tar.bz2

LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://README;md5=bd39805ce2e5508722627e94b406df30"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/modem-stats-${PV}.src.elf.tar.bz2"
SRC_URI[md5sum] = "8e57037fe955f9e203fbece9e8a9714c"
SRC_URI[sha256sum] = "617427b8e7e6a258003851cb54a5017e0966e44f6ff7db65e6fc7ef09a02d0ea"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e "s%^BINDIR	= %BINDIR	= ${D}%" Makefile
    sed -i -e "s%^MANDIR	= %MANDIR	= ${D}%" Makefile
    sed -i -e 's%^CC	=%# CC	=%' Makefile
    sed -i -e 's%^CFLAGS	=%CFLAGS	+=%' Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    #oe_runmake install
    install -d ${D}/usr/bin
    install -m755 modem-stats ${D}/usr/bin
    install -d ${D}/usr/man/man1
    install -m644 modem-stats.1 ${D}/usr/man/man1
}


HOMEPAGE = ""
SUMMARY = "Send Hayes commands to a serial port."
