# AUTHOR 	: Des McCarter @ BJSS
# DATE		: 12/09/2017
# DESCRIPTION	: This script needs to be executed (only once) 
#		  once you have cloned the Royal Mail Test Project

function VerifyScriptLocation(){

	# Make sure we are within the root folder
	# of the test project ...

	if [ ! -d src/test/java/com/bjss/traffic ]
	then
		echo "[ERR] Please re-run this script from the root location of the cloned project"
		exit 1
	fi
}

VerifyScriptLocation

# Set the scripts folder in 
# PATH in bashrc ...

function GetProjectFolderExport(){
	cat ~/.bashrc | grep "^export[ ]*ROYALMAIL_PROJECT_FOLDER" | grep "${ROYALMAIL_PROJECT_FOLDER}"
}

function GetScriptPathExport(){
	cat ~/.bashrc | grep "^export[ ]*PATH" | grep "ROYALMAIL_PROJECT_FOLDER"
}

function GetAndroidToolsPathExport(){
	cat ~/.bashrc | grep "^export[ ]*PATH" | grep "ANDROID_TOOLS"
}

function GetAndroidHomeExport(){
	cat ~/.bashrc | grep "^export[ ]*ANDROID_HOME"
}

function GetAndroidToolsExport(){
	cat ~/.bashrc | grep "^export[ ]*ANDROID_TOOLS"
}

function GetMavenLocation(){
	if [ ! -d "c:\\Program Files (x86)\\Maven" ]
	then
		echo "[ERR] No maven installed."
		echo "	    1. Please create Maven folder c:\\Program Files (x86)\\Maven"
		echo "	    2. Please install Maven (in a sub folder of c:\\Progream Files (x86)\\Maven)"
		exit 1
	else
		echo "c:\\Program Files (x86)\\Maven"
	fi
}

# Make sure ~/.bashrc exists ...

if [ ! -f ~/.bashrc ]
then
	> ~/.bashrc
fi

ANDROID_TOOLS_EXPORT="`GetAndroidToolsExport`"
ANDROID_TOOLS_PATH_EXPORT="`GetAndroidToolsPathExport`"
PROJECT_FOLDER_EXPORT="`GetProjectFolderExport`"
SCRIPT_PATH_EXPORT="`GetScriptPathExport`"

# Add export of ANDROID_TOOLS 
# to ~/.bashrc ...

if [ "a${ANDROID_TOOLS_EXPORT}" = "a" ]
then
	echo "export ANDROID_TOOLS=\"\${HOME}/AppData/Local/Android/sdk/tools\"" >> ~/.bashrc
fi

# Add ANDROID_TOOLS to the PATH environment variable
# to ~/.bashrc ...

if [ "a${ANDROID_TOOLS_PATH_EXPORT}" = "a" ]
then
	echo "export PATH=\"\${PATH}:\${ANDROID_TOOLS}\"" >> ~/.bashrc
fi

# Add export of ROYALMAIL_PROJECT_FOLDER
# to ~/.bashrc ...

if [ "a${PROJECT_FOLDER_EXPORT}" = "a" ]
then
	echo "export ROYALMAIL_PROJECT_FOLDER=\"`pwd`\"" >> ~/.bashrc
fi

# Add projects scripts folder to PATH
# in ~/.bashrc ...

if [ "a${SCRIPT_PATH_EXPORT}" = "a" ]
then
	echo "export PATH=\"\${PATH}:\${ROYALMAIL_PROJECT_FOLDER}/scripts\"" >> ~/.bashrc
fi

# Add ANDROID_HOME variable
# in ~/.bashrc ...

if [ "a`GetAndroidHomeExport`" = "a" ]
then
	echo "${HOME}\\AppData\\Local\\Android\\sdk" | sed s/"^\/\([^\/]*\)\(.*\)$"/"\1:\2"/g | sed s/"\/"/"\\\\"/g | sed s/"^\(.*\)$"/"export ANDROID_HOME=\"\1\""/g >> ~/.bashrc
fi

. ~/.bashrc
