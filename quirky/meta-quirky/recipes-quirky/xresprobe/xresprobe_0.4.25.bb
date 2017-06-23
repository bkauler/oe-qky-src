# Recipe created by recipetool
# recipetool create -o xresprobe_0.4.25.bb http://archive.ubuntu.com/ubuntu/pool/universe/x/xresprobe/xresprobe_0.4.24ubuntu9.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ca8843dff1151afa9d003b31f73b2ae3"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/x/xresprobe/xresprobe_0.4.24ubuntu9.tar.gz"
SRC_URI[md5sum] = "8576c0ba7a336677a3749dcd135de596"
SRC_URI[sha256sum] = "0a7add0e05dc9a096e1028b750aaca3f055f8a784ace84f23c57195d187f13ed"

S = "${WORKDIR}/${BPN}-0.4.24ubuntu9"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

# BK 170522 the defaults created by recipetool, work....

do_configure () {
	# Specify any needed configure commands here
	#:
	# BK 170607 x86_64 build failed, so revert this...
	if [ "${TARGET_ARCH}" != "x86_64" ];then
	 # BK 170601 target i586, remove so that OE can use it's cross-compiler...
	 sed -i 's%^CC =%# CC =%' ${S}/ddcprobe/Makefile
	 # another problem "uname -m" in Makefile reports on the host, not the target arch.
	 sed -i 's%shell uname -m%TARGET_ARCH%' ${S}/ddcprobe/Makefile
	fi
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	# This is a guess; additional arguments may be required
	oe_runmake install 'DESTDIR=${D}'
}


HOMEPAGE = ""
SUMMARY = "Monitor resolution probe"
