# Recipe created by recipetool
# recipetool create -o apulse_0.1.12.bb https://github.com/i-rinat/apulse/archive/v0.1.12.tar.gz

LICENSE = "MIT & LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.MIT;md5=5a9126e7f56a0cf3247050de7f10d0f4 \
                    file://3rdparty/pulseaudio-headers/LGPL;md5=2d5025d4aa3495befef8f17206a5b0a1 \
                    file://3rdparty/pulseaudio-headers/GPL;md5=4325afd396febcb659c36b49533135d4"

SRC_URI = "https://github.com/i-rinat/apulse/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "9745e6ee3391f44a30c6a7642de19186"
SRC_URI[sha256sum] = "cfcadfe971abd785ed3ca24e576fcbaade185525c1eda76daf32dbf298e52892"

DEPENDS = "alsa-lib glib-2.0 libpcre"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release"

INSANE_SKIP_${PN} = "dev-so"

HOMEPAGE = "https://github.com/i-rinat/apulse"
SUMMARY = "PulseAudio emulation for ALSA"
