function runEmulator(){

	if [ ! "a${*}" = "a" ]
	then
		AVD="${*}"
	else
		AVD="Nexus_4_API_19"
	fi

	if [ ! -d "${HOME}/.android/avd/${AVD}.avd" ]
	then
		echo "[ERR] Emulator \"${AVD}\" does not exist"
		echo "Possible emulators are :"

		ls -ld ${HOME}/.android/avd/*.avd | sed s/"^.*\/\([^\/]*\)\.avd$"/"\1"/g

		exit 1
	fi

	echo "[INFO] Starting Emulator ${AVD}"

	nohup "${HOME}/AppData/Local/Android/sdk/emulator/emulator.exe" -avd "${AVD}" >/dev/null 2>/dev/null &

	# Wait for Emulator to startp-up ...

	sleep 20

	echo "[INFO] Done."
}
