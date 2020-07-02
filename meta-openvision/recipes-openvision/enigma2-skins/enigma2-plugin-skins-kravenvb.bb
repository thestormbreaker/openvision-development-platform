SUMMARY = "Kraven VB skin for Enigma2"
MAINTAINER = "Team Kraven"
SECTION = "misc"
PRIORITY = "optional"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "python3-imaging python3-requests python3-xml enigma2-plugin-systemplugins-mphelp"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/KravenHD/KravenVB.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/* ${sysconfdir}/*"

require skin-data.inc
require skin-python.inc

do_postrm_append() {
#!/bin/sh
rm -rf ${datadir}/enigma2/KravenVB
rm -rf ${libdir}/enigma2/python/Plugins/Extensions/KravenVB
rm -rf ${libdir}/enigma2/python/Components/Converter/KravenVB*
rm -rf ${libdir}/enigma2/python/Components/Renderer/KravenVB*
echo "                                                          "
echo "              ...Skin successful removed.                 "
echo "                                                          "
}
