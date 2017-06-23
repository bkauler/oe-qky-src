
# meta/recipes-graphics/xorg-xserver/xserver-xorg.inc has this:
# XSERVER_RRECOMMENDS = "xkeyboard-config rgb xserver-xf86-config xkbcomp xf86-input-libinput"
# i have gone back to the original -input-* pkgs, remove -libinput:
XSERVER_RRECOMMENDS = "xkeyboard-config rgb xserver-xf86-config xkbcomp"
