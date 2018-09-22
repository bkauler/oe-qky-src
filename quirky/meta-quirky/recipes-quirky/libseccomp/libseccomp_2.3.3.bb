# Recipe created by recipetool
# recipetool create -o libseccomp_2.3.3.bb https://github.com/seccomp/libseccomp/releases/download/v2.3.3/libseccomp-2.3.3.tar.gz

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"

SRC_URI = "https://github.com/seccomp/libseccomp/releases/download/v${PV}/libseccomp-${PV}.tar.gz"
SRC_URI[md5sum] = "e6b4e463857fe05c09dc56ec3bcaef84"
SRC_URI[sha256sum] = "7fc28f4294cc72e61c529bedf97e705c3acf9c479a8f1a3028d4cd2ca9f3b155"

inherit autotools-brokensep pkgconfig

#--enable-python requires 'cython'
EXTRA_OECONF = "--disable-static --disable-python"

SUMMARY = "interface to seccomp filtering mechanism"
HOMEPAGE = "https://github.com/seccomp/libseccomp"

