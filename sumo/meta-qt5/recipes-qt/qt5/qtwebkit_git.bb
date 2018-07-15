require qt5.inc
require qt5-git.inc

LICENSE = "BSD & LGPLv2+ | GPL-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPLv2;md5=05832301944453ec79e40ba3c3cfceec \
    file://Source/WebCore/rendering/RenderApplet.h;endline=22;md5=fb9694013ad71b78f8913af7a5959680 \
    file://Source/WebKit/gtk/webkit/webkit.h;endline=21;md5=b4fbe9f4a944f1d071dba1d2c76b3351 \
    file://Source/JavaScriptCore/parser/Parser.h;endline=21;md5=bd69f72183a7af673863f057576e21ee \
"

DEPENDS += "qtbase qtdeclarative icu ruby-native sqlite3 glib-2.0 libxslt gperf-native"

# qemuarm build fails with:
# | {standard input}: Assembler messages:
# | {standard input}:106: Error: invalid immediate: 983040 is out of range
# | {standard input}:106: Error: value of 983040 too large for field of 2 bytes at 146
ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"

# https://bugzilla.yoctoproject.org/show_bug.cgi?id=9474
# https://bugs.webkit.org/show_bug.cgi?id=159880
# JSC JIT can build on ARMv7 with -marm, but doesn't work on runtime.
# Upstream only tests regularly the JSC JIT on ARMv7 with Thumb2 (-mthumb).
ARM_INSTRUCTION_SET_armv7a = "thumb"
ARM_INSTRUCTION_SET_armv7r = "thumb"
ARM_INSTRUCTION_SET_armv7ve = "thumb"

# Patches from https://github.com/meta-qt5/qtwebkit/commits/b5.10
# 5.10.meta-qt5.1
SRC_URI += "\
    file://0001-qtwebkit-fix-QA-issue-bad-RPATH.patch \
    file://0002-Exclude-backtrace-API-for-non-glibc-libraries.patch \
"

PACKAGECONFIG ??= "gstreamer qtlocation qtmultimedia qtsensors qtwebchannel \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'libxcomposite libxrender', '', d)} \
    fontconfig \
"
PACKAGECONFIG[gstreamer] = "OE_GSTREAMER_ENABLED,,gstreamer1.0 gstreamer1.0-plugins-base"
PACKAGECONFIG[gstreamer010] = "OE_GSTREAMER010_ENABLED,,gstreamer gst-plugins-base"
PACKAGECONFIG[qtlocation] = "OE_QTLOCATION_ENABLED,,qtlocation"
PACKAGECONFIG[qtmultimedia] = "OE_QTMULTIMEDIA_ENABLED,,qtmultimedia"
PACKAGECONFIG[qtsensors] = "OE_QTSENSORS_ENABLED,,qtsensors"
PACKAGECONFIG[qtwebchannel] = "OE_QTWEBCHANNEL_ENABLED,,qtwebchannel"
PACKAGECONFIG[libwebp] = "OE_LIBWEBP_ENABLED,,libwebp"
PACKAGECONFIG[libxcomposite] = "OE_LIBXCOMPOSITE_ENABLED,,libxcomposite"
PACKAGECONFIG[libxrender] = "OE_LIBXRENDER_ENABLED,,libxrender"
PACKAGECONFIG[fontconfig] = "OE_FONTCONFIG_ENABLED,,fontconfig"

do_configure_prepend() {
    export QMAKE_CACHE_EVAL="CONFIG+=${PACKAGECONFIG_CONFARGS}"
    # disable gstreamer-1.0 test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(packagesExist(".*\<gstreamer-1.0\>.*")\)/ OE_GSTREAMER_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable gstreamer-0.10 test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(packagesExist(".*\<gstreamer-0.10\>.*")\)/ OE_GSTREAMER010_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable qtlocation test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(qtHaveModule(positioning)\)/ OE_QTLOCATION_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable qtmultimedia test if it isn't enabled by PACKAGECONFIG
    sed -e 's/(video):\(qtHaveModule(multimediawidgets)\)/(video):OE_QTMULTIMEDIA_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable qtsensors test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(qtHaveModule(sensors)\)/ OE_QTSENSORS_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable qtwebchannel test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(qtHaveModule(webchannel)\)/ OE_QTWEBCHANNEL_ENABLED:\1/' -i ${S}/Source/WebKit2/Target.pri
    sed -e 's/\s\(qtHaveModule(webchannel)\)/ OE_QTWEBCHANNEL_ENABLED:\1/' -i ${S}/Source/WebKit2/WebKit2.pri
    # disable libwebp test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(config_libwebp: \)/ OE_LIBWEBP_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable libxcomposite test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(config_libXcomposite: \)/ OE_LIBXCOMPOSITE_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable libxrender test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(config_libXrender: \)/ OE_LIBXRENDER_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
    # disable fontconfig test if it isn't enabled by PACKAGECONFIG
    sed -e 's/\s\(config_fontconfig: \)/ OE_FONTCONFIG_ENABLED:\1/' -i ${S}/Tools/qmake/mkspecs/features/features.prf
}

# Forcibly enable ICU, so qtbase doesn't need it.
EXTRA_QMAKEVARS_PRE += "QT_CONFIG+=icu"

# qtwebkit gets terribly big when linking with all debug info, disable by default
QTWEBKIT_DEBUG = "QMAKE_CFLAGS+=-g0 QMAKE_CXXFLAGS+=-g0"
EXTRA_QMAKEVARS_PRE += "${QTWEBKIT_DEBUG}"

do_install_append() {
    # Remove paths to workdir, qtwebkit is dead now, so I won't spend extra time trying to prevent this
    # from some .prl or .prf file like for other modules
    sed -i 's@-Wl,-no-whole-archive -L${B}[^ ]* @ @g' ${D}${libdir}/pkgconfig/Qt5WebKit.pc
}

# remove default ${PN}-examples* set in qt5.inc, because they conflicts with ${PN} from separate webkit-examples recipe
PACKAGES_remove = "${PN}-examples-dev ${PN}-examples-staticdev ${PN}-examples-dbg ${PN}-examples"

# make sure rb files are used from sysroot, not from host
# ruby-1.9.3-always-use-i386.patch is doing target_cpu=`echo $target_cpu | sed s/i.86/i386/`
# we need to replace it too (a bit longer version without importing re)
RUBY_SYS = "${@ '${BUILD_SYS}'.replace('i486', 'i386').replace('i586', 'i386').replace('i686', 'i386') }"
export RUBYLIB="${STAGING_DATADIR_NATIVE}/rubygems:${STAGING_LIBDIR_NATIVE}/ruby:${STAGING_LIBDIR_NATIVE}/ruby/${RUBY_SYS}"

QT_MODULE_BRANCH = "5.9"

SRCREV = "bd0657f98aff85b9f06d85a8cf4da6a27f61a56e"
