#!/bin/bash

# AUTHOR		: Des McCarter @ BJSS
# DATE			: 09/09/2017
# DESCRIPTION		: Trigger seleniod tests


# Notes:
#
# Wehsphere and Selendroid Paths HAVE to be absolute. Since the project path changes, depending on which
# machine this is running on and which user, both these library paths depend on $CURRENT_FOLDER_WINDOWS. This also
# means that this script needs to be run in the root project folder (i.e. folder containing the Maven POM).

# Default maven phases. These are overriden
# with the -maven-args argument

RUN_AGAINST_PHYSICAL_DEVICE="false"

unset RUN_SELENDROID

MAVEN_ARGS="clean surefire-report:report install test site"

# These options are default, but
# can be overriden by '-cucumber-options' 
# argument

CUCUMBER_OPTIONS="--tags @sprint2"

# Function to kill processes 
# by (regex) name ...

function killProcess(){
	processName="${*}"

	PID="`ps x | sed -n s/\"^[ |	]*\([0-9]*\).*$processName\"/\"\1\"/p`"

	if [ ! "a${PID}" = "a" ]
	then
		echo "[INFO] Terminating process [${PID}] (${processName})"

		kill "${PID}"
	fi
}

# Get the last emulator (name) that was created by
# this user ...

function GetDefaultEmulator(){

	# Make sure the users .android folder exists ...
	if [ ! -d "${HOME}/.android/avd" ]
	then
		echo "[ERR] No emulators exist for user ${USERNAME}. Please create at least one emulator to run tests."
		exit 1
	fi

	ls -ld ${HOME}/.android/avd/*.avd | tail -1 | sed s/"^.*\/\([^\/]*\)\.avd$"/"\1"/g
}

function usage(){

	echo "`basename ${0}` [-maven-args \"<maven arguments\"] [-cucumber-options \"<cucumber options>\"] [-run-emulator \"<emulator name>\"] -apk \"<path to APK file>\""
	echo "... where arguments in square brackets [] are optional"
}

# Check for arguments if we have some.
# If so then process them ...

if [ ! "a${*}" = "a" ]
then
	while [ ! "a${1}" = "a" ]
	do
		if [ "${1}" = "-maven-args" ]
		then
			shift

			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -maven-args requires a supplemental argument (e.g. -maven-args \"clean install\")"

				exit 1
			fi

			MAVEN_ARGS="${1}"
		elif [ "${1}" = "--usage" ]
		then
			usage

			exit 0
		elif [ "${1}" = "-apk" ]
		then
			shift

			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -apk flag requires the package name as an argument (e.g. -apk \"app-qa.apk\")"

				exit 1
			fi

			APK_PACKAGE="${1}"
		elif [ "${1}" = "-cucumber-options" ]
		then
			shift

			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -cucumber-options requires a supplemental argument (e.g. -cucumber-options \"--tags @sprint1\")"

				exit 1
			fi

			CUCUMBER_OPTIONS="${1}"
		elif [ "${1}" = "--run-selendroid" ]
		then
			RUN_SELENDROID="true"	
		elif [ "${1}" = "--run-against-physical-device" ]
		then
			RUN_AGAINST_PHYSICAL_DEVICE="true"	
		elif [ "${1}" = "-run-emulator" ]
		then
			shift

			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -run-emulator requires a supplemental argument (e.g. -run-emulator \"Nexus_4_API_19\")"

				exit 1
			fi

			EMULATOR_NAME="${1}"
		else
			echo "[ERR] Invalid argument ${1}"

			usage

			exit 1
		fi

		shift
	done
fi

# Import required scripts ...

. "${ROYALMAIL_PROJECT_FOLDER}/scripts/royalmailutils.sh"
. "${ROYALMAIL_PROJECT_FOLDER}/scripts/runemulator.sh"
. "${ROYALMAIL_PROJECT_FOLDER}/scripts/startselendroid.sh"

# Make sure we have the name/location of the APK supplied ...

if [ "a${APK_PACKAGE}" = "a" ]
then
	echo "[ERR] apk package not supplied ( -apk <package file name> )"
	exit 1
fi

APP_ID="uk.co.royalmail.traffic.qa" 
CSV_PATH="src//test//resources" 
WEBSPHERE_LIB_ROOT="${ROYALMAIL_PROJECT_FOLDER_WINDOWS}\\src\\test\\resources\\websphere\\IBM-MQ-JAR" 
SELENDROID_LIB_ROOT="${ROYALMAIL_PROJECT_FOLDER_WINDOWS}\\src\\test\\java\\com\\bjss\\traffic\\libs" 
FEATURE_PATHS="src/test/java/com/bjss/traffic/features/"


# If we are not running against a physical device but
# the emulator name is NOT given, then execute tests
# against default emulator ...

if [ "a${EMULATOR_NAME}" = "a" ]
then
	if [ "${RUN_AGAINST_PHYSICAL_DEVICE}" = "false" ]
	then
		EMULATOR_NAME="`GetDefaultEmulator`"
	fi
fi

if [ "a${RUN_SELENDROID}" = "atrue" ]
then
	# Kill existing Selendroid (if any) ...
	killProcess "\/c\/Program Files.*\/bin\/java$"

	# Start Selendroid using the APK given ...
	runSelendroid  "${APK_PACKAGE}"
fi

if [ "${RUN_AGAINST_PHYSICAL_DEVICE}" = "false" ]
then
	# Start the emulator ...
	runEmulator "${EMULATOR_NAME}"
fi

# Execute tests ...

mvn -f "${ROYALMAIL_PROJECT_FOLDER}/pom.xml" ${MAVEN_ARGS} -DappId="${APP_ID}" -DappSrc="${APK_PACKAGE}" -Dcsvpath="${CSV_PATH}" -DmqLibDir="${WEBSPHERE_LIB_ROOT}" -Dselendroid="${SELENDROID_LIB_ROOT}" -Dcucumber.options="${FEATURE_PATHS} ${CUCUMBER_OPTIONS}"
