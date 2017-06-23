require icu.inc

LIC_FILES_CHKSUM = "file://../license.html;md5=64eff4aadff4d104d6d437c4fde0e6d7"

def icu_download_version(d):
    pvsplit = d.getVar('PV', True).split('.')
    return pvsplit[0] + "_" + pvsplit[1]

ICU_PV = "${@icu_download_version(d)}"

# http://errors.yoctoproject.org/Errors/Details/20486/
ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"

# BK added patches from seamonkey 2.48b1...
BASE_SRC_URI = "http://download.icu-project.org/files/icu4c/${PV}/icu4c-${ICU_PV}-src.tgz"
SRC_URI = "${BASE_SRC_URI} \
           file://icu-pkgdata-large-cmd.patch \
           file://fix-install-manx.patch \
           file://icu-release-56-1-flagparser-fix.patch \
           file://bug-915735.patch;striplevel=4 \
           file://bug-1172609-icu-fix.diff;striplevel=4 \
           file://bug-1172609-timezone-recreateDefault.diff;striplevel=4 \
           file://bug-1198952-workaround-make-3.82-bug.diff;striplevel=4 \
           file://bug-1228227-bug-1263325-libc++-gcc_hidden.diff;striplevel=4 \
           file://suppress-warnings.diff;striplevel=4 \
          "

SRC_URI_append_class-target = "\
           file://0001-Disable-LDFLAGSICUDT-for-Linux.patch \
          "
SRC_URI[md5sum] = "c4a2d71ff56aec5ebfab2a3f059be99d"
SRC_URI[sha256sum] = "3a64e9105c734dcf631c0b3ed60404531bce6c0f5a64bfe1a6402a4cc2314816"

UPSTREAM_CHECK_REGEX = "(?P<pver>\d+(\.\d+)+)/"
UPSTREAM_CHECK_URI = "http://download.icu-project.org/files/icu4c/"
