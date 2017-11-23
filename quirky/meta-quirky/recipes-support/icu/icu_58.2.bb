require icu.inc

LIC_FILES_CHKSUM = "file://../LICENSE;md5=1b3b75c1777cd49ad5c6a24cd338cfc9"

def icu_download_version(d):
    pvsplit = d.getVar('PV').split('.')
    return pvsplit[0] + "_" + pvsplit[1]

ICU_PV = "${@icu_download_version(d)}"

# http://errors.yoctoproject.org/Errors/Details/20486/
ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"

# BK 171120 patches added from seamonkey 2.49.1...
BASE_SRC_URI = "http://download.icu-project.org/files/icu4c/${PV}/icu4c-${ICU_PV}-src.tgz"
SRC_URI = "${BASE_SRC_URI} \
           file://icu-pkgdata-large-cmd.patch \
           file://fix-install-manx.patch \
           file://bug-1198952-workaround-make-3.82-bug.diff;striplevel=4 \
           file://bug-1228227-bug-1263325-libc++-gcc_hidden.diff;striplevel=4 \
           file://bug-915735.patch;striplevel=4 \
           file://suppress-warnings.diff;striplevel=4 \
           file://ucol_getKeywordValuesForLocale-ulist_resetList.diff;striplevel=4 \
          "

SRC_URI_append_class-target = "\
           file://0001-Disable-LDFLAGSICUDT-for-Linux.patch \
          "
SRC_URI[md5sum] = "fac212b32b7ec7ab007a12dff1f3aea1"
SRC_URI[sha256sum] = "2b0a4410153a9b20de0e20c7d8b66049a72aef244b53683d0d7521371683da0c"

UPSTREAM_CHECK_REGEX = "(?P<pver>\d+(\.\d+)+)/"
UPSTREAM_CHECK_URI = "http://download.icu-project.org/files/icu4c/"
