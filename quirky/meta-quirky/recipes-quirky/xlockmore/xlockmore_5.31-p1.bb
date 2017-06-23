# Recipe created by recipetool
# recipetool create -o xlockmore_5.31-p1.bb http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xlockmore-5.31-patched.tar.bz2

#require recipes-graphics/xorg-app/xorg-app-common.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

# BK note, '5.31-patched' source, have edited xlock/mode.h, reduced list (line 490).

SRC_URI = "http://distro.ibiblio.org/quirky/quirky6/sources/t2/april/xlockmore-5.31-patched.tar.bz2 \
           file://xlockmore-no-plan.patch"
SRC_URI[md5sum] = "6f6c0dd8503e1d0ec3f7e267c4c09a4c"
SRC_URI[sha256sum] = "108f22b1df3af2711ef86fe6b544e2d683d0a479408c7ad5c0721ca365d03856"

S = "${WORKDIR}/${BPN}-5.31-patched"

DEPENDS = "libx11 libxt libxaw libxmu libxpm xproto libxau libxext libpng glib-2.0 jpeg libxdmcp libxinerama libice libsm freetype"

inherit pkgconfig autotools-brokensep gettext

EXTRA_OECONF = "--enable-xlockrc --without-motif --without-editres --without-gltt --without-ftgl --without-opengl --without-mesa --without-dtsaver --without-rplay --without-nas --enable-nice-only --without-gtk --without-gtk2 --without-esound --disable-pam --disable-gtktest"

# configure broken, so compiling files individually...
SROOT = "${WORKDIR}/recipe-sysroot"

do_configure() {
    #xlock/mode.h is cutdown, there is still one .cc file, solitaire.cc, remove it...
    sed -i -e 's%^#define MODE_solitaire%%' ${S}/xlock/mode.h
}

do_compile() {
    
    cd ${S}/xlock
    
    # -DDEF_FILESEARCHPATH=\"/usr/share/X11/app-defaults/%N%C%S\"
    
    for aFILE in xlock.c passwd.c resource.c parsecmd.c util.c logout.c mode.c xlockimage.c ras.c xbm.c vis.c visgl.c color.c random.c iostuff.c automata.c spline.c sound.c erase.c magick.c vtlock.c vtlock_proc.c 
    do
     ${CC} ${CFLAGS} -c  -DHAVE_CONFIG_H -DDEF_FILESEARCHPATH=\"/usr/lib/X11/app-defaults/%N%C%S:/usr/lib/X11/app-defaults/%N%S\" -I. -I.. -I..  -I${SROOT}/usr/include -I${SROOT}/usr/include/freetype2 ${aFILE}
    done

    cd ..
    cd modes

    for aFILE in anemone.c ant.c ant3d.c apollonian.c ball.c bat.c blot.c bouboule.c bounce.c braid.c bubble.c bug.c clock.c coral.c crystal.c daisy.c dclock.c decay.c deco.c deluxe.c demon.c dilemma.c discrete.c dragon.c drift.c euler2d.c eyes.c fadeplot.c fiberlamp.c flag.c flame.c flow.c forest.c fzort.c galaxy.c goop.c grav.c helix.c hop.c hyper.c ico.c ifs.c image.c juggle.c julia.c kaleid.c kumppa.c laser.c life.c life1d.c life3d.c lightning.c lisa.c lissie.c loop.c lyapunov.c mandelbrot.c marquee.c matrix.c maze.c mountain.c munch.c nose.c pacman.c penrose.c petal.c petri.c polyominoes.c puzzle.c pyro.c pyro2.c qix.c rain.c roll.c rotor.c scooter.c shape.c sierpinski.c slip.c space.c sphere.c spiral.c spline.c star.c starfish.c strange.c swarm.c swirl.c t3d.c tetris.c thornbird.c tik_tak.c toneclock.c triangle.c tube.c turtle.c vines.c voters.c wator.c wire.c world.c worm.c xcl.c xjack.c bomb.c blank.c random.c
    do
     ${CC} ${CFLAGS} -c  -DHAVE_CONFIG_H -DDEF_FILESEARCHPATH=\"/usr/lib/X11/app-defaults/%N%C%S:/usr/lib/X11/app-defaults/%N%S\" -I. -I.. -I.. -I../xlock/ -I${SROOT}/usr/include -I${SROOT}/usr/include/freetype2 ${aFILE}
    done

    ${CC} ${LDFLAGS} -o ../xlock/xlock ../xlock/xlock.o ../xlock/passwd.o ../xlock/resource.o ../xlock/parsecmd.o  ../xlock/util.o ../xlock/logout.o ../xlock/mode.o ../xlock/xlockimage.o ../xlock/ras.o ../xlock/xbm.o  ../xlock/vis.o ../xlock/visgl.o ../xlock/color.o ../xlock/random.o ../xlock/iostuff.o ../xlock/automata.o  ../xlock/spline.o ../xlock/sound.o ../xlock/erase.o ../xlock/magick.o  ../xlock/vtlock.o ../xlock/vtlock_proc.o  anemone.o ant.o ant3d.o apollonian.o  ball.o bat.o blot.o  bouboule.o bounce.o braid.o bubble.o bug.o  clock.o coral.o crystal.o  daisy.o dclock.o decay.o deco.o deluxe.o demon.o  dilemma.o discrete.o dragon.o drift.o euler2d.o eyes.o  fadeplot.o fiberlamp.o flag.o flame.o flow.o forest.o  fzort.o galaxy.o goop.o grav.o  helix.o hop.o hyper.o  ico.o ifs.o image.o juggle.o julia.o kaleid.o kumppa.o  laser.o life.o life1d.o life3d.o  lightning.o lisa.o lissie.o loop.o lyapunov.o  mandelbrot.o marquee.o matrix.o maze.o  mountain.o munch.o nose.o  pacman.o penrose.o petal.o petri.o  polyominoes.o puzzle.o pyro.o pyro2.o  qix.o rain.o roll.o rotor.o  scooter.o shape.o sierpinski.o slip.o  space.o sphere.o spiral.o spline.o  star.o starfish.o strange.o swarm.o swirl.o  t3d.o tetris.o thornbird.o tik_tak.o toneclock.o  triangle.o tube.o turtle.o  vines.o voters.o  wator.o wire.o world.o worm.o xcl.o xjack.o bomb.o blank.o random.o        -lSM -lICE   -lXpm -lfreetype -lXinerama -lX11 -lXext -lm -lcrypt
    cd ..
}

do_install() {
    install -d ${D}/usr/bin
    install -m755 ${S}/xlock/xlock ${D}/usr/bin
    install -d ${D}/usr/lib/X11/app-defaults
    install -m644 ${S}/xlock/XLock.ad ${D}/usr/lib/X11/app-defaults/XLock
    install -d ${D}/usr/share/man/man1
    install -m644 ${S}/xlock/xlock.man ${D}/usr/share/man/man1/xlock.1
}

HOMEPAGE = "http://www.tux.org/~bagleyd/xlockmore.html"
SUMMARY = "A collection of screensavers and lockers for X"
