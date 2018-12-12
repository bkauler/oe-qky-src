# Recipe created by recipetool
# recipetool create -o glib1_1.2.10.bb https://download.gnome.org/sources/glib/1.2/glib-1.2.10.tar.gz
# patches are from OE, archlinux and t2.
# old OE patches: http://git.openembedded.org/openembedded/plain/recipes/glib-1.2/glib-1.2-1.2.10/
# arch patches: https://aur.archlinux.org/cgit/aur.git/tree/?h=glib1
# t2 patches: http://t2sde.org/packages/glib12

SUMMARY = "low-level system library required by gtk1"
HOMEPAGE = "https://download.gnome.org/sources/glib/1.2/"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=dcf3c825659e82539645da41a7908589 \
                    file://gmodule/COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

# removed:
# arch patch: file://glib1-autotools.patch
# arch patch: file://aclocal-fixes.patch;striplevel=0 

SRC_URI = "https://download.gnome.org/sources/glib/1.2/glib-${PV}.tar.gz \
           file://config-cross.patch \
           file://gcc34.patch \
           file://gcc43.patch \
           file://oe-glib-config-use-pkg-config.patch \
           file://oe-glib-reconf-fix.patch \
           file://oe-posix-conf-changes.patch \
           "
SRC_URI[md5sum] = "6fe30dad87c77b91b632def29dd69ef9"
SRC_URI[sha256sum] = "6e1ce7eedae713b11db82f11434d455d8a1379f783a79812cd2e05fc024a8d9f"

S = "${WORKDIR}/glib-${PV}"

DEPENDS = "libtool file-native"

inherit autotools-brokensep pkgconfig gettext

EXTRA_OECONF = "--enable-debug=no"

do_configure_prepend() {
 #need later config.guess, etc., to recognise x86_64 ...
 cp -a -f ${WORKDIR}/recipe-sysroot/usr/share/libtool/build-aux/config.guess ${S}/
 cp -a -f ${WORKDIR}/recipe-sysroot/usr/share/libtool/build-aux/config.sub ${S}/
}

# "reconfig" is broken, just run 'configure'...
do_configure() {
 oe_runconf
}

do_compile_prepend() {
 #ltconfig thinks cannot create shared libs (only broken when cross-compiling)
 #ltconfig generates libtool, hack it (examined diffs from compile in host)...
 sed -i -e 's%^build_libtool_libs=no%build_libtool_libs=yes%' ${S}/libtool
 sed -i -e 's%^need_lib_prefix=unknown%need_lib_prefix=no%' ${S}/libtool
 sed -i -e 's%^need_version=unknown%need_version=no%' ${S}/libtool
 sed -i -e 's%^version_type=none%version_type=linux%' ${S}/libtool
 sed -i -e 's%^library_names_spec=""%library_names_spec="\\${libname}\\${release}.so\\$versuffix \\${libname}\\${release}.so\\$major \\$libname.so"%' ${S}/libtool
 sed -i -e 's%^soname_spec=""%soname_spec="\\${libname}\\${release}.so\\$major"%' ${S}/libtool
 #sed -i -e 's%^%%' ${S}/libtool
}

FILES_${PN} += "${libdir}/glib"
