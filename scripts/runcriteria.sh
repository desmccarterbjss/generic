. "${ROYALMAIL_PROJECT_FOLDER}/scripts/royalmailutils.sh"

SITE="${ROYALMAIL_PROJECT_FOLDER}/target/site"

# Tests are run against emulator by default ...
RUN_AGAINST_PHYSICAL_DEVICE="false"
CHECKOUT_APK="false"

unset RUN_SELENDROID

function prepareTestRun(){
	if [ -d "${SITE}" ]
	then
		echo "[INFO] Cleaning site ..."
	fi
}

function processArgs(){
	while [ ! "a${1}" = "a" ]
	do
		if [ "${1}" = "-test-criteria" ]
		then
			shift
	
			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -test-critera flag requires criteria of tests to run, e.g. -test-criteria 'sprint1' ... "
				exit 1
			fi
	
			CRITERIA="${1}"
		elif [ "${1}" = "--git-checkout-apk" ]
		then
			CHECKOUT_APK=true
		elif [ "${1}" = "--usage" ]
		then
			usage
			exit 0
		elif [ "${1}" = "--run-selendroid" ]
		then
			RUN_SELENDROID=" ${1} "
		elif [ "${1}" = "--run-against-physical-device" ]
		then
			RUN_AGAINST_PHYSICAL_DEVICE=true
		elif [ "${1}" = "-environment" ]
		then
			shift
	
			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -environment flag requires an environment, e.g. -apk 'qa' or -apk 'sit' or -apk 'pre-prod' ... "
				exit 1
			fi
	
			TEST_ENVIRONMENT="${1}"
		elif [ "${1}" = "-apk" ]
		then
			shift
	
			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -apk flag requires apk location, e.g. -apk '~/temp/test-qa.apk' ... "
				exit 1
			fi
	
			APK="${1}"
		else
			echo "Unknown argument ${1}"
			exit 1
		fi
	
		shift
	done
}

function usage(){
	echo "[INFO] Usage: `basename ${0}` -test-criteria '<criteria>' -apk '<path to API file>' [--run-against-physical-device] [--git-checkout-apk]"
	echo "[INFO]        Arguments in square brackets [...] are optional"
}

function checkArgs(){
	if [ "a${CRITERIA}" = "a" ]
	then
		echo "[ERR] Criteria not set."
	
		usage
	
		exit 1
	fi
	
	if [ "a${APK}" = "a" ]
	then
		echo "[ERR] APK file location not set."
	
		usage
	
		exit 1
	fi
	
	echo "[INFO] Test Criteria is ${CRITERIA}"
	echo "[INFO] APK under test is ${APK}"
}

function tidyReports(){
	if [ -d "${SITE}" ]
	then
		OUTPUT_FOLDER=~/testresults/`date +%F`
	
		cd "${SITE}"
	
		tar -cvpf ~/"${CRITERIA}.tar" *
	
		if [ ! -d ${OUTPUT_FOLDER}/${CRITERIA} ]
		then
			mkdir -p ${OUTPUT_FOLDER}/${CRITERIA}
		fi
	
		cd ${OUTPUT_FOLDER}/${CRITERIA}
	
		tar -xvpf ~/"${CRITERIA}.tar"
	fi
}

function removePackagesFromDevice(){

	APP_ID="`GetAppId`"

	echo -n "[INFO] Removing existing app ${APP_ID} from PDA device..."

	adb uninstall "${APP_ID}" >/dev/null 2>/dev/null
	adb uninstall "io.selendroid.${APP_ID}" >/dev/null 2>/dev/null

	echo

	echo "[INFO] ${APP_ID} removed from PDA device."
}

function checkoutApk(){
	echo "[INFO] attempting to get fresh copy of APK (${*}) from GIT ..."

	git checkout -- ${*}

	if [ ! "${?}" = 0 ]
	then
		echo "[ERR] Getting fresh copy of APK from GIT repo"

		exit 1
	else
		echo "[INFO] Done."
	fi
}

function pointToEnvironment(){

	ENV="${1}"

	echo "[INFO] Setting environment to \"${ENV}\""

	cat "${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/royalmail.properties" | sed s/"^[ ]*\(test.environment=\).*"/"\1$ENV"/g > /tmp/royalmail.properties

	mv /tmp/royalmail.properties "${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/royalmail.properties"
}


function runTests(){

	if [ "${RUN_AGAINST_PHYSICAL_DEVICE}" = "true" ]
	then
		removePackagesFromDevice

		runtests.sh -apk "${APK}" --run-against-physical-device ${RUN_SELENDROID} -cucumber-options "--tags @${CRITERIA}"
	else
		runtests.sh -apk "${APK}" -run-emulator "Nexus_4_API_19" ${RUN_SELENDROID} -cucumber-options "--tags @${CRITERIA}"
	fi

	tidyReports
}

# Check arguments sent into this script
# and make sure they are valid ...

processArgs $*
checkArgs

# if environment given then
# point to it ...

if [ ! "a${TEST_ENVIRONMENT}" = "a" ]
then
	pointToEnvironment "${TEST_ENVIRONMENT}"
fi


# if user wishes to checkout a fresh APK 
# then do a 'git checokout' of the APK ...

if [ "${CHECKOUT_APK}" = "true" ]
then
	checkoutApk "${APK}"
fi

prepareTestRun

# ... and finally run tests and produce a report ...
runTests
