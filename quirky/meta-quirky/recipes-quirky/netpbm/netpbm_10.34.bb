# Recipe created by recipetool
# recipetool create -o netpbm_10.34.bb https://downloads.sourceforge.net/project/netpbm/archive_of_old_release_system/10.34/netpbm-10.34.tgz

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   doc/copyright_summary
#   doc/GPL_LICENSE.txt
#   doc/COPYRIGHT.PATENT
#   converter/other/cameratopam/COPYRIGHT
#   converter/other/pnmtopalm/LICENSE
#   converter/ppm/ppmtompeg/COPYRIGHT
#   converter/pbm/pbmtoppa/LICENSE
#   other/pamx/COPYRIGHT
#   lib/util/LICENSE.txt
#
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://doc/GPL_LICENSE.txt;md5=079b27cd65c86dbc1b6997ffde902735"

SRC_URI = "https://downloads.sourceforge.net/project/netpbm/archive_of_old_release_system/${PV}/netpbm-${PV}.tgz \
           file://glibc.patch \
           file://jpeg.patch \
           file://makefile.patch \
           file://shared_files-fix.patch \
           file://ppmtojpeg.patch \
           file://ldflags-insert.patch \
           file://Makefile.config \
           file://oeendiangen"
SRC_URI[md5sum] = "851137b746e9a08c46e6580743c036c4"
SRC_URI[sha256sum] = "b1e0a35be36e763e85c68b47806e7e1abf431f68289dd108923384b77ded785b"

DEPENDS = "libx11 jpeg libpng12 tiff libxpm librsvg perl-native flex-native libxml2 zlib"
#inherit autotools-brokensep pkgconfig
inherit pkgconfig

# NOTE: this is a Makefile-only piece of software. ...OE is wrong. there is a configure
# script, calls a perl script. problem is, it asks for user input, which can be
# automated, but maybe easier just to pre-create a Makefile. Ok did this in host system,
# it created Makefile.config (see above).

SROOT = "${WORKDIR}/recipe-sysroot"
PARALLEL_MAKE = ""
#EXTRA_OEMAKE = "ENDIANGEN=${S}/buildtools/oeendiangen TARGET_LD=${LD} 'STRIPFLAG='"
EXTRA_OEMAKE = " 'STRIPFLAG='"

# BK 170616 ha ha, took me all day, but it finally compiled! x86_64 target only so far.

