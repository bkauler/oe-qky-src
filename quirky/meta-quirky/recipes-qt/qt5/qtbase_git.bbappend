
# qt configure gives warning, have removed these:
#  iconv libproxy pcre
# have also removed this, don't know why we need gtk dep anyway:
#  gtk 

PACKAGECONFIG_append = " sm harfbuzz gif sql-sqlite mtdev cups fontconfig \
                         icu kms openssl"
