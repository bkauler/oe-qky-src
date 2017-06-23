# Recipe created by recipetool
# recipetool create -o planner_0.14.6.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/planner-0.14.6.tar.bz2

# BK 170615 amazing, this actually compiles!

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/planner-${PV}.tar.bz2 \
           file://704171-fix-print-preview-crash.patch \
           file://desktop-validate.patch \
           file://dependant_typo.diff \
           file://plugins_directory.diff \
           file://command_line_args.diff \
           file://no-index-sgml.patch \
           file://fix-as-needed-build.patch \
           file://planner-rmvgconf-Os.patch"
SRC_URI[md5sum] = "1f33d201f5607ddc68b06026b772ad7b"
SRC_URI[sha256sum] = "3a5577437cf1c1a27e35b5871b4d279fea622c19e6e1f32e26b44ef56d2edb7e"

DEPENDS = "libxml2 gconf gconf-native intltool-native glib-2.0 libxslt gtk+ libebml libgnomecanvas freetype libart-lgpl glib-2.0-native"

# gconf
inherit gettext pkgconfig pythonnative autotools-brokensep

EXTRA_OECONF = "--disable-schemas-install --enable-compile-warnings=no --disable-glibtest --disable-python --disable-silent-rules --disable-static --enable-shared  --disable-update-mimedb --disable-gtk-doc"

SROOT = "${WORKDIR}/recipe-sysroot"
CFLAGS += "-I${SROOT}/usr/include/libxml2"

do_configure_prepend() {
    #fool the configure, do not have libgnomeui
    cp -a ${SROOT}/usr/lib/pkgconfig/libgnomecanvas-2.0.pc ${SROOT}/usr/lib/pkgconfig/libgnomeui-2.0.pc
    #do not have scrollkeeper either...
    sed -i -e 's%scrollkeeper\-config%pkg-config%' ${S}/configure
}

do_configure() {
    oe_runconf
}

do_install() {
    install -d ${D}/etc/gconf/schemas
    install -m644 ${S}/data/planner.schemas ${D}/etc/gconf/schemas
    install -d ${D}/usr/bin
    install -m755 ${S}/src/.libs/planner ${D}/usr/bin
    install -d ${D}/usr/lib
    install -m755 ${S}/libplanner/.libs/libplanner-1.so.0.0.0 ${D}/usr/lib
    #install -m755 ${S}/libplanner/.libs/libplanner-1.so.0 ${D}/usr/lib
    #ln -s libplanner-1.so.0.0.0 ${D}/usr/lib/libplanner-1.so.0
    cp -a ${S}/libplanner/.libs/libplanner-1.so.0 ${D}/usr/lib/
    install -d ${D}/usr/lib/planner
    install -d ${D}/usr/lib/planner/file-modules
    install -d ${D}/usr/lib/planner/plugins
    install -d ${D}/usr/lib/planner/storage-modules
    install -m755 ${S}/libplanner/.libs/libmrp-xml.so ${D}/usr/lib/planner/file-modules
    install -m755 ${S}/libplanner/.libs/libmrp-xsl.so ${D}/usr/lib/planner/file-modules
    install -m755 ${S}/src/.libs/libhtml-plugin.so ${D}/usr/lib/planner/plugins
    install -m755 ${S}/src/.libs/libmsp-plugin.so ${D}/usr/lib/planner/plugins
    install -m755 ${S}/src/.libs/libxmlplanner-plugin.so ${D}/usr/lib/planner/plugins
    install -m755 ${S}/libplanner/.libs/libstorage-mrproject-1.so ${D}/usr/lib/planner/storage-modules
    install -d ${D}/usr/share/applications
    install -m644 ${S}/data/planner.desktop ${D}/usr/share/applications
    install -d ${D}/usr/share/icons/hicolor/48x48/mimetypes
    install -m644 ${S}/data/images/gnome-mime-application-x-planner.png ${D}/usr/share/icons/hicolor/48x48/mimetypes
    install -d ${D}/usr/share/mime/packages
    install -m644 ${S}/data/mime/planner.xml ${D}/usr/share/mime/packages
    install -d ${D}/usr/share/pixmaps
    install -m644 ${S}/data/images/gnome-planner.png ${D}/usr/share/pixmaps
    install -d ${D}/usr/share/planner
    install -d ${D}/usr/share/planner/dtd
    install -d ${D}/usr/share/planner/glade
    install -d ${D}/usr/share/planner/images
    install -d ${D}/usr/share/planner/sql
    install -d ${D}/usr/share/planner/stylesheets
    install -d ${D}/usr/share/planner/ui
    install -m644 ${S}/data/dtd/mrproject-0.5.1.dtd ${D}/usr/share/planner/dtd
    install -m644 ${S}/data/dtd/mrproject-0.6.dtd ${D}/usr/share/planner/dtd
    install -D ${S}/data/glade/*.glade ${D}/usr/share/planner/glade
    install -D ${S}/data/images/*.png ${D}/usr/share/planner/images
    install -D ${S}/data/sql/*.sql ${D}/usr/share/planner/sql
    install -D ${S}/data/stylesheets/*.xsl ${D}/usr/share/planner/stylesheets
    install -D ${S}/data/ui/*.ui ${D}/usr/share/planner/ui
}

HOMEPAGE = "http://live.gnome.org/Planner"
SUMMARY = "A project management application Gnome frontend"
