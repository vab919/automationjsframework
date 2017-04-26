Feature: Validate SDET is able to execute Hobbes Test

Background:
Given I visit website with url "URL"

@smoke
Scenario: Validate SDET is able to execute Hobbes Test
  When I click on Developer Option icon
  And I click on Tests icon
  Then I click on "Run Test Suite" button
  And I see all the execution of test script
