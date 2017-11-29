
# 171128 fix printing.

PR = "r1"

# original:
#DEPENDS = "gnutls libpng jpeg dbus dbus-glib zlib libusb"

DEPENDS = "gnutls libpng jpeg tiff zlib libusb openssl"

# most important: "--disable-libusb" to suit my linux kernel.
EXTRA_OECONF = " \
               --disable-dbus --disable-pam --enable-libpaper --disable-dnssd \
               --disable-launchd  --disable-gssapi --disable-libusb \
               --with-logdir=/var/cups/log --without-python --without-php \
               --without-java --with-perl --with-system-groups=lpadmin \
               --with-cups-group=lp --with-cups-user=spot --disable-systemd \
               --disable-avahi \
               --enable-gnutls \
               --disable-relro \
               DSOFLAGS='${LDFLAGS}' \
               "
