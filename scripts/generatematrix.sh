# AUTHOR	: Des McCarter @ BJSS
# DATE		: 05/10/2017
# DESCRIPTION	: Generates a Test Matrix of Scenario / automation test case.
# 		  Requires a -outfile <outfile> flag to indicate where data should be output to

FEATURES_FOLDER="${ROYALMAIL_PROJECT_FOLDER}/src/test/java"

# Create output file ...
unset header

IFS=$'\n'

for file in `find "${FEATURES_FOLDER}" -name "*.feature" -print 2>/dev/null`
do
	let count=0

	for featureline in `sed -n -f scenarioandjira.sed "${file}"`
	do
		if [ $((${count}%2))  = 0 ]
		then
			if [[ -z "${header}" ]]
			then
				header="done"

				echo "BDD Scenario,Jira,Feature file"
			fi

			echo -n "${featureline}" | sed s/","/" "/g
		else
			echo ",${featureline},`basename ${file}`"
		fi

		let count="${count}+1"
	done
done
