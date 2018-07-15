# Recipe created by recipetool
# recipetool create -o zstd_1.3.5.bb https://github.com/facebook/zstd/archive/v1.3.5.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=c7f0b161edbe52f5f345a3d1311d0b32"

SRC_URI = "https://github.com/facebook/zstd/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "d2fc97be4852d666f086282053c02319"
SRC_URI[sha256sum] = "d6e1559e4cdb7c4226767d4ddc990bff5f9aab77085ff0d0490c828b025e2eea"

S = "${WORKDIR}/zstd-${PV}/build/cmake"
#B = "${S}/build/cmake"

inherit cmake

EXTRA_OECMAKE_append = " -DTHREADS_PTHREAD_ARG=0"

do_install() {
    oe_runmake DESTDIR=${D} install
}

SUMMARY = "Zstandard - Fast real-time compression algorithm"
HOMEPAGE = "http://www.zstd.net"

BBCLASSEXTEND = "native"
