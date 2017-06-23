# Recipe created by recipetool
# recipetool create -o bacon-hug_0.104.bb http://www.basic-converter.org/hug.bac

DEPENDS = "bash bacon gtk+"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://www.basic-converter.org/hug.bac"
#SRC_URI[md5sum] = "8a1855b62c16656afba054a8f2dab8da"
#SRC_URI[sha256sum] = "889544b8c9cbd1d83abf487f49a7c916c5a99333ab61db302f62b1ac6ae32349"
SRC_URI[md5sum] = ""
SRC_URI[sha256sum] = ""
# this will prevent lack of checksum from throwing an error...
BB_STRICT_CHECKSUM = "0"

# hug.bac is not a tarball, so set S (path to source) where hug.bac is located...
S = "${WORKDIR}"
# also, do my own unpack...
do_unpack () {
    cp -f ${DL_DIR}/hug.bac ${S}/
}

do_configure () {
    true
}

do_compile () {
   	mkdir -p temp1
    # -n convert to C only, -a rebuild libbacon.a, -p preserve temporary files,
    # -y automatically delete temporary files, -x extract gettext strings...
	${TMPDIR}/bacon.sh -y -n -p -d temp1 hug.bac
	cd temp1
    ${CC} -fPIC -c hug.bac.c
    ${CC} -o hug.so hug.bac.o -lbacon -lm -shared -rdynamic -ldl
    cd ..
}

do_install () {
    install -d ${D}/usr/lib
    install -m755 temp1/hug.so ${D}/usr/lib
}

FILES_${PN} += '/usr/lib/hug.so'

HOMEPAGE = "http://basic-converter.org/"
SUMMARY = "High level GUI for BaCon"
