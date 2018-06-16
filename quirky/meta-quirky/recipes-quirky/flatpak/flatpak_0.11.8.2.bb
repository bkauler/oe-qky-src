# Recipe created by recipetool

# stupid thing says that it needs systemd. but then, this project
# is from red hat.
# seems to work ok without systemd though.

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "https://github.com/flatpak/flatpak/releases/download/${PV}/flatpak-${PV}.tar.xz"
SRC_URI[md5sum] = "748c6af48b710d9a62a937c45a8fcafc"
SRC_URI[sha256sum] = "c73513135c794231d846eefae6b6b04cadda4f101d155484e63bc7e34177820d"

DEPENDS = "libxslt xmlto polkit105 libcap libseccomp glib-2.0 json-glib \
     libxml2 libarchive libxau gpgme appstream-glib bison-native ostree \
     libsoup-2.4 libyaml gcab libsoup-2.4 glib-networking openssl gnutls \
     bzip2 xz zip zlib glib-2.0-native"

inherit pkgconfig gettext autotools

EXTRA_OECONF = "--enable-introspection=no --disable-gtk-doc-html \
    --with-privileged-group=wheel --with-system-install-dir=/var/lib/flatpak \
    --disable-docbook-docs --disable-installed-tests --disable-documentation \
    --disable-static"

SUMMARY = "Linux application sandboxing and distribution framework"
HOMEPAGE = "https://github.com/flatpak/flatpak"
