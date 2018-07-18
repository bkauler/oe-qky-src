# Recipe created by recipetool
# recipetool create -o sshfs-fuse_2.10.bb https://github.com/libfuse/sshfs/archive/sshfs-2.10.tar.gz

# NOTICE 20180715
# this is the latest in the 2.x series. The 3.x series requires later fuse than have in OE.
# not sure, but might be wiser to stay with 2.x series, it is still maintained.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/libfuse/sshfs/archive/sshfs-${PV}.tar.gz"
SRC_URI[md5sum] = "5930bf6155c75e3dfab347b9231d4bdf"
SRC_URI[sha256sum] = "6af13acda03a4632e3deb559ecc3f35881cb92e16098049a7ba4cc502650ab18"

S = "${WORKDIR}/sshfs-sshfs-${PV}"

DEPENDS = "glib-2.0 fuse"

inherit pkgconfig autotools

EXTRA_OECONF = ""

SUMMARY = "A network filesystem client to connect to SSH servers"
HOMEPAGE = "https://github.com/libfuse/sshfs"
