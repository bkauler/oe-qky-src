# Recipe created by recipetool
# recipetool create -o xarchive_0.2.8-6-i18n.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xarchive-0.2.8-6-i18n.tar.bz2

# note, the i18n patch is now in the source package.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

# missing fnmatch, ref: https://github.com/jabberd2/jabberd2/issues/95
# file://missing_fnmatch.patch
# no, fixed, see do_configure...

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xarchive-${PV}.tar.bz2"
SRC_URI[md5sum] = "657a11122574a6f9521b4c85526f351f"
SRC_URI[sha256sum] = "2802b59917a1937a00138c84d7ca2a302f895cb7c149691d27c3f1dbe30cdeca"

# actually, don't think it needs all those at compile time...
DEPENDS = "gtk+ zlib bzip2 xz bash dpkg rpm zip unzip unrar glib-2.0"

inherit pkgconfig autotools-brokensep gettext

#EXTRA_OECONF = ""

do_configure() {
    #avoid recreatingconfigure...
    #this fixes a cross-compile problem in configure...
    export ac_cv_func_fnmatch_works="yes"
    oe_runconf
}

do_install_append() {
    cd ${S}/src
    if [ -f xarchive.pot ];then
     rm -f xarchive.pot
    fi
    xgettext --keyword="_" main.c widgets_gtk.c myfc_gtk.c  -o xarchive.pot
    install -d ${D}/usr/share/doc/nls/xarchive
    install -m644 xarchive.pot ${D}/usr/share/doc/nls/xarchive
    cd ${S}
}

HOMEPAGE = "http://xarchive.sourceforge.net/"
SUMMARY = "A lightweight GTK2 frontend for archives."
