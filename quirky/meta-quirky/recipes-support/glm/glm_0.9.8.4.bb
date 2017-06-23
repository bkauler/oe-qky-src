SUMMARY = "OpenGL Mathematics Library"
DESCRIPTION = "OpenGL Mathematics (GLM) is a header only C++ \
mathematics library for graphics software based on the OpenGL \
Shading Language (GLSL) specifications."
HOMEPAGE = "https://glm.g-truc.net"
BUGTRACKER = "https://github.com/g-truc/glm/issues"

SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://copying.txt;md5=4431606d144252143c9c3df384a74cad"

SRC_URI = "git://github.com/g-truc/glm;protocol=https"

SRCREV = "5dcc56489e1b66dfd5bca751fa9b8dc68059e008"

S = "${WORKDIR}/git"

inherit cmake

FILES_${PN}-dev += "${libdir}/cmake"
RDEPENDS_${PN}-dev = ""

# 170506 BK
# above is exactly as per meta-oe/recipes-graphics/glm/glm_0.9.8.4.bb, copied
# here so as to override meta-office/recipes-support/glm/glm_0.9.8.3.bb which
# has broken do_install. however, do_rootfs fails because there is no 'glm' deb,
# as only have files in -dev deb. so, do this hack...
do_install_append () {
    mkdir -p ${D}/usr/bin
    echo 'dummy file to force OE to create a glm deb' > ${D}/usr/bin/glm-do-nothing-file
}
