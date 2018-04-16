DEFAULTTUNE ?= "cortexa53-32"

require conf/machine/include/arm/arch-armv8.inc

TUNEVALID[cortexa53] = "Enable Cortex-A53 specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'cortexa53', ' -mcpu=cortex-a53 ', '',d)}"

# Extra tune selections
AVAILTUNES += "cortexa53-32"
ARMPKGARCH_tune-cortexa53-32 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53-32 = "${TUNE_FEATURES_tune-armv8-neon-crc} cortexa53"
BASE_LIB_tune-cortexa53-32 = "lib"
TUNE_PKGARCH_tune-cortexa53-32 = "cortexa53-32"
PACKAGE_EXTRA_ARCHS_tune-cortexa53-32 = "${PACKAGE_EXTRA_ARCHS_tune-armv8-neon-crc} cortexa53-32 cortexa53-neon-fp-armv8"

AVAILTUNES += "cortexa53crypto-32"
ARMPKGARCH_tune-cortexa53crypto-32 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53crypto-32 = "${TUNE_FEATURES_tune-armv8-neon-crypto-crc} cortexa53"
BASE_LIB_tune-cortexa53crypto-32 = "lib"
TUNE_PKGARCH_tune-cortexa53crypto-32 = "cortexa53crypto-32"
PACKAGE_EXTRA_ARCHS_tune-cortexa53crypto-32 = "${PACKAGE_EXTRA_ARCHS_tune-armv8-neon-crypto-crc} cortexa53-32 cortexa53-crypto-neon-fp-armv8"

AVAILTUNES += "cortexa53hf-32"
ARMPKGARCH_tune-cortexa53hf-32 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53hf-32 = "${TUNE_FEATURES_tune-armv8hf-neon-crc} cortexa53"
BASE_LIB_tune-cortexa53hf-32 = "lib"
TUNE_PKGARCH_tune-cortexa53hf-32 = "cortexa53hf-32"
PACKAGE_EXTRA_ARCHS_tune-cortexa53hf-32 = "${PACKAGE_EXTRA_ARCHS_tune-armv8hf-neon-crc} cortexa53hf-32 cortexa53hf-neon-fp-armv8"

AVAILTUNES += "cortexa53hfcrypto-32"
ARMPKGARCH_tune-cortexa53hfcrypto-32 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53hfcrypto-32 = "${TUNE_FEATURES_tune-armv8hf-neon-crypto-crc} cortexa53"
BASE_LIB_tune-cortexa53hfcrypto-32 = "lib"
TUNE_PKGARCH_tune-cortexa53hfcrypto-32 = "cortexa53hfcrypto-32"
PACKAGE_EXTRA_ARCHS_tune-cortexa53hfcrypto-32 = "${PACKAGE_EXTRA_ARCHS_tune-armv8hf-neon-crypto-crc} cortexa53hf-32 cortexa53hf-crypto-neon-fp-armv8"

AVAILTUNES += "cortexa53-64"
ARMPKGARCH_tune-cortexa53-64 ?= "cortexa53"
TUNE_FEATURES_tune-cortexa53-64 = "${TUNE_FEATURES_tune-aarch64} cortexa53"
BASE_LIB_tune-cortexa53-64 = "lib64"
TUNE_PKGARCH_tune-cortexa53-64 = "cortexa53-64"
PACKAGE_EXTRA_ARCHS_tune-cortexa53-64 = "${PACKAGE_EXTRA_ARCHS_tune-aarch64} cortexa53-64"

