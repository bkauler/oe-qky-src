
# 170523 vim compiled without gtk frontend, add it...
inherit pkgconfig
DEPENDS += "gtk+ libxpm libx11 libxt"
PACKAGECONFIG_append = " x11 gtkgui"
PACKAGECONFIG[gtkgui] = ",,"
PR = "r1"
EXTRA_OECONF += " --enable-gui=gtk2 --disable-gtk2-check --disable-gnome-check"

#do_install creates usr/bin/vim.vim, undo...
do_install_append () {
 mv -f ${D}${bindir}/${BPN}.${BPN} ${D}${bindir}/${BPN}
}
