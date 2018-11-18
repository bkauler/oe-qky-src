#ref: https://iwd.wiki.kernel.org/gettingstarted
#ref: https://lists.01.org/pipermail/iwd/2014-September/000010.html

HOMEPAGE = "https://git.kernel.org/pub/scm/libs/ell/ell.git"
SUMMARY = "Replacement for wpa_supplicant"

#SRC_URI = "git://git-amr-4.devtools.intel.com/otc_wireless-iwd.git;name=iwd;destsuffix=iwd/"
SRC_URI = "git://git.kernel.org/pub/scm/network/wireless/iwd.git;name=iwd;destsuffix=iwd/"
SRC_URI += "git://git.kernel.org/pub/scm/libs/ell/ell.git;name=ell;destsuffix=ell/"

SRCREV_FORMAT = "iwd_ell"
SRCREV_iwd = "${AUTOREV}"
SRCREV_ell = "${AUTOREV}"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fb504b67c50331fc78734fed90fb0e09"

PR = "r0"

S = "${WORKDIR}/iwd"
PV = "0.1+git${SRCPV}"

EXTRA_OECONF = " \
  --enable-sim-hardcoded \
  --enable-ofono \
  --enable-wired \
  --enable-hwsim \
  --enable-tools \
  --disable-dbus-policy \
  --disable-systemd-service \
"

#vim has the 'xxd' utility, needed during compile. busybox also has xxd but lacks the -i param.
DEPENDS = "vim readline dbus-glib dbus ofono mobile-broadband-provider-info"

inherit autotools-brokensep pkgconfig

do_configure_prepend() {
 mkdir -p ${S}/build-aux
}

do_compile_prepend() {
 #this is missing, copy...
 if [ ! -f ${WORKDIR}/iwd/ell/ell.h ];then
  mkdir -p ${WORKDIR}/iwd/ell
  cp -a -f ${WORKDIR}/ell/ell/ell.h ${WORKDIR}/iwd/ell/
 fi
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/tools/hwsim ${D}${bindir}
	install -m 0755 ${S}/wired/ead ${D}${bindir}
	install -m 0755 ${S}/src/iwd ${D}${bindir}
	install -m 0755 ${S}/monitor/iwmon ${D}${bindir}
	install -m 0755 ${S}/client/iwctl ${D}${bindir}
}

PACKAGES =+ "${PN}-tools ${PN}-client"
FILES_${PN} += "${bindir}/iwd"
FILES_${PN}-tools += "${bindir}/hwsim"
FILES_${PN}-client += "${bindir}/iwmon ${bindir}/iwctl"
