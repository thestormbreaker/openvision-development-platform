MODULE = "OpenAirPlay"
DESCRIPTION = "AirPlay and AirTunes server for enigma2"
RDEPENDS_${PN} = "python3-twisted-core python3-twisted-web python3-m2crypto \
                  python3-biplist python3-netclient python3-avahi python3-dbus \
                  python3-core python3-io python3-xmlrpc \
                  hairtunes"

inherit gitpkgv

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins.inc

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/${MODULE}"
do_install() {
	install -d ${D}${PLUGINPATH}
	cp -r --preserve=mode,links ${S}/plugin/* ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"
