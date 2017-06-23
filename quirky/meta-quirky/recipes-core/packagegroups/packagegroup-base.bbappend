
# meta/recipes-core/packagegroups/packagegroup-base.bb pulls in 'avahi' and 'libnss-mdns'
# required for zeroconf. remove...
RDEPENDS_packagegroup-base-zeroconf = ""
RDEPENDS_packagegroup-base-zeroconf_append_libc-glibc = ""

# note, have 'DISTRO_FEATURES_remove = "zeroconf"' in local.conf
# which seems to have done the trick, don't know if this .bbappend is needed.
