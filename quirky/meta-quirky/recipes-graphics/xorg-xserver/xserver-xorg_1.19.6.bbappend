
# meta/recipes-graphics/xorg-xserver/xserver-xorg.inc has this:
# XSERVER_RRECOMMENDS = "xkeyboard-config rgb xserver-xf86-config xkbcomp xf86-input-libinput"
# i have gone back to the original -input-* pkgs, remove -libinput:
XSERVER_RRECOMMENDS = "xkeyboard-config rgb xserver-xf86-config xkbcomp"

# 20180622
# xephyr needs: xcb-util-renderutil xcb-util-keysyms xcb-util-image xcb-util-wm
DEPENDS += "xinerama xcb-util-renderutil xcb-util-keysyms xcb-util-image xcb-util-wm"

# 20180622
EXTRA_OECONF += "--enable-kdrive \
                 --enable-xnest \
                 --enable-xephyr \
                 --enable-xinerama \
"
