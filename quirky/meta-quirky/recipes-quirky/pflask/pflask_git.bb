# Recipe created by recipetool
# recipetool create -o pflask_git.bb https://github.com/ghedo/pflask.git
# ref: https://github.com/OverC/meta-overc/blob/master-oci/meta-cube/recipes-containers/pflask/pflask_git.bb

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=c2cd5f772e6f9b401d92014b0d1ebccd"

SRC_URI = "git://github.com/ghedo/pflask.git;protocol=https \
           https://waf.io/pub/release/waf-1.8.6"
# need this for waf-1.8.6:
SRC_URI[md5sum] = "5b674ac8b5735b054d0500c35940891f"
SRC_URI[sha256sum] = "81c4e6a3144c7b2021a839e7277bdaf1cedbbc87302186897b4ae03f4effcbf5"

#note, have also got files/waf-1.8.6, could use that instead of d/l.

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "9ac31ffe2ed29453218aac89ae992abbd6e7cc69"

S = "${WORKDIR}/git"

inherit pkgconfig waf pythonnative

# dbus and libcap-ng are optional deps, but i don't think need dbus...
DEPENDS = "libcap-ng"

do_configure_prepend () {
	cp -f ${WORKDIR}/waf-1.8.6 ./waf
	chmod 755 waf
}

XXXdo_configure () {
	cp -f ${WORKDIR}/waf-1.8.6 ./waf
	chmod 755 waf
	./waf configure --prefix=${prefix}
}

XXXdo_compile () {
	./waf build
}

do_install () {
	install -d ${D}/usr/bin
	install -m 755 build/pflask ${D}/usr/bin
}

SECTION = "devel"
SUMMARY = "Light weight container runtime"
HOMEPAGE = "https://ghedo.github.io/pflask/"
