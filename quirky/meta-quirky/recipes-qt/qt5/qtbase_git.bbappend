
# qt configure gives warning, have removed these:
#  iconv libproxy pcre
# have also removed this, don't know why we need gtk dep anyway:
#  gtk 

# 181222 r1
PR = "r1"

#PACKAGECONFIG_append = " sm harfbuzz gif sql-sqlite mtdev cups fontconfig icu kms openssl"

# 181222 to compile qtstyleplugins with support for gtk2 theming, need accessibility...
PACKAGECONFIG_append = " sm harfbuzz gif sql-sqlite mtdev cups fontconfig \
                         icu kms openssl accessibility"

