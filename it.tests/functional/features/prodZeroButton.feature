Feature: Product Zero Button Navigation
Description: This feature file will validate the button navigation to Google.com
 
  @smoke
  Scenario Outline: Validating Product Zero Button Component
    Given I visit the "<environment>" page
    When I click on the "<button-component>" in the page
    Then "<button-component>" should navigate to "<url>" page
    Examples:
      | environment| button-component |url|
      | /content/productzero/prdzerobutton.html | prdZeroButton | Google |