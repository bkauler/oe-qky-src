# Recipe created by recipetool
# recipetool create -o installwatch_0.7.0beta7-p1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/installwatch-0.7.0beta7.tar.bz2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0c56db0143f4f80c369ee3af7425af6e"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/installwatch-0.7.0beta7.tar.bz2 \
           file://07-Drop-cases-for-glibc-2.4.patch \
           file://11-fix-crash-when-sizeof-mode_t-sizeof-int.patch \
           file://12-fix-scandir.patch"
SRC_URI[md5sum] = "a1aefcf3b97e9ef8095981b0e6c52a4e"
SRC_URI[sha256sum] = "7913658b2504e44776440bcddebd3732deeca166ec52e69f4ca2a36549396c9a"

S = "${WORKDIR}/${BPN}-0.7.0beta7"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    sed -i -e 's%/usr/local%/usr%' Makefile
    sed -i -e 's%gcc %$(CC) $(CFLAGS) %' Makefile
    sed -i -e 's%ld %$(LD) %' Makefile
    #oh, odd, $(D) is nothing in the Makefile, substitute before...
    sed -i -e "s%^BINDIR=%BINDIR=${D}%" Makefile
    sed -i -e "s%^LIBDIR=%LIBDIR=${D}%" Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install
}


HOMEPAGE = ""
SUMMARY = "Monitor package installation."
