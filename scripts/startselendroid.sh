. "${ROYALMAIL_PROJECT_FOLDER}/scripts/royalmailutils.sh"

# Timeout in 20 seconds ...
START_SELENDROID_TIMEOUT=20

SELENDROID_LOG="/tmp/selendroid.log"

function removePackagesFromDevice(){

	APP_ID="`GetAppId`"

	echo -n "[INFO] Removing existing app ${APP_ID} ..."

	adb uninstall "${APP_ID}" >/dev/null 2>/dev/null
	adb uninstall "io.selendroid.${APP_ID}" >/dev/null 2>/dev/null

	echo

	echo "[INFO] Done."
}

function checkRunning(){

	let COUNT=0

	while [ "${COUNT}" -lt "${START_SELENDROID_TIMEOUT}" ]
	do
		echo "${COUNT}"

		sleep 1

		let COUNT="${COUNT}+1"
	done
}

function runSelendroid(){

	APK_PACKAGE="$*"

	# Make sure we have the APK package name ...

	if [ "a${APK_PACKAGE}" = "a" ]
	then
		echo "[ERR] APK package name not given"
		return 1
	fi


	# Make sure the package exists ...

	if [ ! -f "${APK_PACKAGE}" ]
	then
		echo "[ERR] APK package ${APK_PACKAGE} does not exist"
		return 1
	fi

	# Start selendroid ...

	echo "[INFO] Starting Selendroid with APK ${APK_PACKAGE} ..."

	java \
		-jar "${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/selendroid/selendroid-standalone-0.17.0-with-dependencies.jar" \
		-aut "${APK_PACKAGE}" -logLevel VERBOSE >> "${SELENDROID_LOG}" 2>> "${SELENDROID_LOG}" &

	# Check that we have Selendroid running successfully ...

	#checkRunning

	sleep 10
	
	echo "[INFO] Selendroid started with APK ${APK_PACKAGE}"
}
