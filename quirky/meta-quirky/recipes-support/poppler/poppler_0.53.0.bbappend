
# 171128 r1: fix printing. see also 'cups', 'cups-filters', 'gtk+'
# 181209 r2: recompile, as qpdf version bumped to 8.2.1

PR = "r2"

DEPENDS = "fontconfig zlib cairo lcms pango gtk+ cups curl zlib qpdf"

EXTRA_OECONF = "\
    --enable-xpdf-headers \
    --disable-gtk-test \
    --enable-zlib \
    --enable-utils \
    --enable-libcurl \
"
