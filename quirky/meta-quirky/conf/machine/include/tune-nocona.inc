# Settings for the GCC(1) cpu-type "nocona":
#
#      Intel Nocona CPU with 64-bit extensions, MMX, SSE, SSE2, SSE3
#      instruction set support.
#
# This tune is recommended for Nocona 64-bit CPU (2005) and later.
# Note, this is before core2, and lacks ssse3.
# Note, explicitly disabling sse3, with -mno-sse3
#
DEFAULTTUNE ?= "nocona-64"

# Set x86 target arch to i686, so that glibc enables SSE optimised memcpy, etc.
X86ARCH32 ?= "i686"

# Include the previous tune to pull in PACKAGE_EXTRA_ARCHS
require conf/machine/include/tune-i586.inc

# Extra tune features
TUNEVALID[nocona] = "Enable nocona specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'nocona', ' -march=nocona -mtune=nocona -mno-sse3 -mfpmath=sse', '', d)}"

# Extra tune selections

AVAILTUNES += "nocona-64"
TUNE_FEATURES_tune-nocona-64 = "${TUNE_FEATURES_tune-x86-64} nocona"
BASE_LIB_tune-nocona-64 = "lib64"
TUNE_PKGARCH_tune-nocona-64 = "nocona-64"
PACKAGE_EXTRA_ARCHS_tune-nocona-64 = "${PACKAGE_EXTRA_ARCHS_tune-x86-64} nocona-64"

AVAILTUNES += "nocona-64-x32"
TUNE_FEATURES_tune-nocona-64-x32 = "${TUNE_FEATURES_tune-x86-64-x32} nocona"
BASE_LIB_tune-nocona-64-x32 = "libx32"
TUNE_PKGARCH_tune-nocona-64-x32 = "nocona-64-x32"
PACKAGE_EXTRA_ARCHS_tune-nocona-64-x32 = "${PACKAGE_EXTRA_ARCHS_tune-x86-64-x32} nocona-64-x32"
