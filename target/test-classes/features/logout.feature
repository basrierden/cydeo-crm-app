@CRMLYEUG-1415 @logout
Feature: CRM24 app logout feature
  User Story:
  As a user, I should be able to log out

  #@CRMLYEUG-1412
  Background: For the scenarios in the feature file, user is expected to be on Activity Stream page
    Given user is on the CRM24 Activity Stream page

  @CRMLYEUG-1411
  Scenario: Successful logout scenario
    When user clicks on the username dropdown
    And user clicks on the Log out button
    Then user sees the title is Authorization

  @CRMLYEUG-1413
  Scenario: Step back button check
    When user clicks on the username dropdown and on the Log out button
    And user clicks on the step back button
    Then user sees the title is Authorization

  @CRMLYEUG-1414
  Scenario: Closing tab check
    When user open multiple tabs and enter valid credentials
    And user closes all tabs
    And user opens new tab and types URL address of the app
    Then user sees the page of the title is Authorization