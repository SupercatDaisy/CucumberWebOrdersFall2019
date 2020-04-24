Feature:  Login

  As a user I want to be able to login

  @Test1
  Scenario: Login
    Given user is on landing page
    When user enters following credentials:
    |username|Tester|
    |password|test  |
    Then user click on submit button
