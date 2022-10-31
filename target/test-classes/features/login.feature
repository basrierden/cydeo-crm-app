@CRMLYEUG-1397 @login
Feature: CRM24 app login feature
  User Story:
  As a user, I should be able to login; so that I can land on homepage

  Accounts are: Helpdesk, human resources, marketing

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the CRM24 login page

  @CRMLYEUG-1390
  Scenario Outline: Positive login scenario
    When user enters username "<username>" and password "<password>"
    Then Activity Stream page should be displayed
    Examples:
      | username                      | password |
      | helpdesk2@cybertekschool.com  | UserUser |
      | hr2@cybertekschool.com        | UserUser |
      | marketing2@cybertekschool.com | UserUser |

  @CRMLYEUG-1392
  Scenario Outline: Negative login scenario
    When user enters wrong "<username>" or wrong "<password>"
    Then Incorrect login or password "<error message>" should be displayed for invalid credentials
    Examples:
      | username               | password          | error message               |
      | incorrectusername      | UserUser          | Incorrect login or password |
      | hr2@cybertekschool.com | incorrectpassword | Incorrect login or password |
      | incorrectusername      | incorrectpassword | Incorrect login or password |


  @CRMLYEUG-1393
  Scenario Outline: Missing credentials scenario
    When user leaves username "<username>" or password "<password>" empty
    Then Please fill out this field "<error message>" should be displayed
    Examples:
      | username                     | password | error message              |
      | helpdesk2@cybertekschool.com |          | Please fill out this field |
      |                              | UserUser | Please fill out this field |
      |                              |          | Please fill out this field |

  @CRMLYEUG-1394
  Scenario: "Forgot Password" link check
    When user clicks forgot password link
    Then user land on "Get Password" page

  @CRMLYEUG-1395
  Scenario: "Remember Me" link check
    When user clicks remember me link
    Then user sees checkbox is selected

  @CRMLYEUG-1396
  Scenario: Password in bullet signs check
    When user enter credentials in password box
    Then user sees password in bullet signs

  @CRMLYEUG-1399
  Scenario Outline: Enter key check
    When user enters username "<username>" and password "<password>" and clicks Enter key
    Then user lands on the Activity Stream page
    Examples:
      | username                      | password |
      | helpdesk2@cybertekschool.com  | UserUser |
      | hr2@cybertekschool.com        | UserUser |
      | marketing2@cybertekschool.com | UserUser |

