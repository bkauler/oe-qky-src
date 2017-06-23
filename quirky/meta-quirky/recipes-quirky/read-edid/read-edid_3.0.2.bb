# Recipe created by recipetool
# recipetool create -o read-edid_3.0.2.bb http://www.polypux.org/projects/read-edid/read-edid-3.0.2.tar.gz

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=292c42e2aedc4af636636bf7af0e2b26"

SRC_URI = "http://www.polypux.org/projects/read-edid/read-edid-${PV}.tar.gz"
SRC_URI[md5sum] = "016546e438bf6c98739ff74061df9854"
SRC_URI[sha256sum] = "c7c6d8440f5b90f98e276829271ccea5b2ff5a3413df8a0f87ec09f834af186f"

inherit cmake

# BK 170615 the "classic" build uses VBE, which requires pkg libx86. if this is disabled,
# still have detection by i2c interface.
EXTRA_OECMAKE = "-DCLASSICBUILD=OFF"

do_install() {
    install -d ${D}/usr/sbin
    install -m755 ${B}/get-edid/get-edid ${D}/usr/sbin
    install -m755 ${B}/parse-edid/parse-edid ${D}/usr/sbin
}

HOMEPAGE = "http://www.polypux.org/projects/read-edid/"
SUMMARY = "Read and parse monitor EDID."
