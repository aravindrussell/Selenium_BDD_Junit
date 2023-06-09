Feature: HRM Login Page

  Background: Launching the application
    Given Launch the Application URL

  Scenario: HomePage Displayed after logging valid credentials
    Given The user enter below username and password in text box
      | admin | admin123 |
    When The user click on Login button
    Then The user verify Home page displayed