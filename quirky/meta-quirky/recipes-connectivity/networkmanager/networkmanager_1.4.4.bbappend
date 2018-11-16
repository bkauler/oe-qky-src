#BK 181112
#181113 add libnewt, so have nmtui gui. also add rp-pppoe, ppp

PR = "r1"

DEPENDS = " \
    intltool-native \
    libnl \
    dbus \
    dbus-glib \
    dbus-glib-native \
    libgudev \
    util-linux \
    libndp \
    jansson \
    dhcpcd gnutls readline libidn zlib libunistring \
    nettle gmp libffi libpcre ncurses glib-2.0 \
    libsoup-2.4 \
    libnewt slang popt rp-pppoe ppp \
"

EXTRA_OECONF = " \
    --disable-ifcfg-rh \
    --disable-ifnet \
    --disable-ifcfg-suse \
    --disable-more-warnings \
    --with-iptables=${sbindir}/iptables \
    --with-tests=no \
    --with-nmtui=yes \
    --with-config-dhcp-default=dhcpcd --with-dhcpcd=yes --with-dhcpcd-supports-ipv6=auto \
    --enable-polkit=no \
    -with-valgrind=no --with-nmcli=yes --with-resolvconf=yes \
    --with-selinux=no --with-consolekit=no --with-systemd-logind=no --with-systemd-journal=no --with-wext=yes \
    --enable-concheck --enable-modify-system \
"

PACKAGECONFIG = "concheck gnutls dnsmasq ppp \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', '${BLUEZ}', '', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'wifi', d)} \
"
