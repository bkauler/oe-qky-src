# Recipe created by recipetool

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/main/g/gcab/gcab_${PV}.orig.tar.xz \
      file://git-version-gen \
      file://manpage-hyphens.patch \
      file://zalloc_integer_overflow.patch \
      file://CVE-2018-5345.patch"
SRC_URI[md5sum] = "d8c54c340e56d0b6a8fe082fd04d8090"
SRC_URI[sha256sum] = "a16e5ef88f1c547c6c8c05962f684ec127e078d302549f3dfd2291e167d4adef"

DEPENDS = "glib-2.0 intltool-native glib-2.0-native"

inherit gettext autotools gobject-introspection

EXTRA_OECONF = "--enable-introspection=no --disable-gtk-doc-html --disable-static"

BBCLASSEXTEND = "native nativesdk"

SUMMARY = "Microsoft Cabinet file manipulation library"
HOMEPAGE = "https://packages.ubuntu.com/xenial-updates/libgcab-1.0-0"
