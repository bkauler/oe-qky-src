
# BK 170512 libcrmf.a does not get installed, but seamonkey 2.48b1 wants it
# when link with system nss.
# note, nss_3.28.1.bb also has do_install_append(), both get appended.
do_install_append () {
 #this also installs in nss-native, have to create usr/lib...
 install -d ${D}/usr/lib
 install -m 755 ${S}/nss/lib/crmf/*.OBJ/libcrmf.a ${D}/usr/lib
}

# ...usr/lib/libcrmf.a has also installed in nss-native, does this matter?
