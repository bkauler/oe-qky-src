# Recipe created by recipetool

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"

SRC_URI = "https://github.com/seccomp/libseccomp/releases/download/v${PV}/libseccomp-${PV}.tar.gz \
      file://28-parisc_support.patch \
      file://add-log-action.patch"
SRC_URI[md5sum] = "e6f3e84921ef9c2e9188681963f0943f"
SRC_URI[sha256sum] = "ff5bdd2168790f1979e24eaa498f8606c2f2d96f08a8dc4006a2e88affa4562b"


inherit autotools-brokensep pkgconfig

#--enable-python requires 'cython'
EXTRA_OECONF = "--disable-static --disable-python"

SUMMARY = "interface to seccomp filtering mechanism"
HOMEPAGE = "https://github.com/seccomp/libseccomp"
