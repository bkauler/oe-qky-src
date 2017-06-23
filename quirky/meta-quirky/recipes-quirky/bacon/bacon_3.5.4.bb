# Recipe created by recipetool
# recipetool create -o bacon_3.5.4.bb http://www.basic-converter.org/stable/bacon-3.5.4.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://doc-pak/copyright;md5=7aa9a8809e4151b9907173f18f2f815e"

SRC_URI = "http://www.basic-converter.org/stable/bacon-${PV}.tar.gz"
SRC_URI[md5sum] = "dc2ef768b547fe559c2577ba5bbfa89d"
SRC_URI[sha256sum] = "7b1c72fd46daaa43d19e1bfac2f9bcd9decc5b8443d8f5640e903bfc35e122b9"

DEPENDS = "bash gtk+"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
# BK 20170607 broken, do-compile needs to run ./bacon.sh in source...
inherit autotools-brokensep

do_compile() {
    mkdir -p build
    # -n convert to C only, -a rebuild libbacon.a, -p preserve temporary files,
    # -y automatically delete temporary files ...
    #bash bacon.sh -y -a -d build bacon.bac
    #...this works for x86_64 target. but for armv7 target may need to do this...
    bash bacon.sh -y -n -p -a -d build bacon.bac
    cd build
    ${CC} -fPIC -O2 -c bacon.bac.c
    for aFILE in bacon.binary.c bacon.chop.c bacon.chr.c bacon.cmdline.c bacon.concat.c bacon.count.c bacon.curdir.c bacon.datename.c bacon.dec.c bacon.dirname.c bacon.epoch.c bacon.error.c bacon.exec.c bacon.extract.c bacon.filelen.c bacon.filetime.c bacon.filetype.c bacon.fill.c bacon.flatten.c bacon.getenviron.c bacon.getkey.c bacon.getpeer.c bacon.getxy.c bacon.hex.c bacon.host.c bacon.hostname.c bacon.inbetween.c bacon.insert.c bacon.instr.c bacon.instrrev.c bacon.lcase.c bacon.left.c bacon.load.c bacon.makedir.c bacon.malloc.c bacon.memcheck.c bacon.mid.c bacon.minmax.c bacon.os.c bacon.peek.c bacon.regex.c bacon.remove.c bacon.replace.c bacon.reverse.c bacon.right.c bacon.screen.c bacon.search.c bacon.sort.c bacon.spc.c bacon.str.c bacon.tab.c bacon.tally.c bacon.time.c bacon.timer.c bacon.token.c bacon.ucase.c bacon.version.c bacon.wait.c
    do
     ${CC} -fPIC -O2 -c ${aFILE}
    done
    ${AR} -r libbacon.a  bacon.binary.o bacon.chop.o bacon.chr.o bacon.cmdline.o bacon.concat.o bacon.count.o bacon.curdir.o bacon.datename.o bacon.dec.o bacon.dirname.o bacon.epoch.o bacon.error.o bacon.exec.o bacon.extract.o bacon.filelen.o bacon.filetime.o bacon.filetype.o bacon.fill.o bacon.flatten.o bacon.getenviron.o bacon.getkey.o bacon.getpeer.o bacon.getxy.o bacon.hex.o bacon.host.o bacon.hostname.o bacon.inbetween.o bacon.insert.o bacon.instr.o bacon.instrrev.o bacon.lcase.o bacon.left.o bacon.load.o bacon.makedir.o bacon.malloc.o bacon.memcheck.o bacon.mid.o bacon.minmax.o bacon.os.o bacon.peek.o bacon.regex.o bacon.remove.o bacon.replace.o bacon.reverse.o bacon.right.o bacon.screen.o bacon.search.o bacon.sort.o bacon.spc.o bacon.str.o bacon.tab.o bacon.tally.o bacon.time.o bacon.timer.o bacon.token.o bacon.ucase.o bacon.version.o bacon.wait.o
    ${CC} -o bacon bacon.bac.o -L. -lbacon -lm
    cd ..
    #also compile bacongui, note, only needs gtk libs at runtime...
    bash bacon.sh -y -n -p -d build bacongui.bac
    cd build
    ${CC} -fPIC -O2 -c bacongui.bac.c
    ${CC} -o bacongui bacongui.bac.o -lbacon -lm  -L. -ldl
    cd ..
}

do_install() {
    install -d ${D}/usr/bin
    install -m755 build/bacon ${D}/usr/bin
    install -m755 bacon.sh ${D}/usr/bin
    install -d ${D}/usr/lib
    install -m755 build/libbacon.a ${D}/usr/lib
    install -d ${D}/usr/share/BaCon
    install -m644 bacon.bac ${D}/usr/share/BaCon
    #and for bacongui...
    install -m755 build/bacongui ${D}/usr/bin
    install -d ${D}/usr/share/applications
    install -d ${D}/usr/share/pixmaps
    install -m644 bacongui.desktop ${D}/usr/share/applications
    install -m644 icons/BaCon24.png ${D}/usr/share/pixmaps/BaCon.png
    #see note below...
    install -m755 bacon.sh ${TMPDIR}
}

# usr/share/BaCon is installed but not packaged. this fixes...
# note, $datadir defined in meta/conf/bitbake.conf, but can use actual path...
FILES_${PN} += "/usr/share/BaCon"

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--with-bash --enable-gui"
# ...do_configure() will run, but we aren't using Makefile.

# do_install installs ok, but do not get the usr/bin files in sysroot-destdir,
# to be available for execution by pup-tools when it wants to compile bscon src.
# ref: https://stackoverflow.com/questions/35354802/how-to-create-do-populate-sysroot-append-task-in-yocto
sysroot_stage_all_append () {                                     
    sysroot_stage_dir ${D}/usr/bin ${SYSROOT_DESTDIR}/usr/bin
}
# ...installs tmp-glibc/work/*/bacon/3.5.4-r0/sysroot-destdir/usr/bin/bacon.sh,
# which should now be visible to pup-tools do_compile, but do not know how to specify
# its path. so, using $TMPDIR which is global, see above.

HOMEPAGE = "http://basic-converter.org/"
SUMMARY = "A BASIC compiler with highlevel GUI."
