DESCRIPTION = "ifplugd is a Linux daemon which will automatically configure your ethernet device \
when a cable is plugged in and automatically unconfigure it if the cable is pulled."
HOMEPAGE = "http://0pointer.de/lennart/projects/ifplugd/"
SECTION = "network"
DEPENDS = "libdaemon"
PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://0pointer.de/lennart/projects/ifplugd/ifplugd-${PV}.tar.gz \
 file://kernel-types.patch \
 file://nobash.patch"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-lynx --disable-xmltoman --disable-subversion"

SRC_URI[md5sum] = "cbb45e24684fe5ba7a60730248cf250b"
SRC_URI[sha256sum] = "a43c0621dac846e42a3917f4f73e7976b2ac4b545712e8bc4bae5bac6158e07e"

# BK only want the ethernet activity sniffer...
do_install () {
 install -d ${D}/usr/bin
 install -m755 src/ifplugstatus ${D}/usr/bin
}

SUMMARY = "A daemon to automatically configure a ethernet device on state change"
