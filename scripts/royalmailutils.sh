#!/bin/bash

# We need the ROYALMAIL_PROJECT_FOLDER environment variable set before
# we continue (must be set within ~/.bashrc) ...

# Check ROYALMAIL_PROJECT_FOLDER set ...


if [ "a${ROYALMAIL_PROJECT_FOLDER}" = "a" ]
then
	echo "[ERR] ROYALMAIL_PROJECT_FOLDER environment variable not set. This needs to be set to the absolute folder name containing the test POM"
	exit 1
fi

# Check that folder exists ...

if [ ! -d "${ROYALMAIL_PROJECT_FOLDER}" ]
then
	echo "[ERR] Royal Mail Project Folder ${ROYALMAIL_PROJECT_FOLDER} does not exist."
	exit 1
fi

# Check that folder contains POM ...
if [ ! -f "${ROYALMAIL_PROJECT_FOLDER}/pom.xml" ]
then
	echo "[ERR] Royal Mail Project POM does not exist in ${ROYALMAIL_PROJECT_FOLDER}"
	exit 1
fi

function getRoyalMailProjectFolderWindows(){
	echo ${1} | sed s/"^\/\([^\/]*\)"/"\1:"/g | sed s/"\/"/"\\\\"/g | tr "[a-z]" "[A-Z]"
}

export ROYALMAIL_PROJECT_FOLDER_WINDOWS="`getRoyalMailProjectFolderWindows ${ROYALMAIL_PROJECT_FOLDER}`"
export ROYALMAIL_PROPERTIES="${ROYALMAIL_PROJECT_FOLDER}/src/test/resources/royalmail.properties"

function GetProperty(){

	file="${1}"
	property="${2}"

	if [ "a${file}" = "a" ]
	then
		echo "[ERR] Property file not given"
		exit 1
	fi

	if [ "a${property}" = "a" ]
	then
		echo "[ERR] Property not given"
		exit 1
	fi

	cat "${file}" | sed -n s/"^[ ]*$property=[ ]*[\"]*\(.*\)\"*$"/"\1"/p
}

function GetApkLocation(){
	GetProperty "${ROYALMAIL_PROPERTIES}" "app.src"
}

function GetAppId(){
	GetProperty "${ROYALMAIL_PROPERTIES}" "app.id"
}

function GetTestEnvironment(){
	GetProperty "${ROYALMAIL_PROPERTIES}" "test.environment"
}

if [ "a${UTIL_INIT}" = "a" ]
then
	echo "[INFO] Project Folder		:${ROYALMAIL_PROJECT_FOLDER} (${ROYALMAIL_PROJECT_FOLDER_WINDOWS})"

	export UTIL_INIT="done"
fi
