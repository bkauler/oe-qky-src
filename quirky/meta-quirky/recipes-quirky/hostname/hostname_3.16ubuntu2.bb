# Recipe created by recipetool
# recipetool create -o hostname_3.16ubuntu2.bb http://archive.ubuntu.com/ubuntu/pool/main/h/hostname/hostname_3.16ubuntu2.tar.gz

LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=86dc5e6760b0845ece4d5be3a9d397d9"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/main/h/hostname/hostname_${PV}.tar.gz"
SRC_URI[md5sum] = "623a7180de8cccfae9777accf0b34563"
SRC_URI[sha256sum] = "e0a38fa03b66abd428e119e5af2cccb78a0462cdb58e2e540e66d964e2719195"

# NOTE: this is a Makefile-only piece of software.

do_configure () {
    true
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install BASEDIR=${D}
}


HOMEPAGE = ""
SUMMARY = ""
