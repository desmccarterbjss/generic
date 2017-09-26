SITE="${ROYALMAIL_PROJECT_FOLDER}/target/site"

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
	
			export CRITERIA="${1}"
		elif [ "${1}" = "-apk" ]
		then
			shift
	
			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -apk flag requires apk location, e.g. -apk '~/temp/test-qa.apk' ... "
				exit 1
			fi
	
			APK="${1}"
		fi
	
		shift
	done
}

function usage(){
	echo "[INFO] Usage: `basename ${0}` -test-criteria '<criteria>' -apk '<path to API file>'"
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

function runTests(){
	runtests.sh -apk "${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/apks/25092017/1.0.1/app-qa.apk" -run-emulator "Nexus_4_API_19" -cucumber-options "--tags @${CRITERIA}"

	tidyReports
}

processArgs $*
checkArgs
prepareTestRun
runTests
