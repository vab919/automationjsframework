Feature: Zipcode Search displays list of facilities

Background:
Given I go to the website with url "/content/productzero/dec10morning.html"

@smoke
Scenario: Validate if Zipcode Textbox is Present in the given Page
  Then I validate the Zipcode Textbox

@smoke
Scenario: Validate if SEARCH Button is Present in the given Page
  Then I validate the SEARCH Button

@regression
Scenario Outline: Enter my zip code so that I can see what facilities
  When I enter "<Zipcode>" in the textbox
  And I select Region as "<region>"
  And I click SEARCH button
  Then I can see the list of facilities with "<facility>" and Address as "<address>" in the first row
  Examples:
      | Zipcode | address | facility | region |
      | 30606|1199 Prince Avenue |Athens Regional Medical Center| GGA |
      | 94545|2595 Depot Rd |Cronin House| NCA |

@functional
Scenario Outline: Enter invalid zip code and valid region
    When I enter valid Zipcode with "<zipcode>" in the textbox
    And I select Region as "<region>"
    And I click SEARCH button
    Then I do not see the list of facilities

Examples:
  | zipcode | region |
  | 94545 | GGA |
  | 30605 | NCA |
