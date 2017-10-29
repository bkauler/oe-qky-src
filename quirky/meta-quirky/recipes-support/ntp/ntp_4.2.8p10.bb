
LICENSE = "MIT & LGPLv3"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=e877a1d567a6a58996d2b66e3e387003 \
                    file://libjsmn/LICENSE;md5=5adc94605a1f7a797a9a834adbe335e3 \
                    file://sntp/COPYRIGHT;md5=e877a1d567a6a58996d2b66e3e387003"

SRC_URI = "https://www.eecis.udel.edu/~ntp/ntp_spool/ntp4/ntp-4.2/ntp-${PV}.tar.gz"
SRC_URI[md5sum] = "745384ed0dedb3f66b33fe84d66466f9"
SRC_URI[sha256sum] = "ddd2366e64219b9efa0f7438e06800d0db394ac5c88e13c17b70d0dcdf99b99f"

# openssl has libcrypto...
DEPENDS = "bison-native libevent readline libcap openssl"

inherit perlnative autotools pkgconfig

# --with-yielding_select=yes is required when cross-compiling.
EXTRA_OECONF = "--with-yielding_select=yes --enable-ipv6 --with-crypto --enable-linuxcaps --with-lineeditlibs=readline"

# only want this one executable...
do_install () {
    mkdir -p ${D}/usr/sbin
    install -m 755 ${B}/ntpdate/ntpdate ${D}/usr/sbin
}

HOMEPAGE = "http://www.ntp.org/"
SUMMARY = "NTP is a protocol designed to synchronize the clocks of computers over a network"
