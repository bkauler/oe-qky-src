
# 170505 remove 'clucene-core', add 'unzip', remove 'gstreamer1.0-plugins-base'...
# 171120 add 'libepoxy'
DEPENDS = " \
    python3-lxml-native \
    ccache-native \
    archive-zip-native \
    gperf-native \
    bison-native \
    zip-native \
    ${@['hicolor-icon-theme', '']['${BPN}' == 'hicolor-icon-theme']} gtk-icon-utils-native \
    ${BPN}-native \
    \
    curl \
    icu \
    expat \
    poppler \
    harfbuzz \
    openldap \
    nss \
    zlib \
    jpeg \
    neon \
    libpng \
    apr \
    serf \
    libatomic-ops \
    lcms \
    harfbuzz \
    cppunit \
    glew \
    openssl \
    cups \
    \
    mdds \
    glm \
    redland \
    libabw \
    libwps \
    libwpg \
    libwpd \
    libcdr \
    librevenge \
    libcmis \
    libfreehand \
    libe-book \
    libmwaw \
    libetonyek \
    libvisio \
    libmspub \
    libpagemaker \
    libodfgen \
    libgltf \
    libexttextcat \
    vigra \
    hunspell \
    mythes \
    hyphen \
    graphite2 \
    liblangtag \
    unzip \
    libepoxy \
"

# 170505 remove '--with-system-clucene', add '--disable-gtk3', '--disable-gstreamer-1-0'
# 171120 add '--with-system-epoxy'
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
    --without-java \
    --with-lang=ALL \
    \
    --disable-collada \
    --disable-coinmp \
    --enable-python=system \
    --with-tls=nss \
    --without-galleries \
    \
    --with-system-poppler \
    --with-system-openldap \
    --with-system-zlib \
    --with-system-jpeg \
    --with-system-neon \
    --with-system-libpng \
    --with-system-nss \
    --with-system-apr \
    --with-system-serf \
    --with-system-libatomic_ops \
    --with-system-lcms2 \
    --with-system-libxml \
    --with-system-icu \
    --with-system-expat \
    --with-system-curl \
    --with-system-harfbuzz \
    --with-system-glew \
    --with-system-openssl \
    \
    --with-system-cppunit \
    --with-system-glm \
    --with-system-mdds \
    --with-system-redland \
    --with-system-libabw \
    --with-system-libwps \
    --with-system-libwpg \
    --with-system-libwpd \
    --with-system-libcdr \
    --with-system-libcmis \
    --with-system-libebook \
    --with-system-libmwaw \
    --with-system-libetonyek \
    --with-system-libvisio \
    --with-system-libmspub \
    --with-system-libpagemaker \
    --with-system-libodfgen \
    --with-system-libgltf \
    --with-system-libexttextcat \
    --with-system-vigra \
    --with-system-hunspell \
    --with-system-mythes \
    --with-system-altlinuxhyph \
    --with-system-graphite \
    --with-system-liblangtag \
    --disable-gtk3 \
    --disable-gstreamer-1-0 \
    --with-system-epoxy \
"

# this is a hack, coz still learning....
# build of 'postgresql' failed, so do not want as a dep...
PACKAGECONFIG[postgresql] = " --disable-postgresql-sdbc, --disable-postgresql-sdbc, "

# 170506 really really awful hack, workaround broken icon-themes build....
do_configure() {
    olddir=`pwd`
    cd ${S}
    aclocal --system-acdir=${STAGING_DATADIR_NATIVE}/aclocal/ -I ${S}/m4
    gnu-configize
    autoconf
    cd $olddir
    export PYTHON_CFLAGS=-I${STAGING_INCDIR}/${PYTHON_DIR}
    export PYTHON_LIBS="-L${STAGING_LIBDIR} -lpython${PYTHON_BASEVERSION}"

    # 170506 bad hack, remove all other icon themes...
    PTNit1='s%with_theme="[^"]*%with_theme="tango%'
    sed -i -e "$PTNit1" ${B}/configure.ac
    [ -f ${B}/configure ] && sed -i -e "$PTNit1" ${B}/configure
    mkdir -p ${B}/icon-themes/breezegalaxyhicontrastoxygensifrtango
    mkdir -p ${B}/icon-themes/export
    
    oe_runconf

    mkdir -p ${B}/workdir/Executable

    # icu binaries are expected in our build tree
    mkdir -p ${B}/workdir/UnpackedTarball/icu/source/
    cd ${B}/workdir/UnpackedTarball/icu/source/
    icu_bindir=`find ${STAGING_DATADIR_NATIVE}/icu -name bin`
    ln -sf $icu_bindir

    # link to native saxparser.rdb - cross version of that file is useless
    sed -i 's:%STAGING_LIBDIR_NATIVE%:${STAGING_LIBDIR_NATIVE}:g' ${S}/solenv/gbuild/TargetLocations.mk

    # ensure gengal loads native libraries
    sed -i 's:%STAGING_LIBDIR_NATIVE%:${STAGING_LIBDIR_NATIVE}:g' ${S}/solenv/gbuild/Gallery.mk
    
}

# 170506 really bad hack continues....
do_install() {
    
    # 170506 install fails coz this does not exist. hack, create it...
    touch ${B}/instdir/share/config/images_WITH_WEBDAV=neon.zip
    cp -a -f ${B}/instdir/share/config/images_tango.zip ${B}/instdir/share/config/images_\\tango.zip
    
    make DESTDIR=${D} distro-pack-install

    # unoconv
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/git/unoconv/unoconv ${D}/${bindir}
}
