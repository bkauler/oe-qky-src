# Recipe created by recipetool
# recipetool create -o helpsurfer_0.0.7-p-libgtkhtml.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/Surfer-0.0.7-patched_libgtkhtml.tar.bz2
# 20171105 have updated to helpsurfer 0.5.

#refer:
# http://murga-linux.com/puppy/viewtopic.php?t=111186
# http://bkhome.org/news/201708/improving-surfer-tiny-web-browser.html
# http://bkhome.org/news/201708/helpsurfer-02.html
# http://bkhome.org/news/201708/helpsurfer-03.html

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/h/helpsurfer-0.5.tar.gz"
SRC_URI[md5sum] = "82603470e97f287c2c3147e22c21dbf8"
SRC_URI[sha256sum] = "bcae01db377d9c625ee44be4b0050a47d380d74209e7860dd2b545bcaafabccc"

S = "${WORKDIR}/helpsurfer-0.5"

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


HOMEPAGE = "http://murga-linux.com/puppy/viewtopic.php?t=111186"
SUMMARY = "A tiny web browser for viewing local html files."
