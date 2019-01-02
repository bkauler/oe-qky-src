# Recipe created by recipetool
# recipetool create -o gettext0-static_0.10.40.bb https://ftp.gnu.org/gnu/gettext/gettext-0.10.40.tar.gz

LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3 \
                    file://intl/COPYING.LIB-2.1;md5=d8045f3b8f929c1cb29a1e3fd737b499 \
                    file://intl/COPYING.LIB-2;md5=f30a9716ef3762e3467a2f62bf790f0a"

SRC_URI = "https://ftp.gnu.org/gnu/gettext/gettext-${PV}.tar.gz"
SRC_URI[md5sum] = "6a17767b47ffb45b4866cec9fb0a39b0"
SRC_URI[sha256sum] = "098560fc208bbcb4aaf17eaa1ba25ae3b547273f72776766d7b1a9bcaf50ea14"

S = "${WORKDIR}/gettext-${PV}"

DEPENDS = "bison-native"

inherit gettext autotools-brokensep

CFLAGS += " -static"
LDFLAGS += " -static"

EXTRA_OECONF = "--disable-shared"

#try fix compile error...
do_compile_prepend() {
 #this is black magic, dunno why this fixes it...
 sed -i -e 's%fmt, __VA_ARGS__%fmt, ## __VA_ARGS__%' ${S}/src/po-lex.h
 #avoid function redefinitions...
 sed -i -e 's%^# if __GLIBC__ < 2%# if XXXZZZEEE%' ${S}/lib/getline.h
 #compiling po files is broken...
 echo -e 'all:\n\ninstall:\n\nuninstall:\n\nclean::\n\nupdate-po:\n\nMakefile:\n\n' > ${B}/po/Makefile
 #compiling m4 is broken...
 echo -e 'all:\n\ninstall:\n\nuninstall:\n\nclean::\n\nupdate-po:\n\nMakefile:\n\ndistdir:\n\nall-am:\n\ninstall-am:\n\n' > ${B}/m4/Makefile
 #compiling tests is broken...
 echo -e 'all:\n\ninstall:\n\nuninstall:\n\nclean::\n\nupdate-po:\n\nMakefile:\n\ndistdir:\n\nall-am:\n\ninstall-am:\n\n' > ${B}/tests/Makefile
 #installing doc is broken...
 echo -e 'all:\n\ninstall:\n\nuninstall:\n\nclean::\n\nupdate-po:\n\nMakefile:\n\ndistdir:\n\nall-am:\n\ninstall-am:\n\n' > ${B}/doc/Makefile
 ##final link insists on creating dynamically-linked binaries... hack...
 #sed -i -e 's% --mode=link % --mode=link -rpath %' ${B}/src/Makefile
}

do_compile_append() {
 cd ${S}/src
 #../x86_64-oe-linux-musl-libtool  --tag=CC   --mode=link x86_64-oe-linux-musl-gcc  -m64 -march=nocona -mtune=nocona -mno-sse3 -mfpmath=sse --sysroot=/mnt/sdb1/downloads/input497/oe-quirky/buildPC/tmp-musl/work/nocona-64-oe-linux-musl/gettext0-static/0.10.40-r0/recipe-sysroot  -O2 -pipe -g -feliminate-unused-debug-types -fdebug-prefix-map=/mnt/sdb1/downloads/input497/oe-quirky/buildPC/tmp-musl/work/nocona-64-oe-linux-musl/gettext0-static/0.10.40-r0=/usr/src/debug/gettext0-static/0.10.40-r0 -fdebug-prefix-map=/mnt/sdb1/downloads/input497/oe-quirky/buildPC/tmp-musl/work/nocona-64-oe-linux-musl/gettext0-static/0.10.40-r0/recipe-sysroot-native= -fdebug-prefix-map=/mnt/sdb1/downloads/input497/oe-quirky/buildPC/tmp-musl/work/nocona-64-oe-linux-musl/gettext0-static/0.10.40-r0/recipe-sysroot=   -static  -Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed  -static -o gettext gettext.o ../lib/libnlsut.a
 aOBJ=gettext
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} ${aOBJ}.o ../lib/libnlsut.a
 aOBJ=ngettext
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} ${aOBJ}.o ../lib/libnlsut.a
 aOBJ=msgunfmt
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} message.o msgunfmt.o str-list.o write-po.o ../lib/libnlsut.a
 aOBJ=msgcmp
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} message.o msgcmp.o open-po.o po-gram-gen.o po-hash-gen.o po-lex.o po.o str-list.o dir-list.o ../lib/libnlsut.a
 aOBJ=msgfmt
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} msgfmt.o open-po.o po-gram-gen.o po-hash-gen.o po-lex.o po.o str-list.o message.o dir-list.o ../lib/libnlsut.a
 aOBJ=msgmerge
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} message.o msgmerge.o open-po.o po-gram-gen.o po-hash-gen.o po-lex.o po.o str-list.o dir-list.o write-po.o ../lib/libnlsut.a
 aOBJ=xgettext
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} message.o open-po.o po-gram-gen.o po-hash-gen.o po-lex.o po.o str-list.o xget-lex.o xgettext.o dir-list.o write-po.o ../lib/libnlsut.a
 aOBJ=msgcomm
 mv -f ${aOBJ} ${aOBJ}.shared
 ${CC} ${CFLAGS} ${LDFLAGS} -o ${aOBJ} msgcomm.o message.o po-gram-gen.o po-hash-gen.o po-lex.o open-po.o po.o str-list.o dir-list.o write-po.o ../lib/libnlsut.a
 cd ..
}

FILES_${PN} += "${libdir}/*"
FILES_${PN}-doc += "/usr/doc/*"
FILES_${PN} += "${datadir}/gettext"

HOMEPAGE = "https://www.gnu.org/software/gettext/"
SUMMARY = "Translate English to another language"
