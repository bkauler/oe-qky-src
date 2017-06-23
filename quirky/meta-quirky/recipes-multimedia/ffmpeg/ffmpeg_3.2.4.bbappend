
DEPENDS += "libcdio libcdio-paranoia"

PACKAGECONFIG_append = " cdio"
PACKAGECONFIG[cdio] = "--enable-libcdio,--disable-libcdio,libcdio"
