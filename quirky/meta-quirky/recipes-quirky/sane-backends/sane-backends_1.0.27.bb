# Recipe created by recipetool
# recipetool create -o sane-backends_1.0.25.bb http://fossies.org/linux/misc/sane-backends-1.0.25.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

# SRC_URI = "http://fossies.org/linux/misc/sane-backends-${PV}.tar.gz"
SRC_URI = "https://alioth.debian.org/frs/download.php/file/4224/sane-backends-${PV}.tar.gz"
SRC_URI[md5sum] = "b10a08785f92a4c07ad961f4d843c934"
SRC_URI[sha256sum] = "293747bf37275c424ebb2c833f8588601a60b2f9653945d5a3194875355e36c9"

DEPENDS = "libusb1 tiff libjpeg-turbo cups gphoto2 v4l-utils libpng12"

inherit pkgconfig autotools gettext

# removed, unknown: --disable-latex --disable-translations 
EXTRA_OECONF = "--with-usb --without-systemd --with-gphoto2 --with-group=scanner --disable-avahi --with-v4l"


HOMEPAGE = "http://www.sane-project.org"
SUMMARY = "The Scanner Access Now Easy backends"
