# 20181118

PACKAGECONFIG ??= "mbim qmi \
    ${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} \
"
