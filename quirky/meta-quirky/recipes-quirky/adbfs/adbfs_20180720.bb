# Recipe created by recipetool
# recipetool create -o adbfs_20180720.bb https://github.com/spion/adbfs-rootless.git

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://license;md5=15aa36fa11eecde9dcbdbb95edbbafd6"

SRC_URI = "git://github.com/spion/adbfs-rootless.git;protocol=https"

# Modify these as desired
PV = "20180720+git${SRCPV}"
SRCREV = "a8e1c7f4b561e1d77948e5d1d1ad58855bade183"

S = "${WORKDIR}/git"

DEPENDS = "zlib fuse android-tools"
inherit pkgconfig

do_configure () {
 true
}

do_compile () {
 oe_runmake
}

do_install () {
 install -d ${D}/usr/bin
 install -m 755 adbfs ${D}/usr/bin
}

HOMEPAGE = "https://github.com/spion/adbfs-rootless"
SUMMARY = "Mount Android phones on Linux with adb. No root required."
