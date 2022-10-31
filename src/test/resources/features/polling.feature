@CRMLYEUG-1432
Feature: CRM24 app polling feature
  User Story: As a user, I should be able to create a poll
                by clicking on Poll tab under Active Stream.

  Accounts are: Helpdesk, human resources, marketing

  #@CRMLYEUG-1422
  Background: For the scenarios in the feature file, user is expected to be on Activity Stream page
    Given user is on Activity Stream page and clicks on the POLL tab

  @CRMLYEUG-1423
    Scenario: Adding users for polling
      When user clicks on the Add more button
      And  user adds multiple contacts for polling
      Then user sees multiple contacts in the polling list

  @CRMLYEUG-1424
    Scenario: Adding questions and answers for polling
      When user clicks on Add question button
      Then user sees a question and multiple answers added to polling section

  @CRMLYEUG-1425
    Scenario: Deleting questions and answers for polling
      When user clicks on Add question button
      Then delete question button is clickable on the page

  @CRMLYEUG-1426
    Scenario: Allowing multiple choices for polling
      When user clicks Allow multiple choice checkbox
      Then user sees the checkbox is selected

  @CRMLYEUG-1427
    Scenario: Creating a poll without message title
      When user creates a poll leaving message title empty
      Then the message title is not specified error message is displayed on the page

  @CRMLYEUG-1428
    Scenario: Creating a poll without adding persons
      When user creates a poll without adding persons for the poll
      Then please specify at least one person error message is displayed on the page

  @CRMLYEUG-1429
    Scenario: Creating a poll without question text
      When user creates a poll without question text
      Then the question text is not specified error message is displayed on the page

  @CRMLYEUG-1430
    Scenario: Creating a poll without answers
      When user creates a poll without answers
      Then the question has no answers error message is displayed on the page

  @CRMLYEUG-1431
    Scenario: Creating a poll without multiple answers
      When user creates a poll with only one answer
      Then please specify at least two answers error message is displayed on the page

