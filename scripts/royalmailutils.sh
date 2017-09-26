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

echo "[INFO] Project Folder		:${ROYALMAIL_PROJECT_FOLDER} (${ROYALMAIL_PROJECT_FOLDER_WINDOWS})"
