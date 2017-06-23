DESCRIPTION = "ifplugd is a Linux daemon which will automatically configure your ethernet device \
when a cable is plugged in and automatically unconfigure it if the cable is pulled."
HOMEPAGE = "http://0pointer.de/lennart/projects/ifplugd/"
SECTION = "network"
DEPENDS = "libdaemon"
PR = "r0"

# BK 170613 note, 0.18 old version, has a different ethernet activity detection mechanism.
# in some cases, this works when later versions don't.

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94d55d512a9ba36caa9b7df079bae19f"

# SRC_URI = "http://0pointer.de/lennart/projects/ifplugd/ifplugd-${PV}.tar.gz
SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/ifplugd-0.18.tar.bz2"
SRC_URI[md5sum] = "638867952ce191e1732b3f391b1f952a"
SRC_URI[sha256sum] = "3f7002a1396a9731812cd4248b435fdcef265fd553b62f75f77d11ab480e7377"

S = "${WORKDIR}/ifplugd-0.18"

inherit autotools-brokensep pkgconfig

EXTRA_OECONF = "--disable-lynx --disable-xmltoman --disable-subversion"

#do not regenerate 'configure' script...
do_configure() {
    oe_runconf
}

# BK only want the ethernet activity sniffer...
# note, later versions, the utility is called 'ifplugstatus'
do_install () {
 install -d ${D}/usr/bin
 install -m755 src/ifstatus ${D}/usr/bin
}

SUMMARY = ""
