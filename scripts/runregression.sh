# AUTHOR	: Des McCarter @ BJSS
# DATE		: 26/09/2017
# DESCRIPTION	: Executes regression tests based on cucumber criteria sprint1, ...., sprintn or a specific criteria.

# Import some utils ...
. "${ROYALMAIL_PROJECT_FOLDER}"/scripts/royalmailutils.sh

SPRINT_NUMBERS="1 2 3 4 5 6 7 8 9" 

# Point to APK that needs testing 
# (defined in royalmail.properties) ...

APK="${ROYALMAIL_PROJECT_FOLDER}/`GetApkLocation`"

##############
# Show usage #
##############

function usage(){
	echo "[INFO] `basename $0` [--run-against-physical-device] [-test-category <test category>] -test-environment <environment, e.g. qa or sit or preprod>"
	echo "[INFO] where flags in square brackets [] are optional"
}


#####################
# Process arguments #
#####################

function processArgs(){

	while [ ! "a${1}" = "a" ]
	do
		if [ "${1}" = "--run-against-physical-device" ]
		then
			PHYSICAL_DEVICE="true"
		elif [ "${1}" = "--usage" ]
		then
			usage
			exit 0
		elif [ "${1}" = "-test-environment" ]
		then
			shift

			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -environment requires an environment argument (qa/sit/preprod)"
				usage
				exit 1
			fi

			TEST_ENVIRONMENT="${1}"
		elif [ "${1}" = "-test-category" ]
		then
			shift

			if [ "a${1}" = "a" ]
			then
				echo "[ERR] -category requires a list of cucumber test category names"
				usage
				exit 1
			fi

			SPECIFIC_TEST_CRITERIA="${1}"
		else
			echo "[ERR] Unknown flag ${1}"
			usage
			exit 1
		fi
	
		shift
	done

}

###############################
# Execute Sprint[1...n] Tests #
# defined in $SPRINT_NUMBERS  #
# variable.
###############################

function executeSprintScenarios(){
	
	for sprintnumber in ${SPRINT_NUMBERS}
	do
		if [ "a${PHYSICAL_DEVICE}" = "a" ]
		then
			echo "[INFO] Running tests against emulator"

			${ROYALMAIL_PROJECT_FOLDER}/scripts/runcriteria.sh -environment ${TEST_ENVIRONMENT} --git-checkout-apk --run-selendroid -test-criteria "sprint${sprintnumber}" -apk "${APK}"
		else
			echo "[INFO] Running tests against physical device"

			${ROYALMAIL_PROJECT_FOLDER}/scripts/runcriteria.sh -environment ${TEST_ENVIRONMENT} --git-checkout-apk --run-selendroid --run-against-physical-device -test-criteria "sprint${sprintnumber}" -apk "${APK}"
		fi
	done

}

###################
# check arguments #
###################

function checkArgs(){

	# Make sure we have a test environment ...

	if [ "a${TEST_ENVIRONMENT}" = "a" ]
	then
		echo "[ERR] -test-environment flag not set"

		usage

		exit 1
	fi
}

##################################
# Execute specific test criteria #
##################################

function runSpecificScenarios(){
	${ROYALMAIL_PROJECT_FOLDER}/scripts/runcriteria.sh -environment sit --git-checkout-apk --run-against-physical-device -test-criteria "${SPECIFIC_TEST_CRITERIA}" -apk "${APK}"
}

# *** process arguments fed into 
# *** thiis script ....

processArgs $*

# make sure we have all the arguments we need ...
checkArgs

# Execute sprint scenarios, defined in $SPRINT_NUMBERS
# else execute specific test scenarios ...

if [ "a${SPECIFIC_TEST_CRITERIA}" = "a" ]
then
	executeSprintScenarios
else
	runSpecificScenarios
fi
