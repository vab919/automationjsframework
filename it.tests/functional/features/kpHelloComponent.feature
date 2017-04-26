Feature: Kaiser Web Page - Hello component validation
        description this feature file find and validate "Hello World" component on kaiser page.


  @smoke
  Scenario Outline: Validating Hello Component
    Given I visit AEM webpage "/content/productzero/comp-automation-page.html"
    When  I search for  "<componenttext>"
    Then I validate the "<componenttext>"

    Examples:
      | componenttext |
      | COMP-AUTOMATION-PAGE|

  @functional
  Scenario Outline: Validating Instance and Resource Type
    Given I visit AEM webpage "/content/productzero/comp-automation-page.html"
    When  I search for body content "<componenttext>"
    Then I validate the body content "<componenttext>"

    Examples:
      | componenttext |
      |      This is a home page|
      |      Hello, world! I am a component, built to demonstrate component development in AEM. I was created using BDD, with automated test suites, and the Factory of the Future Pipeline. I will continue to evolve as my masters come up with new ideas. |
