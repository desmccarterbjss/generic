SITE="${ROYALMAIL_PROJECT_FOLDER}/target/site"

# Tests are run against emulator by default ...
RUN_AGAINST_PHYSICAL_DEVICE="false"

CHECKOUT_APK="false"

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
		elif [ "${1}" = "--run-against-physical-device" ]
		then
			RUN_AGAINST_PHYSICAL_DEVICE=true
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

function checkoutApk(){
	echo "[INFO] attempting to get fresh copy of APK (${APK}) from GIT ..."

	git checkout -- "${*}"

	if [ ! "${?}" = 0 ]
	then
		echo "[ERR] Getting fresh copy of APK from GIT repo"

		exit 1
	else
		echo "[INFO] Done."
	fi
}


function runTests(){

	if [ "${RUN_AGAINST_PHYSICAL_DEVICE}" = "true" ]
	then
		runtests.sh -apk "${APK}" --run-against-physical-device -cucumber-options "--tags @${CRITERIA}"
	else
		runtests.sh -apk "${APK}" -run-emulator "Nexus_4_API_19" -cucumber-options "--tags @${CRITERIA}"
	fi

	tidyReports
}

processArgs $*
checkArgs

if [ "${CHECKOUT_APK}" = "true" ]
then
	checkoutApk "${APK}"
fi

prepareTestRun
runTests
