
# 170505 remove 'clucene-core-native', add 'unzip-native', 'neon-native'...
DEPENDS = " \
    python3-lxml-native \
    ccache-native \
    archive-zip-native \
    gperf-native \
    bison-native \
    zip-native \
    curl-native \
    gconf-native \
    libpng-native \
    jpeg-native \
    libxml2-native \
    harfbuzz-native \
    boost-native \
    icu-native \
    expat-native \
    lcms-native \
    nss-native \
    cppunit-native \
    libabw-native \
    libcdr-native \
    libe-book-native \
    libfreehand-native \
    hunspell-native \
    mythes-native \
    libcmis-native \
    mdds-native \
    libpagemaker-native \
    glm-native \
    libetonyek-native \
    vigra-native \
    libvisio-native \
    libexttextcat-native \
    hyphen-native \
    unzip-native \
    neon-native \
"

# remove '--with-system-clucene', add '--with-system-neon', '--disable-gtk3'...
EXTRA_OECONF = " \
    --without-doxygen \
    --enable-release-build \
    --enable-verbose \
    --with-parallelism=${@oe.utils.cpu_count()} \
    \
    --with-system-librevenge \
    --with-system-libabw \
    --with-system-libcdr \
    --with-system-libebook \
    --with-system-libfreehand \
    --enable-verbose \
    \
    --enable-python=system \
    --without-x \
    --without-java \
    \
    --with-system-curl \
    --with-system-libpng \
    --with-system-jpeg \
    --with-system-libxml \
    --with-system-harfbuzz \
    --with-system-boost \
    --with-system-icu \
    --with-system-expat \
    --with-system-lcms2 \
    --with-system-nss \
    --with-system-cppunit \
    --with-system-libabw \
    --with-system-libcdr \
    --with-system-libebook \
    --with-system-libfreehand \
    --with-system-hunspell \
    --with-system-mythes \
    --with-system-libcmis \
    --with-system-mdds \
    --with-system-libpagemaker \
    --with-system-glm \
    --with-system-libetonyek \
    --with-system-vigra \
    --with-system-libvisio \
    --with-system-libexttextcat \
    --with-system-altlinuxhyph \
    --with-system-neon \
    \
    --without-boost-date-time \
    --without-boost-iostreams \
    --without-boost-system \
    --disable-postgresql-sdbc \
    --disable-lotuswordpro \
    --disable-firebird-sdbc \
    --disable-liblangtag \
    --disable-openssl \
    --disable-gltf \
    --disable-collada \
    --disable-scripting-beanshell \
    --disable-scripting-javascript \
    --disable-graphite \
    --disable-pdfimport \
    --disable-orcus \
    --disable-coinmp \
    --disable-gtk3 \
"
