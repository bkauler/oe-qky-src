# Recipe created by recipetool

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=155db86cdbafa7532b41f390409283eb"

SRC_URI = "https://www.freedesktop.org/software/polkit/releases/polkit-${PV}.tar.gz \
       file://01_pam_polkit.patch \
       file://02_gettext.patch \
       file://03_complete_session.patch \
       file://04_get_cwd.patch \
       file://05_revert-admin-identities-unix-group-wheel.patch \
       file://06_systemd-service.patch \
       file://07_set-XAUTHORITY-environment-variable-if-unset.patch \
       file://08_deprecate_racy_APIs.patch \
       file://cve-2013-4288.patch \
       file://09_pam_environment.patch \
       file://git_type_registration.patch"
SRC_URI[md5sum] = "9c29e1b6c214f0bd6f1d4ee303dfaed9"
SRC_URI[sha256sum] = "8fdc7cc8ba4750fcce1a4db9daa759c12afebc7901237e1c993c38f08985e1df"

S = "${WORKDIR}/polkit-${PV}"

DEPENDS = "expat intltool-native glib-2.0 libxslt glib-2.0-native \
      gobject-introspection glib-networking libsoup-2.4 gpgme libassuan \
      gobject-introspection-native"

inherit gettext pkgconfig autotools-brokensep

EXTRA_OECONF = "--with-authfw=shadow --disable-gtk-doc-html --disable-static \
           --enable-introspection=yes --disable-examples --enable-systemd=no \
           --disable-verbose-mode --disable-man-pages --with-os-type=unknown \
           --disable-introspection"

do_configure() {
 #just having "oe_runconf" in here avoids the rebuilding of 'configure' script
 oe_runconf
}

SROOT = "${WORKDIR}/recipe-sysroot"
SRNATIVE = "${WORKDIR}/recipe-sysroot-native"

# too much trouble, have disabled introspection...
#do_compile_prepend() {
# for aDIR in src/examples src/nullbackend src/polkit src/polkitagent src/polkitbackend src/polkitd src/programs src
# do
#  sed -i -e "s%^INTROSPECTION_COMPILER = /%INTROSPECTION_COMPILER = ${SRNATIVE}/%" ${B}/${aDIR}/Makefile
#  sed -i -e "s%^INTROSPECTION_GENERATE = /%INTROSPECTION_GENERATE = ${SRNATIVE}/%" ${B}/${aDIR}/Makefile
#  sed -i -e "s%^INTROSPECTION_GIRDER = /%INTROSPECTION_GIRDER = ${SROOT}/%" ${B}/${aDIR}/Makefile
#  sed -i -e "s%^INTROSPECTION_MAKEFILE = /%INTROSPECTION_MAKEFILE = ${SROOT}/%" ${B}/${aDIR}/Makefile
#  sed -i -e "s%^INTROSPECTION_SCANNER = /%INTROSPECTION_SCANNER = ${SRNATIVE}/%" ${B}/${aDIR}/Makefile
#  sed -i -e "s%^INTROSPECTION_TYPELIBDIR = /%INTROSPECTION_TYPELIBDIR = ${SROOT}/%" ${B}/${aDIR}/Makefile
# done
#}

HOMEPAGE = "http://www.freedesktop.org/wiki/Software/polkit"
SUMMARY = "PolicyKit Authorization Framework"

# note, creates folder /var/lib/polkit-1
