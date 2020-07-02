DESCRIPTION = "DAB Streamer for Enigma2 using tsniv2ni and modified ni2http"
SECTION = "devel/python"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "www.satdreamgr.com"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit allarch gitpkgv update-rc.d

RDEPENDS_${PN} = "eti-tools python3-core tsniv2ni"

SRC_URI = "git://github.com/satdreamgr/dabstreamer.git"

S = "${WORKDIR}/git/"

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"

PACKAGES = "${PN}"

do_install_append() {
	install -d ${D}${sbindir}
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${S}/dabstreamer ${D}${sysconfdir}/init.d
	ln -sf ${sysconfdir}/init.d/dabstreamer ${D}${sbindir}/dabstreamer
}

FILES_${PN} = "/"

INITSCRIPT_NAME = "dabstreamer"
INITSCRIPT_PARAMS = "defaults 50"
