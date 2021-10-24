Feature: Search employee

  Scenario: 2345-Search employee by id
    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee id
    And click on search button
    Then user see employee with desired id is displayed
    Then user quit the browser

  Scenario: 2345-Search employee by name
    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee name
    And click on search button
    Then user see employee with desired name is displayed
    Then user quit the browser