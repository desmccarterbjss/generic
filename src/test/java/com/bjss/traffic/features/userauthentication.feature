#Author: michael.umenyiora.com
#Feature: User Authentication.
#Scenario: User Login
#Scenario: Pre-login positive validation
#Scenario: Pre-login negative validation
#Scenario: User Login successful
#Scenario: User Login invalid user id
#Scenario: User Logout
#Scenario: User Login invalid pin
#Scenario: Capture Site Location Name 
#Scenario: Capture Work Area
#Scenario: Shift Details full entry
#Scenario: Shift Details partial entry
#
@userauthentication 
Feature: User Authentication 

@PDAPTT-153 @sprint1 @check @regression
Scenario Outline: User Login invalid user id
	Given User is not already logged in 
	When User enters an invalid user ID "<user ID>"  
	And User enters their "<pin>" 
	And User proceeds to login 
	Then User should not be logged on 
		
	Examples: login data
		|user ID|pin |
		|tester|1234|
	
@PDAPTT-153 @sprint1 
Scenario Outline: User Login invalid pin
	Given User is not already logged in 
	When User enters their unique "<user ID>"  
	And User enters an invalid pin "<pin>" 
	And User proceeds to login 
	Then User should not be logged on 
		
	Examples: login data
		|user ID|pin|
		|qa01.testuser|123456|
			
@PDAPTT-153 @sprint1 @regression
Scenario Outline: User Login successful
	Given User is not already logged in 
	When User enters their unique "<user ID>" 
	And User enters their "<pin>" 
	And User proceeds to login 
	Then User should be logged in successfully 

Examples: login data
		|user ID|pin|
		|qa01.testuser|1234|
		|qa02.testuser|2345|
		|qa03.testuser|3456|
		
		

@PDAPTT-121 @sprint1 @logout @regression
Scenario Outline: User Logout 
	Given User is not already logged in 
	When User enters their unique "<user ID>" 
	And User enters their "<pin>" 
	And User proceeds to login 
	And The user logs out
	Then User should return to the login screen 
	
	Examples: login data
		|user ID|pin|
		|qa01.testuser|1234|

@PDAPTT-155 @sprint1 
Scenario: Pre-login negative validation 
	Given User is not already logged in 
	When The user keeps username blank 
	And The user enters atleast one digit pin 
	Then Login button should be disabled 

@PDAPTT-155 @sprint1 
Scenario: Pre-login negative validation 
	Given User is not already logged in 
	When The user enters atleast one character username 
	And The user keeps pin blank 
	Then Login button should be disabled 
	
@PDAPTT-155 @sprint1 
Scenario: Pre-login positive validation 
	Given User is not already logged in 
	When The user enters atleast one character username 
	And The user enters atleast one digit pin 
	Then Login button should be enabled 
	



@PDAPTT-55 @wip 
Scenario: Capture User ID 
	Given The user is logged in 
	When The the User ID is captured 
	Then All transactions should be associated with the user identity 
	
@PDAPTT-120 @wip 
Scenario: Failed Login less than three attempts 
	Given User is not already logged in 
	When User has entered their login details 
	And The login is unsuccessful 
	And The user attempts to login again 
	Then The screen should display a failed login message 
	And Remain on the screen until login is successful 
	
@PDAPTT-120 @wip 
Scenario: Failed Login three attempts 
	Given User is not already logged in 
	When User has entered their login details 
	And The login is unsuccessful 
	And The user fails login three times 
	Then The screen should display a blocked login message 
	
		
	