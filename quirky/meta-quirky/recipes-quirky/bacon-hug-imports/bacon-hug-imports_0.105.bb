# Recipe created by recipetool
#  recipetool create -o bacon-hug-imports_0.104.bb http://www.basic-converter.org/hug_imports.bac
#20180417 hug 0.105, bacon 3.7.2

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://www.basic-converter.org/hug_imports.bac"
#SRC_URI[md5sum] = "2c7c9fef5163af45463307d6f7c30b97"
#SRC_URI[sha256sum] = "36a4c183671821c987e46ddcbdfd70e30396431759b1fe6cd91e192a596d70ea"
SRC_URI[md5sum] = ""
SRC_URI[sha256sum] = ""
# this will prevent lack of checksum from throwing an error...
BB_STRICT_CHECKSUM = "0"

# BK note, see recipe pup-tools*.bb

S = "${WORKDIR}"
do_unpack() {
    cp -f ${DL_DIR}/hug_imports.bac ${S}/
}

do_configure() {
    true
}

do_compile() {
    true
}

do_install () {
    install -d ${D}/usr/share/BaCon
    sed -i -e 's%libhug\.so%/usr/lib/hug.so%' hug_imports.bac
    install -m755 hug_imports.bac ${D}/usr/share/BaCon
}

FILES_${PN} = "/usr/share/BaCon"

HOMEPAGE = "http://basic-converter.org/"
SUMMARY = "High level GUI for BaCon"
