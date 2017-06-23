DECSRIPTION = "xclip is a command line interface to the X11 clipboard. It can also be used for copying files, as an alternative to sftp/scp, thus avoiding password prompts when X11 forwarding has already been setup."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS = "libxmu virtual/libx11 "

SRC_URI = "${SOURCEFORGE_MIRROR}/xclip/${P}.tar.gz"

# BK changed 'autotools' to 'autotools-brokensep' fixed do_configure...
inherit autotools-brokensep pkgconfig gettext

SRC_URI[md5sum] = "f7e19d3e976fecdc1ea36cd39e39900d"
SRC_URI[sha256sum] = "b7c7fad059ba446df5692d175c2a1d3816e542549661224806db369a0d716c45"

# BK ah, just having "oe_runconf" in here avoids the rebuilding of 'configure' script
# ...fixes do_configure...
do_configure() {
#    gnu-configize
#    libtoolize --force
    oe_runconf
}

HOMEPAGE = "http://xclip.sourceforge.net"
SUMMARY = "A command line interface to the X11 clipboard"
