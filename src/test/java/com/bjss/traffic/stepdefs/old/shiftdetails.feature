#Author: michael.umenyiora@bjss.com
#Feature: Shift Detail.
#Scenario: Capture the userid of the traffic recorder.
#Scenario: Derive Shift Type from Current Time
#Scenario: Override Shift Field
#Scenario: Session Parameter - Site Name
#Scenario: Session Parameter - Work Area
#Scenario: Remember previous session parameters
#Scenario: Derive Site Location
#
@shiftdetails 
Feature: Shift Details 

@pdaptt-7 @wip 
Scenario: Derive Shift Type from Current Time 
	Given The user is logged in 
	When user stars a data capture transaction 
	Then the shift field should be inferred from the current time 
	
@pdaptt-8 @wip 
Scenario: Override Shift Field 
	Given The user is logged in 
	When the shift field has been autopopulated 
	Then the user can override the shift time. 
	
@pdaptt-2 @wip 
Scenario: Session Parameter - Site Name 
	Given The user is logged in 
	When The user starts a data capture transaction 
	Then They should be able to view and select a list of site names 
	
@pdaptt-11 @wip 
Scenario: Session Parameter - Work Area 
	Given the user is logged on 
	When The user starts a data capture transaction 
	Then They should be able to view and select a list of work areas based on the site selected 
	
@pdaptt-79 @wip 
Scenario: Remember previous session parameters 
	Given The user is logged in 
	When the user starts a data capture action 
	And is completing the session parameters 
	Then the app should remember the previous session parameters entered 
	And auto-populate the fields 
	
@pdaptt-6 @wip 
Scenario: Derive Site Location 
	Given The user is logged in 
	When the user starts a data capture action 
	And is completing the site field 
	Then the app should determine user location 
	And populate with the associated site 
