
# BK 170512 firefox and seamonkey crash frequently. one reason is that use system
# sqlite, which was not configured correctly. need this:
BUILD_CFLAGS += "-DSQLITE_SECURE_DELETE -DSQLITE_ENABLE_UNLOCK_NOTIFY -DSQLITE_ENABLE_DBSTAT_VTAB"
TARGET_CFLAGS += "-DSQLITE_SECURE_DELETE -DSQLITE_ENABLE_UNLOCK_NOTIFY -DSQLITE_ENABLE_DBSTAT_VTAB"

