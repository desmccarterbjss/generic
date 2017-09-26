#Author: michael.umenyiora@bjss.com
#Feature: Shift History
#
@shifthistory
Feature: Shift History


  Background: Capture and submit stream 
    Given the user has captured traffic transaction "qa01.testuser" "1234" "Aberdeen Mail Centre" "IPS - L" "DSA" "Manual"
    When the user selects the submit button

  @PDAPTT-34 @sprint7 @scenario1 @regression
  Scenario: Navigating to Shift History
    Given The user selects shift history
    Then The app should take the user to the shift history page

  @PDAPTT-34 @sprint7 @scenario2 @regression
  Scenario: Viewing Shift History
    Given The user selects shift history
    Then page should display a list of traffic capture transactions

  @PDAPTT-34 @sprint7 @scenario3 @regression
  Scenario: Shift History restriction
    Given The user selects shift history
    And The page should only display a list of traffic capture transactions submitted in the last hour
    Then The most recent submissions should be at the top of the list

  @PDAPTT-45 @sprint7 @scenario1 @test @regression
  Scenario: Select Record to Delete
    Given The user selects shift history
    And The user long presses a record on the screen
    Then The screen should be in delete mode

  @PDAPTT-45 @sprint7 @scenario2 @test @regression
  Scenario: Delete Mode
    Given The user selects shift history
    And The user long presses a record on the screen
    Then The history screen should include check boxes, a cancel button and a delete button

  @PDAPTT-45 @sprint7 @scenario3 @test @regression
  Scenario: Delete a record
    Given The user selects shift history
    And The user long presses a record on the screen
    And The user has selects history delete button
    Then The record should be deleted from the PDA history

  @PDAPTT-45 @sprint7 @scenario4 @regression
  Scenario: Cancel
    Given The user selects shift history
    And The user long presses a record on the screen
    And The user selects the cancel button
    Then The app should take the user to the shift history page
    