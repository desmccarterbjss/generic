# AUTHOR	: Des McCarter @ BJSS
# DATE		: 26/09/2017
# DESCRIPTION	: Executes regression tests based on cucumber criteria sprint1, ...., sprintn

SPRINT_NUMBERS="1 2 3 4 5 6 7 8 9" 

# Point to APK that needs testing ...
APK="${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/apks/25092017/1.0.1/app-sit.apk"

# Point to environment in which tests will be executed in ...
TEST_ENVIRONMENT="sit"

# Execute sprint tests ...
for sprintnumber in ${SPRINT_NUMBERS}
do
	${ROYALMAIL_PROJECT_FOLDER}/scripts/runcriteria.sh -environment sit --git-checkout-apk --run-against-physical-device -test-criteria "sprint${sprintnumber}" -apk "${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/apks/25092017/1.0.1/app-qa.apk"
done
