
# ref: meta-oe/recipes-support/pidgin
# 170505 remove 'avahi'...
PACKAGECONFIG ??= "gnutls consoleui dbus idn nss \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11 gtk startup-notification', '', d)} \
"
