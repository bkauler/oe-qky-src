
# could do this...
# require recipes-sato/image/core-image-sato.bb

# but no, do it from scratch...
# ref: 'Embedded Linux Development with Yocto Project' page 89
inherit core-image

# ref: meta/classes/core-image.bbclass
IMAGE_FEATURES += "dev-pkgs ssh-server-openssh tools-debug tools-sdk x11 hwcodecs package-management debug-tweaks"

# meta/recipes-graphics/xorg-xserver/xserver-xorg.inc has this line:
# XSERVER_RRECOMMENDS = "xkeyboard-config rgb xserver-xf86-config xkbcomp xf86-input-libinput"
# i want to change it...
# ref: https://patchwork.openembedded.org/patch/133129/
# can i just override here?...
#XSERVER_RRECOMMENDS = "xkeyboard-config rgb xserver-xf86-config xkbcomp xf86-input-evdev xf86-input-keyboard xf86-input-mouse xf86-input-synaptics"
# ...dunno. instead, have created meta-quirky/recipes-graphics/xorg-xserver/xserver-xorg_1.19.1.bbappend

# want to get rid of 'avahi' pkg. This is in DISTRO_FEATURES, see:
# meta/conf/distro/defaultsetup.conf is default distribution setup.
# it includes meta/conf/distro/include/default-distrovars.inc
# ref: https://www.toradex.com/community/questions/5524/how-to-disable-avahi-from-yocto-build.html
# ref: meta/recipes-core/packagegroups/packagegroup-base.bb
#BAD_RECOMMENDATIONS = "avahi-daemon avahi-autoipd libnss-mdns avahi"
#DISTRO_FEATURES_remove = "zeroconf"
# don't work here, but do in local.conf (why?)

