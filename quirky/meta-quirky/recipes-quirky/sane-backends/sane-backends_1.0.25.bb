# Recipe created by recipetool
# recipetool create -o sane-backends_1.0.25.bb http://fossies.org/linux/misc/sane-backends-1.0.25.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "http://fossies.org/linux/misc/sane-backends-${PV}.tar.gz"
SRC_URI[md5sum] = "f9ed5405b3c12f07c6ca51ee60225fe7"
SRC_URI[sha256sum] = "a4d7ba8d62b2dea702ce76be85699940992daf3f44823ddc128812da33dc6e2c"

DEPENDS = "libusb1 tiff libjpeg-turbo cups gphoto2"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--enable-libusb_1_0 --without-systemd --with-gphoto2 --with-group=scanner --disable-latex --disable-translations --disable-avahi"


HOMEPAGE = "http://www.sane-project.org"
SUMMARY = "The Scanner Access Now Easy backends"
