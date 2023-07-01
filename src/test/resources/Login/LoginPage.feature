Feature: HRM Login Page

  Background: Launching the application
    Given Launch the Application URL

  @Login-Positive-Scenario
  Scenario: HomePage Displayed after logging with valid credentials
    Given The user enter below username and password in text box
      | admin | admin123 |
    When The user click on Login button
    Then The user verify Home page displayed

  @Login-Negative-Scenario
  Scenario Outline: HomePage Displayed after logging valid credentials
    Given The user enter "<UserName>" username and "<Password>" password in text box
    When The user click on Login button
    Then The user verify Incorrect User

    Examples:
      | UserName | Password |
      | admin    | admin123 |
      | arv      | asd      |