# Recipe created by recipetool
# recipetool create -o pup-tools_20170607.bb http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/p/pup-tools-20170607.tar.gz

PR = "r1"

DEPENDS = "bacon bacon-hug bacon-hug-imports gtk+"
inherit gettext pkgconfig

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://readme.txt;md5=9add27eb01e81e0a682a99520030f7ce"

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/alphabetical/p/pup-tools-${PV}.tar.gz"
SRC_URI[md5sum] = "08310e9ecf73f9132cd986fd41220ee9"
SRC_URI[sha256sum] = "dcf10d407efb412f3bc2d98381a17fc0258dba7777d50f52be885b1faef3b038"

do_configure() {
    cp -f ${DL_DIR}/hug_imports.bac ${S}/bacon/
    cp -f ${DL_DIR}/hug.bac ${S}/bacon/
}

do_compile () {
	# note, 'pwd' reported:
	# /mnt/sdb1/oe/oe-quirky/buildPC/tmp-glibc/work/core2-64-oe-linux/pup-tools/20170607-r0/pup-tools-20170607
	cd bacon
	#[ -d temp1 ] && rm -rf temp1
	mkdir -p temp1
	
	#171102 fails at startup, try with inbuilt hug.bac instead of hug.so...
	sed -i -e 's%^REM INCLUDE "/usr/share/BaCon/hug.bac"%INCLUDE "/usr/share/BaCon/hug.bac"%' welcome1stboot.bac
	sed -i -e 's%^INCLUDE "/usr/share/BaCon/hug_imports.bac"%REM INCLUDE "/usr/share/BaCon/hug_imports.bac"%' welcome1stboot.bac
	
	sed -i -e 's%/usr/share/BaCon%.%' welcome1stboot.bac #hug_imports.bac, hug.bac are local.
    # -n convert to C only, -a rebuild libbacon.a, -p preserve temporary files,
    # -y automatically delete temporary files, -x extract gettext strings...
	${TMPDIR}/bacon.sh -y -x -n -p -d temp1 welcome1stboot.bac
	cd temp1
	${CC} -fPIC -c welcome1stboot.bac.c ${CFLAGS}
	${CC} -o welcome1stboot welcome1stboot.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
	${TMPDIR}/bacon.sh -y -n -p -d temp1 debdb2pupdb.bac
	cd temp1
	${CC} -fPIC -c debdb2pupdb.bac.c ${CFLAGS}
	${CC} -o debdb2pupdb debdb2pupdb.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
	${TMPDIR}/bacon.sh -y -n -p -d temp1 find_cat.bac
	cd temp1
	${CC} -fPIC -c find_cat.bac.c ${CFLAGS}
	${CC} -o find_cat find_cat.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
	${TMPDIR}/bacon.sh -y -n -p -d temp1 pngoverlay.bac
	cd temp1
	${CC} -fPIC -c pngoverlay.bac.c ${CFLAGS}
	${CC} -o pngoverlay pngoverlay.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
	sed -i -e 's%/usr/share/BaCon%.%' popup.bac #hug_imports.bac is local.
	${TMPDIR}/bacon.sh -y -n -p -d temp1 popup.bac
	cd temp1
	${CC} -fPIC -c popup.bac.c ${CFLAGS}
	${CC} -o popup popup.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
	
	#171102 fails at startup, try with inbuilt hug.bac instead of hug.so...
	#oh, found needs "ENTRY" inserted...
	sed -i -e 's%^REM INCLUDE "/usr/share/BaCon/hug.bac"%INCLUDE "/usr/share/BaCon/hug.bac",ENTRY%' proxy-setup.bac
	sed -i -e 's%^INCLUDE "/usr/share/BaCon/hug_imports.bac"%REM INCLUDE "/usr/share/BaCon/hug_imports.bac"%' proxy-setup.bac
	
	sed -i -e 's%/usr/share/BaCon%.%' proxy-setup.bac #hug_imports.bac, hug.bac are local.
	${TMPDIR}/bacon.sh -x -y -n -p -d temp1 proxy-setup.bac
	cd temp1
	${CC} -fPIC -c proxy-setup.bac.c ${CFLAGS}
	${CC} -o proxy-setup proxy-setup.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
	${TMPDIR}/bacon.sh -y -n -p -d temp1 pup_event_frontend_d.bac
	cd temp1
	${CC} -fPIC -c pup_event_frontend_d.bac.c ${CFLAGS}
	${CC} -o pup_event_frontend_d pup_event_frontend_d.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
	sed -i -e "s%'CONST IN_MODIFY=2%CONST IN_MODIFY=2%" pup_event_ipc.bac #170608
	${TMPDIR}/bacon.sh -y -n -p -d temp1 pup_event_ipc.bac
	cd temp1
	${CC} -fPIC -c pup_event_ipc.bac.c ${CFLAGS}
	${CC} -o pup_event_ipc pup_event_ipc.bac.o -L. -lbacon -lm  -ldl ${LDFLAGS}
	cd ..
    cd ..
    
	cd gcc
	for aFILE in printcols truncate vercmp
	do
	 ${CC} -o ${aFILE} ${aFILE}.c ${CFLAGS} ${LDFLAGS}
	done
	${CC} -lX11 getcurpos.c -o getcurpos ${CFLAGS} ${LDFLAGS}
	cd ..
}

do_install () {
    install -d ${D}/bin
    install -m755 gcc/vercmp ${D}/bin
    install -d ${D}/usr/bin
    install -m755 gcc/truncate ${D}/usr/bin
    install -d ${D}/usr/sbin
    install -m755 gcc/getcurpos ${D}/usr/sbin
    install -m755 gcc/printcols ${D}/usr/sbin
    install -m755 bacon/temp1/pngoverlay ${D}/usr/sbin
    install -m755 bacon/temp1/popup ${D}/usr/sbin
    install -m755 bacon/temp1/welcome1stboot ${D}/usr/sbin
    install -d ${D}/usr/local/petget
    install -m755 bacon/temp1/debdb2pupdb ${D}/usr/local/petget
    install -m755 bacon/temp1/find_cat ${D}/usr/local/petget
    install -d ${D}/usr/local/pup_event
    install -m755 bacon/temp1/pup_event_frontend_d ${D}/usr/local/pup_event
    install -m755 bacon/temp1/pup_event_ipc ${D}/usr/local/pup_event
    install -d ${D}/usr/local/simple_network_setup
    install -m755 bacon/temp1/proxy-setup ${D}/usr/local/simple_network_setup
}

FILES_${PN} += "/usr/local/petget /usr/local/pup_event /usr/local/simple_network_setup"

HOMEPAGE = "http://barryk.org/news/?viewDetailed=00136"
SUMMARY = "Core utilities used in Puppy and derivatives."
