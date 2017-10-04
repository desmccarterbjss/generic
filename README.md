Author		:		Des McCarter @ BJSS
Date		:		11/09/2017
Description : TMA Functional Test Framework - Installation and Execution guide

Pre-requisits:

	1. Maven			- https://maven.apache.org/download.cgi?Preferred=ftp%3A%2F%2Fmirror.reverse.net%2Fpub%2Fapache%2F
	2. Java SDK (8+)	- https://java.com/en/download/win10.jsp
	3. GIT Client		- https://git-scm.com/download/win
	4. Android Studio 	- https://developer.android.com/studio/index.html

Notes:

	1. Only works on Windows using GIT Bash (i.e. I have not attempted to use this framework either with Cygwin or raw linux based bash).

	2. This framework predominately uses the Nexus_4_API_19 emulator to test. This means that you will have to create one (
	   if you haven't already) within Android Studio. If this emulator does not exist then the framework will pickup the
	   last created emulator and will attempt to use it. Emulators other than the one suggested do not work (at least
	   all the way through test execution) so it is advised that (before you attempt to run any tests) that the Nexus_4_API_19
	   emulator exists.
		
Set-up steps:

	At this point we are assuming that:
	
	a. Maven is installed with environment variables configured correctly (as per standard guidelines).
	b. Java SDK (8+) is installed with environment variables configured correctly (as per standard guidelines).
	c. GIT Client is installed.
	d. Android Studio is installed
	e. An APK is available to test.
	
	Steps:

	a. Execute GIT Bash

	b. Clone this project:

		git clone https://github.com/desmccarterbjss/other

	Using GIT bash ...
	
	c. Change directory to cloned folder:
	
		cd other/rm
	
	d. Run initialisation script (this script will only work if you are in the rm folder, i.e. folder where pom.xml exists)
	
		./scripts/init.sh 

	   This script will initialise your cloned project, including setting up necessary environment variables.
	
	e. Import your new bashrc variables into current shell:
	
		. ~/.bashrc
	
	Your ~/.bashrc should now have entries similar to the following:
	

	export ANDROID_TOOLS="${HOME}/AppData/Local/Android/sdk/tools"
	export PATH="${PATH}:${ANDROID_TOOLS}"
	export ROYALMAIL_PROJECT_FOLDER="/c/Users/des.mccarter/projects/other/rm"
	export PATH="${PATH}:${ROYALMAIL_PROJECT_FOLDER}/scripts"
	export ANDROID_HOME="c:\Users\des.mccarter\AppData\Local\Android\sdk"

Testing your installation:

	After executing the scripts/init.sh script (i.e. after initialising your cloned project) you should then be in the position
	to begin running tests. To verify that this is the case then:

	a. Open a GIT Bash instance.

	b. Go to the root folder of your cloned project. (e.g. if you cloned in a folder named ~projects then "cd ~/projects/rm).

	c. Run the scripts/verifyframework.sh script.

	   This will fire up an emulator using a sample (QA) APK file (which exists in src/test/resources/apks) and will execute 
	   short set of sanity tests. If the emulator picked by the framework is not Nexus_4_API_19 then it is likely that
	   some (if not all) tests will fail but the things to look out for are:

	   (i) The Android Emulator is fired up
	   (ii) The framework generates a test build (using Maven)
	   (iii) There is active clicking and submitting of information on the selected Emulator

Running tests:

	Tests are executed using the scripts/runtests.sh script. This script a. executes Selendroid standalone
	b. starts the emulator (optional) and c. runs the specified (by category) tests. If no option is
	supplied specifying a category of tests, then the default category is regression.
	
	Since the scripts folder is now part of your PATH, runregression.sh can be run from any folder within your bash instance.
	
	To run regression:
	
		We execute regression using the script/runregression.sh script. It requires that you specify the environment to which you need to execute regression against,
		using the -test-environment flag.
		
		Example - execute entire regression against SIT environment on android emulator:
		
			runregression.sh -test-environment sit
			
		Example - execute entire regression against SIT environment on physical Android Device:
		
			runregression.sh -test-environment sit --run-against-physical-device
	
	A few notes:
	
	a. To successfully run tests against an emulator, TMA requires that you connected to the RMG wifi network.
	b. If the "--run-against-physical-device" flag is NOT given then the framework will automatically fire up the emulator.
	c. If the "--run-against-physical-device" flag IS given then the framework will assume that you have the device connected via USB.
	d. "Full Regression", in cucumber terms, are all test scenarios having categories @sprint1, @sprint2, ..., @sprint9 tags.
	e. Location of APK being tested and additional information (e.g. Maven/Selendroid app ID etc) are all stored within src/test/resources/royalmail.properties.
	f. The -test-environment switch of runregression.sh will automatically take environment info (e.g. usernames etc) from src/test/resources/environments.
	g. The -test-environment flag is MANDATORY.
	
	How to run Selendroid standalone on its own:
	
	Type in the following in bash to run selendroid standalone only (in the root cloned folder):
	
		a. . ./scripts/startselendroid.sh (execute this line only once in your bash instance)
		b. runSelendroid <location to APK file>
		
	To make sure selendroid is running successfully then check the log file /tmp/selendroid.log.
	
	How to run the emulator on its own:
	
	Type in the following in bash to run the emulator only (in the root cloned folder):
		
	. runemulator.sh (execute this line only once in your bash instance)
	runEmulator
	
Folders:

	1.	src/test/java		- where the physical tests live
	2.	src/test/resources	- where all test resources are centrally configured

		i.	src/test/resources/websphere 	- WebSphere library
		ii	src/test/resources/selendroid	- Selendroid standalone
		iii	src/test/resources/royalmail.properties	- All project properties are set here
		iv  src/test/resources/apks			- Where the latest APK's are located
		v   src/test/resources/environments	- Where environment specific properties are located
		
	3. scripts				- where all scripts live, including runregression.sh.
	
