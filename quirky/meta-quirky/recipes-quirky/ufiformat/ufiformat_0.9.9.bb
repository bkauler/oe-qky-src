LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "https://launchpad.net/ubuntu/+archive/primary/+files/ufiformat_${PV}.orig.tar.gz"
SRC_URI[md5sum] = "18e41a189b81b1599a38ce8640698b7f"
SRC_URI[sha256sum] = "1d191790c2fbeb38a4acbb66f929bf987b675904cba33a0ccfb43f8db63086e5"

DEPENDS = "e2fsprogs dosfstools libusb1 libusb-compat"

inherit autotools pkgconfig

HOMEPAGE = "http://www.geocities.jp/tedi_world/format_usbfdd_e.html"
SUMMARY = "Utility to format disk in USB floppy drive"
