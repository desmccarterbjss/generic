# AUTHOR	: Des McCarter @ BJSS
# DATE		: 26/09/2017
# DESCRIPTION	: Executes regression tests based on cucumber criteria sprint1, ...., sprintn

SPRINT_NUMBERS="1 2 3 4 5 6 7 8 9" 

for sprintnumber in ${SPRINT_NUMBERS}
do
	${ROYALMAIL_PROJECT_FOLDER}/scripts/runcriteria.sh -test-criteria "sprint${sprintnumber}" -apk "${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/apks/25092017/1.0.1/app-qa.apk"
done
