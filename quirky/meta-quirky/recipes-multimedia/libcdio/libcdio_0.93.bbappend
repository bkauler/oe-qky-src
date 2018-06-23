
# BK libcdio and libcddb seem to have circular dependencies. follow LFS and set libcddb
# as a dep of libcdio...

DEPENDS += "libcddb"

PACKAGECONFIG_append = " cddb"
PACKAGECONFIG[cddb] = "--enable-cddb,--disable-cddb,libcddb"
