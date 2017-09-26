#Author: michael.umenyiora@bjss.com
#Feature: Capture Attributes.
#Scenario: Capture User Id.
#Scenario: Capture Date and Time
#Scenario: Attribute Set - Payment
#Scenario: Attribute Set - Sub Mail Type
#Scenario: Attribute Set - Mail Item Class
#Scenario: Attribute Set- Container Type (Barcode Unavailable)
#Scenario: Attribute Set- Container Type (Barcode Available)
#Scenario: Validate Entry Attribute Set
#Scenario: Validate Attribute Set
#Scenario: Derive ACF from entered Attributes
#Scenario: Display ACF Count
#
#Shift Details is now known as Work Area
@captureattributes
Feature: Capture Attributes

  @pdaptt-2 @sprint1 @sitelocation
  Scenario Outline: Capture Site Location Name
    Given The user has logged on with their username "<user ID>" and pin "<pin>"
    When The user is on the shift details page
    Then They should be able to view a list of site location names
    And Select the site location name they are working from

    Examples: login data
      | user ID       | pin  |
      | qa01.testuser | 1234 |

  @pdaptt-11 @sprint1
  Scenario Outline: Capture Work Area
    Given The user has logged on with their username "<user ID>" and pin "<pin>"
    When The user is on the shift details page
    Then They should be able to view a list of work area names
    And select the appropriate work area based on reference data

    Examples: login data
      | user ID       | pin  |
      | qa01.testuser | 1234 |

  @PDAPTT-256 @sprint1 @regression
  Scenario Outline: Shift Details (Work Area) full entry
    Given The user has logged on with their username "<user ID>" and pin "<pin>"
    When The user is on the shift details page
    And The user selects full shift details
    Then The confirm button should be enabled

    Examples: login data
      | user ID       | pin  |
      | qa01.testuser | 1234 |

  @PDAPTT-256 @sprint1 @regression
  Scenario Outline: Shift Details (Work Area) partial entry
    Given The user has logged on with their username "<user ID>" and pin "<pin>"
    When The user is on the shift details page
    And The user partially selects shift details
    Then The confirm button should be disabled

    Examples: login data
      | user ID       | pin  |
      | qa01.testuser | 1234 |

  @PDAPTT-159 @sprint1
  Scenario Outline: Mail Formats should match selected work area
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user is on the shift details page
    And The user has selected a "<work area>"
    And The user is in the capture attributes page
    Then The mail format options should be derived by the "<work area id>"

    Examples: work area data
      | work area | work area id |
      | Conc Out  |      1000068 |

  @PDAPTT-159 @sprint1
  Scenario Outline: Single Mail Formats should be auto selected
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user has selected a "<work area>"
    And The mail format only has one option
    Then It should be selected by default

    Examples: work area data
      | work area |
      | OPS - L   |

  @PDAPTT-12 @sprint1 @test
  Scenario Outline: Attribute Set - Mail Item Class is more than one
    Given The user has logged on with their "qa01.testuser" and "1234"
    When Mail format has been completed for "<work area>" and "<mail format>"
    Then User should be able to view a list of mail item classes for "<work area id>" and "<mail format>"

    Examples: work area data
      | work area | work area id | mail format |
      | OPS - L   |      1000081 | LETTER      |

  @PDAPTT-12 @sprint1 @test
  Scenario Outline: Attribute Set - Mail Item Class is one
    Given The user has logged on with their "qa01.testuser" and "1234"
    When Mail format has been completed for only "<work area>"
    Then The mail item class should be automatically populated with "<mail class>"

    Examples: work area data
      | work area | work area id | mail format | mail class     |
      | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE |

  @PDAPTT-13 @sprint1 @test
  Scenario Outline: Attribute Set - Payment type more than one
    Given The user has logged on with their "qa01.testuser" and "1234"
    When Mail format has been completed for only "<work area>"
    Then They should be able to view "<payment type>" payment types and select

    Examples: work area data
      | work area | mail format | mail class     | payment type |
      | IPS - L   | LETTERS     | NOT APPLICABLE | DSA          |

  @PDAPTT-10 @sprint2
  Scenario Outline: View list of SubMail Types
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required fields "<work area>" "<payment type>"
    Then The user can view the selectable list of SubMail Types "<work area id>" "<mail format>" "<mail class>" "<payment type>"

    Examples: work area data
      | work area | work area id | mail format | mail class     | payment type |
      | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          |

  @PDAPTT-10 @sprint2
  Scenario Outline: Single SubMail Types
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required fields "<work area>" "<payment type>" "<mail class>"
    Then Submail Type should be automatically populated with "<Sub Mail Type>"

    Examples: work area data
      | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | OPS - P   |      1000081 | LETTER      | 1ST CLASS  | METER        | Manual        |

  @PDAPTT-10 @sprint2
  Scenario Outline: Workarea with Single SubMail Type
    Given The user has logged on with their "qa01.testuser" and "1234"
    And The user has selected a "<work area>"
    Then Submail Type should be automatically populated with "<Sub Mail Type>"

    Examples: work area data
      | work area | work area id | mail format    | mail class     | payment type | Sub Mail Type |
      | IPS - MP  |      1000075 | Medium Parcels | NOT APPLICABLE | STL          | MEDIUM        |

  @pdaptt-55 @sprint2 @regression
  Scenario Outline: Capture User Id
    Given The user has logged on with their "qa01.testuser" and "1234"
    Then The user id should be available in the menu

  @PDAPTT-168 @sprint2 @regression
  Scenario Outline: Attribute Set - Single Stream Name
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    Then Stream name should be automatically populated "<work area id>" "<payment type>" "<Sub Mail Type>"

    Examples: work area data
      | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        |

  @PDAPTT-178 @sprint2 @regression
  Scenario Outline: Capture Destination Location (Conc Out)
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    Then The destination location dropdown should be present on page capture attributes page

    Examples: work area data
      | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | Conc Out  |      1000073 | LETTER      | 2ND CLASS  | METER        | MANUAL        |

  @PDAPTT-178 @sprint2 @regression
  Scenario Outline: Capture Destination Location Selection (Conc Out)
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    And The traffic recorder makes a selection
    Then the selection should populate the destination field

    Examples: work area data
      | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | Conc Out  |      1000073 | LETTER      | 2ND CLASS  | METER        | MANUAL        |

  @PDAPTT-137 @sprint2 @regression @test1
  Scenario Outline: User selects Intercept Direct
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    Then A Delivery office dropdown should be present on page

    Examples: work area data
      | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | Conc Out  |      1000073 | LETTER      | 2ND CLASS  | METER        | MANUAL        |

  @PDAPTT-137 @sprint2 @regression @test2
  Scenario Outline: Delivery offices derived from site location
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    Then The a Delivery office dropdown selection should be derived by site location "<mail format>" "<Sub Mail Type>"

    Examples: work area data
      | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | Conc Out  |      1000073 | LETTER      | 2ND CLASS  | METER        | MANUAL        |

  @PDAPTT-137 @test @sprint2 @test3
  Scenario Outline: Delivery office populated by selection
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    And The traffic recorder selects a delivery office "<mail format>" "<Sub Mail Type>"
    Then The selection should populate the field

    Examples: work area data
      | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | Conc Out  |      1000073 | LETTER      | 2ND CLASS  | METER        | MANUAL        |

  @PDAPTT-405 @sprint3
  Scenario Outline: Visibility of Scan Barcode and Abnormal Posting Button (IPS - L)
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    Then The Traffic recorder should be able to select Scan Containers or Abnormal Posting button

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        |

  @PDAPTT-405 @sprint3
  Scenario Outline: Visibility of Scan Barcode and Abnormal Posting Button (Intercept)
    Given The user has logged on with their "<username>" and "<password>"
    When The user has selected a location "<site location>" and workarea "<work area>"
    And The traffic recorder selects an intercept delivery office "<mail format>" "<Sub Mail Type>"
    Then The Traffic recorder should be able to select Scan Containers or Abnormal Posting button

    Examples: 
      | username      | password | site location        | work area | sub work area    | mail format | Sub Mail Type |
      | qa01.testuser |     1234 | Aberdeen Mail Centre | Intercept | Intercept Direct | LETTER      | DSA           |

  @PDAPTT-405 @sprint3
  Scenario Outline: Visibility of Scan Barcode and Abnormal Posting Button (Conc Out)
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    And The traffic recorder makes a selection
    Then The Traffic recorder should be able to select Scan Containers or Abnormal Posting button

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | Conc Out  |      1000073 | LETTER      | 2ND CLASS  | METER        | MANUAL        |

  @PDAPTT-375 @sprint3 @regression @test
  Scenario Outline: Capture Attributes validate back button for "<work area>"
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user selects the back button on the physical device
    Then All "<work area>" attributes on the page should clear except the default attributes when the page first loads

    Examples: work area data
      | username      | password | work area | work area id | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | DSA          | Manual        |

  @PDAPTT-375 @sprint3 @regression @test2
  Scenario Outline: Capture Attributes validate back button for "<work area>"
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    And The traffic recorder makes a selection
    And The user selects the back button on the physical device
    Then All "<work area>" attributes on the page should clear except the default attributes when the page first loads

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | Conc Out  |      1000073 | LETTER      | 2ND CLASS  | Meter        | Manual        |

  @PDAPTT-17 @scenario1 @regression @sprint5
  Scenario Outline: Attribute Set- Container Type (Barcode Unavailable/Faulty)
    Given The user has completed entering mail format, class, payment type, submail type and stream ID
    When The Traffic recorder selects scan containers
    And The Traffic recorder selects select faulty barcode
    Then The user should presented with valid container types based on selected attributes

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | Conc Out  |      1000073 | LETTER      | NOT APPLICABLE | MC DIRECT        | Manual        |

  @PDAPTT-17 @scenario2 @regression @sprint5
  Scenario Outline: User selects container type (multiple options)
    Given The user has completed entering stream data "<username>" "<pin>" "<location>" "<work area>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    When The Traffic recorder selects scan containers
    And The Traffic recorder selects select faulty barcode
    Then More than one valid container type for that stream is displayed

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | OPS - LL  |      1000082 | 2ND Class  | STAMP        | Surcharge     |

  @PDAPTT-17 @scenario3 @regression @sprint5
  Scenario Outline: User selects container type (one option)
    Given The user has completed entering stream data "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When The Traffic recorder selects scan containers
    And The Traffic recorder selects select faulty barcode
    Then Only one valid container type for that stream is displayed

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-17 @scenario4 @regression @sprint5
  Scenario Outline: User submits selected container
    Given The user has completed entering stream data "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When The Traffic recorder selects scan containers
    And The Traffic recorder selects select faulty barcode
    Then The user should select done button to complete action

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-17 @scenario5 @regression @sprint5
  Scenario Outline: Faulty Barcode entry
    Given The user has completed entering stream data "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When The Traffic recorder selects scan containers
    And The Traffic recorder selects select faulty barcode
    Then the row should display Faulty/Missing (in place of barcode number), container type , time of entry and ACF columns should be displayed

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-17 @scenario6 @regression @sprint5
  Scenario Outline: User cancels faulty barcode entry
    Given The user has completed entering stream data "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When The Traffic recorder selects scan containers
    And The Traffic recorder selects select faulty barcode
    And The user selects cancel
    Then the PDA should close the pop up list and return to the scan list

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-17 @scenario7 @regression @sprint5
  Scenario Outline: User cancels faulty barcode entry
    Given The user has completed entering stream data "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When The Traffic recorder selects scan containers
    And The Traffic recorder selects select faulty barcode
    And The user select the back button on device
    Then the PDA should close the pop up list and return to the scan list

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-17 @scenario8 @regression @sprint5
  Scenario Outline: Thirty transaction limit pop up on faulty/missing button
    Given The user completes record via faulty/missing button "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has reached twenty nine entries
    Then A warning msg should appear asking user to submit transactions

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-170 @scenario1 @sprint5 @regression
  Scenario Outline: Submit traffic capture (submit button)
    Given the user has captured traffic transaction "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When the user selects the submit button
    Then the data transactions should be submitted to the PDA server

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-170 @scenario2 @sprint5 @regression
  Scenario Outline: Return to Capture Attributes Page
    Given the user has captured traffic transaction "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When the user selects the submit button
    Then the app should take the user to the capture attributes page

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-170 @scenario4 @sprint5 @regression
  Scenario Outline: Populate Capture Attributes Page
    Given the user has captured traffic transaction "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When the user selects the submit button
    And the user arrives on the capture attributes page
    Then The page should be populated with the last derived stream details

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-170 @scenario5 @sprint5 @regression
  Scenario Outline: Go back Capture Attributes Page
    Given the user is on the scan containers page "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    When The user select the back button on device
    And the user arrives on the capture attributes page
    Then The page should be populated with the last derived stream details

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-519 @sprint6
  Scenario Outline: Location work area mapping
    Given The user has logged on with their "qa01.testuser" and "1234"
    And The user has selected a location "<site location>"
    Then The work area list should be filtered based on location "<site location>"

    Examples: work area data
      | site location          |
      | Aberdeen Mail Centre   |
      | Birmingham Mail Centre |
      | Bristol Mail Centre    |
      | Cardiff Mail Centre    |
      | Carlisle Mail Centre   |
      | Chelmsford Mail Centre |
      | Chester Mail Centre    |
      | Greenford Mail Centre  |
      | Exeter Mail Centre     |

  @PDAPTT-51 @scenario1 @sprint6 @regression
  Scenario Outline: Abnormal Posting button available
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    Then The Traffic recorder should be able to select Scan Containers or Abnormal Posting button

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        |

  @PDAPTT-51 @scenario2 @sprint6 @regression
  Scenario Outline: Abnormal Posting button selected
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user selects the Abnormal Posting
    Then The title of the page is read as stream name determined at Capture Attribute Page

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        |

  @PDAPTT-51 @scenario3 @sprint6 @regression
  Scenario Outline: Abnormal Posting button selected
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user selects the Abnormal Posting
    Then The abnormal posting fields/buttons should be available

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        |

  @PDAPTT-480 @scenario1 @sprint6 @regression
  Scenario Outline: Inputs
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user selects the Abnormal Posting
    And The user enters abnormal posting values "<acf>" "<customer name>"
    And The Traffic recorder selects scan abnormal containers
    Then the user is navigated to the Scan Page

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-480 @scenario2 @sprint6 @regression
  Scenario Outline: Buttons
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user selects the Abnormal Posting
    And The user enters abnormal posting values "<acf>" "<customer name>"
    And The Traffic recorder selects scan abnormal containers
    Then The page should include Submit and Faulty/Missing buttons

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-171 @scenario1 @sprint6 @regression
  Scenario Outline: Select Record to Delete
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal traffic data transaction
    And The user long presses a record on the screen
    Then The screen should be in delete mode

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-171 @scenario2 @sprint6 @regression
  Scenario Outline: Delete Mode
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal traffic data transaction
    And The user long presses a record on the screen
    Then The screen should include check boxes, a cancel button and a delete button

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-171 @scenario3 @sprint6 @regression
  Scenario Outline: Delete a Record
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal traffic data transaction
    And The user long presses a record on the screen
    And The user has selects delete button
    Then The record should be deleted from the PDA history

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-171 @scenario4 @sprint6 @regression
  Scenario Outline: Cancel
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal traffic data transaction
    And The user long presses a record on the screen
    And The user selects the cancel button
    Then The the screen should return to the traffic capture list

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-485 @scenario2 @sprint6 @regression
  Scenario Outline: User is presented container type where barcode is unavailable or faulty
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal posting transaction
    Then The user should presented with valid container types based on selected attributes

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-485 @scenario3 @sprint6 @regression
  Scenario Outline: User selects container type (multiple options)
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal posting transaction
    Then The user should select done button to complete action

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | OPS - LL   |      1000082 | 2ND Class  | STAMP        | SURCHARGE        |

  @PDAPTT-485 @scenario4 @sprint6 @regression
  Scenario Outline: User selects container type (one option)
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal posting transaction
    Then Only one valid container type for that stream is displayed

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-485 @scenario5 @sprint6 @regression
  Scenario Outline: User submits selected container
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal posting transaction
    Then The user should select done button to complete action

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-485 @scenario6 @sprint6 @regression
  Scenario Outline: Faulty/Missing entry
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal posting transaction
    Then the row should display Faulty/Missing (in place of barcode number), container type , time of entry and ACF columns should be displayed

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf | customer name |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 123 | michael       |

  @PDAPTT-485 @scenario7 @sprint6 @regression
  Scenario Outline: User cancels faulty barcode entry
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal posting transaction
    And The user selects cancel
    Then the PDA should close the pop up list and return to the scan list

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-485 @scenario8 @sprint6 @regression
  Scenario Outline: User cancels faulty barcode entry
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has captured an abnormal posting transaction
    And The user select the back button on device
    Then the PDA should close the pop up list and return to the scan list

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-485 @scenario9 @sprint6 @regression
  Scenario Outline: Thirty transaction limit pop up on faulty/missing button
    Given The user completes record via abnormal posting, faulty/missing button "<username>" "<pin>" "<location>" "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user has reached twenty nine entries
    Then A warning msg should appear asking user to submit transactions

    Examples: work area data
      | username      | pin  | location             | work area | work area id | mail class | payment type | Sub Mail Type |
      | qa01.testuser | 1234 | Aberdeen Mail Centre | IPS - L   |      1000073 | 1ST Class  | DSA          | Manual        |

  @PDAPTT-484 @scenario1 @sprint6
  Scenario Outline: Capturing Multiple Traffic Capture Transactions
    Given the user is on the scan container page
    When the user enters a data capture transaction
    Then the details of the abnormal data capture transaction should list on the page

  @PDAPTT-682 @scenario1 @sprint7 @regression
  Scenario Outline: Clear field by one for "<work area>"
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user selects the back button on the physical device
    Then One "<work area>" field should clear

    Examples: work area data
      | username      | password | work area | work area id | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | DSA          | Manual        |

  @PDAPTT-682 @scenario2 @sprint7 @regression
  Scenario Outline: Skip default field "<work area>"
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    And The user selects the back button on the physical device
    Then The app should skip the "<work area>" default field and clear the field before

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | Conc Out  |      1000073 | LETTER      | 2ND CLASS | Meter        | Manual        |

  @PDAPTT-682 @scenario3 @sprint7 @regression
  Scenario Outline: Back button when all fields are clear
    Given The user has logged on with their "<username>" and "<password>"
    When The user populates the required destination location prerequisites "<work area>" "<mail format>" "<mail class>" "<payment type>" "<Sub Mail Type>"
    And All field are clear with exception of default field
    And The user selects the back button on the physical device
    Then Nothing should happen and the user should remain on the capture attributes page

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type |
      | qa01.testuser |     1234 | Conc Out  |      1000073 | LETTER      | 2ND CLASS | Meter        | Manual        |

  @PDAPTT-691 @regression @sprint8
  Scenario Outline: Character limit on fields
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required stream prerequisites "<work area>" "<payment type>" "<Sub Mail Type>"
    And The user selects the Abnormal Posting
    And The user enters abnormal posting values "<acf>" "<customer name>"
    Then Data length should match ICD

    Examples: work area data
      | username      | password | work area | work area id | mail format | mail class     | payment type | Sub Mail Type | acf   | customer name                                                                                                                                                                                                                                                   |
      | qa01.testuser |     1234 | IPS - L   |      1000073 | LETTER      | NOT APPLICABLE | DSA          | Manual        | 12345 | I am confident that this test will pass. I am confident that this test will pass. I am confident that this test will pass. I am confident that this test will pass. I am confident that this test will pass. I am confident that this test will pass. I am sure |

  @validateReferenceData
  Scenario Outline: Validate reference data
    Given I want to validate reference data for "<location>"
    Then Reference Data should be valid

    Examples: 
      | location                     |
      |	Aberdeen Mail Centre         |
      | Birmingham Mail Centre       |
      | Bristol Mail Centre          |
      | Cardiff Mail Centre          |
      | Carlisle Mail Centre         |
      | Chelmsford Mail Centre       |
      | Chester Mail Centre          |
      | Croydon Mail Centre          |
      | Dorset Mail Centre           |
      | Edinburgh Mail Centre        |
      | Exeter Mail Centre           |
      | Gatwick Mail Centre          |
      | Glasgow Mail Centre          |
      | Greenford Mail Centre        |
      | Home Counties North MC       |
      | Inverness Mail Centre        |
      | Jubilee Mail Centre          |
      | Leeds Mail Centre            |
      | London Central Mail Centre   |
      | Manchester Mail Centre       |
      | Medway Mail Centre           |
      | National Distribution Centre |
      | Northern Ireland Mail Centre |
      | Norwich Mail Centre          |
      | Nottingham Mail Centre       |
      | Peterborough Mail Centre     |
      | Plymouth Mail Centre         |
      | Romford Mail Centre          |
      | Sheffield Mail Centre        |
      | South Midlands Mail Centre   |
      | Southampton Mail Centre      |
      | Swansea Mail Centre          |
      | Swindon Mail Centre          |
      | Truro Mail Centre            |
      | Tyneside Mail Centre         |
      | Warrington Mail Centre       |
      | Preston Mail Centre  				|
      
  @confirmMessageOnMQ @sprint8
  Scenario: Shift History restriction
    Given the user has captured traffic transaction "qa01.testuser" "1234" "Aberdeen Mail Centre" "IPS - L" "DSA" "Manual"
    When the user selects the submit button
    Then The message should be on MQ

  @scrollAndSelect
  Scenario Outline: Scroll and select
    Given The user has logged on with their username "qa01.testuser" and pin "1234"
    When I want to select location "<location>"

    Examples: 
      | location             |
      | Aberdeen Mail Centre |

  @PDAPTT-743 @scenario1 @sprint9
  Scenario Outline: User selects Delivery Out
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required delivery out prerequisites "<work area>" "<mail format>" "<Sub Mail Type>"
    Then A Delivery office dropdown should be present on page

    Examples: work area data
      | work area    | mail format | Sub Mail Type |
      | Delivery Out | LARGE LETTER      | IPS           |

  @PDAPTT-743 @scenario2 @sprint9
  Scenario Outline: Delivery offices presented to user
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required delivery out prerequisites "<work area>" "<mail format>" "<Sub Mail Type>"
    Then The a Delivery office dropdown selection should be derived by site location

    Examples: work area data
      | work area    | mail format | Sub Mail Type |
      | Delivery Out | LARGE LETTER      | IPS           |

  @PDAPTT-743 @scenario3 @sprint9
  Scenario Outline: User selects Delivery Out
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user populates the required delivery out prerequisites "<work area>" "<mail format>" "<Sub Mail Type>"
    And The traffic recorder selects Delivery Office
    Then The selection should populate the field

    Examples: work area data
      | work area    | mail format | Sub Mail Type |
      | Delivery Out | LARGE LETTER      | IPS           |

  @PDAPTT-544 @sprint9
  Scenario: Shift Details from Navigation Menu
    Given The user has logged on with their "qa01.testuser" and "1234"
    When The user has completed shift details selection
    And The user goes back to the shift details page
    Then Previous location selection is remembered

  @PDAPTT-809 @PDAPTT-795 @sprint8 @sprint9
  Scenario Outline: "<work area>"
    Given the user has captured traffic transaction "qa01.testuser" "1234" "Aberdeen Mail Centre" "<work area>"
    When The user selects shift history
    Then The traffic record should include a location field displaying the selected Delivery Office

    Examples: work area data
      | work area    |
      | Delivery Out |
      | Divert Out   |
      | Conc Out     |
      | Intercept    |

  @adHocUserActivity @PDAPTT-736
  Scenario Outline: Ad Hoc user behaviour
    Given I want to perform ad hoc actvities on "<location>"
    Then I should not see any failures

    Examples: 
      | location             |
      | Aberdeen Mail Centre |

  @pdaptt-154 @wip
  Scenario: Populating User ID with barcode scan
    Given User is not already logged in
    When The user scans their badge barcode
    Then The app should recognise their barcode and populate the username
