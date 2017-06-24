DEFAULTTUNE ?= "i686"

require arch-x86.inc

# Extra tune features
TUNEVALID[i686] = "Enable i686 specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'i686', ' -march=i686', '', d)}"

# Extra tune selections
AVAILTUNES += "i686"
TUNE_FEATURES_tune-i686 = "${TUNE_FEATURES_tune-x86} i686"
BASE_LIB_tune-i686 = "lib"
TUNE_PKGARCH_tune-i686 = "i686"
PACKAGE_EXTRA_ARCHS_tune-i686 = "${PACKAGE_EXTRA_ARCHS_tune-x86} i686"
