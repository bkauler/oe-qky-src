require shared-mime-info.inc

PR = "r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "https://people.freedesktop.org/~hadess/shared-mime-info-${PV}.tar.bz2"
SRC_URI[md5sum] = "967d68d3890ba3994cfce3adf5b8f15b"
SRC_URI[sha256sum] = "52c9f84a8c72de631a0458542980b1728560f59845eb5e93e1dbe825f4b72304"

SRC_URI += "file://parallelmake.patch \
	    file://install-data-hook.patch \
	    file://shared-mime-info-ash-dash-script.patch"
