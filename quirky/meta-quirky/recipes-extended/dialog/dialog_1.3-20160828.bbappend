
# 20180718
# the official dialog recipe only uses ascii curses, want wide-char support...

PR = "r1"

EXTRA_OECONF = "--with-ncursesw \
                --enable-nls \
                --enable-widec \
                --disable-rpath-hack"
