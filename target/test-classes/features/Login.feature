Feature: Login validation


  Scenario: Valid admin login
    Given user is navigated to HRMS
    When user enters valid username and password
    And user clicks on login button
    Then admin user is succesfully logged in

  Scenario: Valid ess login
    Given user is navigated to HRMS
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in


  Scenario: Valid username and invalid password login
    Given user is navigated to HRMS
    When user enters valid ess username and invalid password
    And user clicks on login button
    Then user see invalid credentials message on login page

  Scenario: Invalid username and valid password login
    Given user is navigated to HRMS
    When user enters invalid username and valid password
    And user clicks on login button
    Then user see invalid credentials message on login page

  Scenario: Empty username and valid password login
    Given user is navigated to HRMS
    When user enters empty username and valid password
    And user clicks on login button
    Then user see empty username message on login page

  Scenario: Valid username and empty password login
    Given user is navigated to HRMS
    When user enters valid username and empty password
    And user clicks on login button
    Then user see empty password message on login page


