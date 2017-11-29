
# 171128 fix printing. see also 'cups', 'cups-filters', 'gtk+'

PR = "r1"

DEPENDS = "fontconfig zlib cairo lcms pango gtk+ cups curl zlib qpdf"

EXTRA_OECONF = "\
    --enable-xpdf-headers \
    --disable-gtk-test \
    --enable-zlib \
    --enable-utils \
    --enable-libcurl \
"
