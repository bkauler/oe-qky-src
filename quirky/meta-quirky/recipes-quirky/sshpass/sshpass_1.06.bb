# Recipe created by recipetool
# recipetool create -o sshpass_1.06.bb https://downloads.sourceforge.net/project/sshpass/sshpass/1.06/sshpass-1.06.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "https://downloads.sourceforge.net/project/sshpass/sshpass/${PV}/sshpass-${PV}.tar.gz"
SRC_URI[md5sum] = "f59695e3b9761fb51be7d795819421f9"
SRC_URI[sha256sum] = "c6324fcee608b99a58f9870157dfa754837f8c48be3df0f5e2f3accf145dee60"

DEPENDS = "libxml2 openssh openssl sudo"
inherit autotools pkgconfig

EXTRA_OECONF = ""


HOMEPAGE = "http://sourceforge.net/projects/sshpass"
SUMMARY = "A tool for noninteractive sshsftp password authentication."
