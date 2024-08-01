Feature: Verify User Home Page

  Scenario: Verify user home page displayed after successful login
    Given user is on the login page
    When user enters valid credentials
    And user enters two-factor authentication code
    Then user should be redirected to the home page
    And home page should be displayed

  Scenario Outline: Verify error message displayed after fail login
    Given user is on the login page
    When user enters invalid <email> and <password>
    And user click login button
    Then user should be still stay on login page
    And error message should be displayed
    Examples:
      | email                      | password      |
      | "ethan.summer@yopmail.com" | "password"    |
      | "jacob.spring@yopmail.com" | "12345678@Ab" |