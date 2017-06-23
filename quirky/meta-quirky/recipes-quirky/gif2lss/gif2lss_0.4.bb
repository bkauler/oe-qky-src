# Recipe created by recipetool
# recipetool create -o gif2lss_0.4.bb http://www.13thfloor.at/old/Software/gif2lss-0.4.tar.gz

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL.txt;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "http://www.13thfloor.at/old/Software/gif2lss-${PV}.tar.gz"
SRC_URI[md5sum] = "36369d362eedd4907357e8ab5a374e66"
SRC_URI[sha256sum] = "a797dee67139b1581d08489d457f07f77685761be7262a6e7ea19161385b5290"

DEPENDS = "libx11 giflib"
CFLAGS += " -fno-builtin -fPIC"

do_configure () {
    #use system giflib...
    sed -i -e 's%^#include "gif_lib/gif_lib.h"%#include <gif_lib.h>%' ${S}/gif2lss.c
    #a gif funcs need another parameter...
    sed -i -e 's%GifPixelType \*data;%GifPixelType *data;\nint *errcode1;%' ${S}/gif2lss.c
    sed -i -e 's%DGifCloseFile(gf)%DGifCloseFile(gf,errcode1)%' ${S}/gif2lss.c
    sed -i -e 's%DGifOpenFileName.*%DGifOpenFileName(argv[1],errcode1);%' ${S}/gif2lss.c
    #this func does not exist...
    sed -i -e 's%PrintGifError%//PrintGifError%' ${S}/gif2lss.c
}

do_compile () {
    ${CC} -c gif2lss.c ${CFLAGS}
    ${CC} -o gif2lss gif2lss.o ${LDFLAGS} -lgif
    
}

do_install () {
    install -d ${D}/usr/bin
    install -m755 gif2lss ${D}/usr/bin
}


HOMEPAGE = ""
SUMMARY = "A utility for converting 16 color gif images to LSS encoding."