do_configure () {
    ##prevent die if unrecognized option...
    #sed -i -e 's%.*Unrecognized option% #%' buildtools/configure.pl
    #oe_runconf
    cp -f ${WORKDIR}/Makefile.config ./
    sed -i -e 's%^BUILD_FIASCO = .*%BUILD_FIASCO = N%' Makefile.config
    sed -i -e 's%^CC = %#CC = %' Makefile.config
    if [ "${TARGET_ARCH}" == "x86_64" ];then #***WARNING***maybe more 64-bit in future.
     sed -i -e 's%^HAVE_INT64 = .*%HAVE_INT64 = Y%' Makefile.config
    else
     sed -i -e 's%^HAVE_INT64 = .*%HAVE_INT64 = N%' Makefile.config
    fi
    #this is for compiling binaries that will run on the host pc...
    sed -i -e 's%^CC_FOR_BUILD = .*%CC_FOR_BUILD = $(BUILD_CC)%' Makefile.config
    sed -i -e 's%^LD_FOR_BUILD = .*%LD_FOR_BUILD = $(BUILD_CC)%' Makefile.config
    sed -i -e "s%^LDRELOC = .*%LDRELOC = ${LD} --reloc%" Makefile.config
    sed -i -e 's%^CFLAGS_FOR_BUILD = .*%CFLAGS_FOR_BUILD = %' Makefile.config
    sed -i -e 's%^CFLAGS_SHLIB =.*%CFLAGS_SHLIB = -fPIC -flax-vector-conversions%' Makefile.config
    sed -i -e 's%^OMIT_NETWORK =.*%OMIT_NETWORK = y%' Makefile.config
    sed -i -e "s%^PKGDIR_DEFAULT = .*%PKGDIR_DEFAULT = ${WORKDIR}/out-netpbm%" Makefile.config
    sed -i -e 's%^CFLAGS = %CFLAGS += -fPIC -flax-vector-conversions %' Makefile.config
    sed -i -e "s%^X11LIB = %X11LIB = ${SROOT}%" Makefile.config
    sed -i -e 's%-O3%-O2%' Makefile.config
    #function conflicts with C func:
    sed -i -e 's%getline%my_getline%' converter/ppm/xpmtoppm.c
    
    #this is supposed to be automatically generated, but is broken...
    echo '#ifndef PM_CONFIG_H
#define PM_CONFIG_H
#include <inttypes.h>' > pm_config.h
    if [ "${TARGET_ARCH}" == "x86_64" ];then #***WARNING***maybe more 64-bit in future.
     echo '#define HAVE_INT64 1' >> pm_config.h
    else
     echo '#define HAVE_INT64 0' >> pm_config.h
    fi
    cat pm_config.in.h >> pm_config.h
    echo '#endif' >> pm_config.h
    
    #oe does not like xml2-config...
    sed -i -e 's%xml2-config --version%pkg-config --version libxml-2.0%' converter/other/Makefile
    sed -i -e 's%xml2-config --libs%pkg-config --libs libxml-2.0%' converter/other/Makefile
    sed -i -e 's%xml2-config --cflags%pkg-config --cflags libxml-2.0%' converter/other/Makefile
    
   	# The following stops the host endiangen program being run and uses
	# the target endian.h header instead. note, got this from old classic-oe recipe,
	# ref: https://github.com/openembedded/openembedded/tree/master/recipes/netpbm
    cp -f ${WORKDIR}/oeendiangen buildtools/endiangen
    chmod 755 buildtools/endiangen
    #install -c -m 755 ../oeendiangen buildtools
    
    #...endian not working here, bypass...
    echo -e '\nall:\n\ncammeratopam:\n\ninstall:\n\nclean:\n\ninstall.bin:\n\ninstall.data:\n\ninstall.merge:\n\ninstall.man:\n\ndep:\n\n' > converter/other/cameratopam/Makefile
    
    # it seems png.h used to include zlib.h, but not in libpng16...
    sed -i -e 's%^#include "version.h"%#include "version.h"\n#include <zlib.h>%' converter/other/pnmtopng.c
    
    # wants the old libpng...
    sed -i -e 's%^PNGLIB = .*%PNGLIB = libpng12.so%' Makefile.config
    echo "PNGHDR_DIR = ${SROOT}/usr/include/libpng12" >> Makefile.config
    ln -snf libpng12.so ${SROOT}/usr/lib/libpng.so
}

do_compile () {
	oe_runmake
}

do_install () {
    #this will install into folder ${WORKDIR}/out-netpbm:
    oe_runmake package
    install -d ${D}/usr/bin
    #install -D ${WORKDIR}/out-netpbm/bin/* ${D}/usr/bin
    install -d ${D}/usr/lib
    #install -D ${WORKDIR}/out-netpbm/lib/* ${D}/usr/lib
    install -d ${D}/usr/share/netpbm
    #install -D ${WORKDIR}/out-netpbm/misc/* ${D}/usr/share/netpbm
    #...crap, converts symlinks into files.
    cp -a -f ${WORKDIR}/out-netpbm/bin/* ${D}/usr/bin/
    cp -a -f ${WORKDIR}/out-netpbm/lib/* ${D}/usr/lib/
    cp -a -f ${WORKDIR}/out-netpbm/misc/* ${D}/usr/share/netpbm/
}


HOMEPAGE = "http://sourceforge.net/projects/netpbm"
SUMMARY = "Collection of primitive graphics tools converters etc"
