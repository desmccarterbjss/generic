Author		- Des McCarter @ BJSS
Date		- 11/09/2017
Description	- RM TMA Functional Tests - How to install the TMA Test Framework and execute tests

Pre-requisits:

	1. Maven		- https://maven.apache.org/download.cgi?Preferred=ftp%3A%2F%2Fmirror.reverse.net%2Fpub%2Fapache%2F
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

		git clone https://github.com/desmccarterbjss/generic

	Using GIT bash ...
	
	c. Change directory to cloned folder:
	
		cd rm
	
	d. Run initialisation script (this script will only work if you are in the rm folder, i.e. folder where pom.xml exists)
	
		./scripts/init.sh 

	   This script will initialise your cloned project, including setting up necessary environment variables.
	
	e. Import your new bashrc variables into current shell:
	
		. ~/.bashrc
	
	Your ~/.bashrc should now have entries similar to the following:
	

	export ROYALMAIL_PROJECT_FOLDER="/c/Users/des.mccarter/projects/rm"
	export PATH="${PATH}:${ROYALMAIL_PROJECT_FOLDER}/scripts"
	export MAVEN_HOME="c:\\Program\ Files\ (x86)\\Maven\\apache-maven-3.5.0\\bin\\mvn"
	export PATH="${PATH}:${MAVEN_HOME}"
	export ANDROID_TOOLS="${HOME}/AppData/Local/Android/sdk/tools"
	export PATH="${PATH}:${ANDROID_TOOLS}"
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
	
	Since the scripts folder is now part of your PATH, runtests.sh can be run from any folder within your bash instance.
	
	a. To run regression:
	
		runtests.sh
	
	b. To run tests but fire up an emulator beforehand:
	
		runtests.sh -run-emulator "Nexus_4_API_19"
	
	c. To do 'b.' but against a specific category of tests (e.g. sprint3):
	
		runtests.sh -run-emulator "Nexus_4_API_19" -cucumber-options "--tags @sprint3"
		
		... where '@sprint3' represents a specific category of (Cucumber) test features
		
	
	How to run Selendroid standalone on its own:
	
	Type in the following in bash to run selendroid standalone only (in the root cloned folder):
	
		a. . ./scripts/startselendroid.sh (execute this line only once in your bash instance)
		b. runSelendroid
		
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

	3. scripts				- where all scripts live
