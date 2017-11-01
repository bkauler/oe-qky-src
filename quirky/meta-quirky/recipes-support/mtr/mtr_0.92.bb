LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "ftp://ftp.bitwizard.nl/mtr/mtr-${PV}.tar.gz"
SRC_URI[md5sum] = "3b3788f71641eb3eaba517ac2138e76d"
SRC_URI[sha256sum] = "f2979db9e2f41aa8e6574e7771767c9afe111d9213814eb47f5e1e71876e4382"

DEPENDS = "libcap gtk+ ncurses"

inherit pkgconfig autotools

EXTRA_OECONF = "--disable-bash-completion"

HOMEPAGE = "https://www.bitwizard.nl/mtr/"
SUMMARY = "mtr combines the functionality of the traceroute and ping programs in a single network diagnostic tool"
