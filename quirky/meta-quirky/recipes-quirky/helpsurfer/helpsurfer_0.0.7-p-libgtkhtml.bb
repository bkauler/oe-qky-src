# Recipe created by recipetool
# recipetool create -o helpsurfer_0.0.7-p-libgtkhtml.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/Surfer-0.0.7-patched_libgtkhtml.tar.bz2

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/Surfer-0.0.7-patched_libgtkhtml.tar.bz2"
SRC_URI[md5sum] = "bbef4e2ab39fc64f3f0168768548a16f"
SRC_URI[sha256sum] = "c982dfac14c5a2ef2b5449a025b8831a88497d27e0b70bb7c698721f1149b689"

S = "${WORKDIR}/Surfer-0.0.7-patched_libgtkhtml"

# NOTE: this is a Makefile-only piece of software.

DEPENDS = "gtk+ libgtkhtml gnet libsystem gdk-pixbuf openssl libxml2"
inherit pkgconfig

SUSR = "${WORKDIR}/recipe-sysroot/usr"

do_configure () {
    if [ -f ${S}/download ];then
     rm -f ${S}/download
    fi
    if [ -f ${S}/surfer ];then
     rm -f ${S}/surfer
    fi
    sed -i -e 's%^CC	=%# CC	=%' ${S}/src/Makefile
    sed -i -e 's%^CFLAGS	=%CFLAGS	+=%' ${S}/src/Makefile
    sed -i -e 's%^LDFLAGS	=%# LDFLAGS	=%' ${S}/src/Makefile
    sed -i -e 's%^DESTDIR	=%# DESTDIR	=%' ${S}/src/Makefile
    sed -i -e 's%^surfer_LDFLAGS.*%surfer_LDFLAGS = $(LDFLAGSF) $(LDFLAGS) -L $(SUSR)/lib -Wl,-rpath,$(SUSR)/lib -l System `pkg-config --libs gtk+-2.0  libgtkhtml-2.0 gnet-2.0`%' ${S}/src/Makefile
    sed -i -e 's%^DESTDIR	=%# DESTDIR	=%' ${S}/data/Makefile
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install DESTDIR=${D}
}


HOMEPAGE = ""
SUMMARY = "A tiny web browser for viewing local html files."
