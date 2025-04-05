@login
Feature: Test all login related features

  @smoke @regression
  Scenario: Login to application using valid username and password
    Given As a user I want to launch to the application
    And I need to click on Login link
    When I enter a valid username
    And I enter a valid password
    Then I should login successfully

  @smoke
  Scenario: Login to application using valid username and Invalid password
    Given As a user I want to launch to the application
    And I need to click on Login link
    When I enter a valid username
    And I enter a Invalid password
    Then I should click on login