# Recipe created by recipetool

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/o/ostree/ostree_${PV}.orig.tar.xz \
           file://Don-t-write-to-parent-repo.patch"
SRC_URI[md5sum] = "43c78c951534207d4ecad0cebd85a209"
SRC_URI[sha256sum] = "f5b1e083ed630fd32a263731fe9595ecdd07cfd5cba3e354931f481c4181de1c"

S = "${WORKDIR}/lib${BPN}-${PV}"

DEPENDS = "bison-native curl xz gpgme glib-2.0 e2fsprogs zlib \
      libassuan polkit105 libsoup-2.4 glib-networking libarchive \
      openssl fuse glib-2.0-native"

inherit pkgconfig autotools

EXTRA_OECONF = "--disable-installed-tests --enable-introspection=no \
      --disable-gtk-doc-html --disable-man --without-selinux --without-avahi \
      --without-libsystemd"

