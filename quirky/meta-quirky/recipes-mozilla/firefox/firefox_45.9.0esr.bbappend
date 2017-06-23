
# 170505 remove 'pulseaudio', add 'ffmpeg', 'hunspell', 'libnotify'...
# note: libnotify wants gtk+3
DEPENDS = "gnu-config-native virtual/libintl libxt libxi zip-native gtk+ alsa-lib curl startup-notification libevent cairo libvpx \
            virtual/libgl nss nspr yasm-native icu unzip-native ffmpeg hunspell sqlite3"

# 170512 have fixed config of sqlite3 so now compatible with firefox. added to deps.
# nup, still get error:
#  configure:25021: checking for SQLITE_SECURE_DELETE support in system SQLite
#  configure: error: System SQLite library is not compiled with SQLITE_SECURE_DELETE.

# 170513 ref: http://www.linuxfromscratch.org/blfs/view/7.9/xsoft/firefox.html
# "From firefox-40, using system cairo causes firefox to crash frequently when it is doing background rendering in a tab."


# do_configure is exported from 'mozilla' class, overwrite here...
do_configure() {
    echo "ac_add_options --target=${TARGET_SYS}
ac_add_options --prefix=${prefix}
ac_add_options --libdir=${libdir}

ac_add_options --enable-application=browser
ac_add_options --enable-official-branding

ac_add_options --disable-elf-hack
ac_add_options --disable-gold
ac_add_options --disable-strip
ac_add_options --disable-install-strip

# System libraries
ac_add_options --with-system-nss
ac_add_options --with-system-nspr
#ac_add_options --with-system-jpeg # Insufficient JPEG library version
ac_add_options --with-system-zlib
ac_add_options --with-system-bz2
#ac_add_options --with-system-png # system's libpng doesn't have APNG support
ac_add_options --without-system-libevent
ac_add_options --with-system-libvpx
ac_add_options --with-system-icu
ac_add_options --enable-system-ffi
#ac_add_options --disable-system-pixman
ac_add_options --disable-system-cairo
ac_add_options --enable-system-hunspell
#ac_add_options --enable-system-sqlite

# Features
ac_add_options --enable-startup-notification
ac_add_options --disable-pulseaudio
ac_add_options --disable-gstreamer
ac_add_options --disable-pango
ac_add_options --disable-tests
ac_add_options --disable-necko-wifi
ac_add_options --disable-pedantic
ac_add_options --disable-gnomevfs
ac_add_options --disable-gconf
ac_add_options --disable-crashreporter
ac_add_options --disable-updater
ac_add_options --disable-installer
ac_add_options --disable-debug-symbols
ac_add_options --disable-accessibility
ac_add_options --disable-parental-controls
ac_add_options --disable-gnomeui
ac_add_options --disable-debug
ac_add_options --disable-dbus" > ${MOZCONFIG}
	# Put PARALLEL_MAKE into mozconfig
	if [ ! -z "${PARALLEL_MAKE}" ] ; then
		echo mk_add_options MOZ_MAKE_FLAGS=\"${PARALLEL_MAKE}\" \
			>> ${MOZCONFIG}
	fi
	oe_runmake -f client.mk -s configure
}
