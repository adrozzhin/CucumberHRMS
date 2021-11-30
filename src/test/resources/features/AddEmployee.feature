Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @smoke
  Scenario: first scenario of adding the employee

    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully


  @smoke
  Scenario: second scenario of adding the employee

    And user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

  @smoke1
  Scenario: third scenario of adding the employee

    And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then employee added successfully

  @smoke
  Scenario: adding an employee from feature file

    And user enters "Andrei777" "middle" and "Drozzhin"
    And user clicks on save button
    Then employee added successfully

  @pretty
  Scenario Outline: adding an employee from feature file

    And user enters "<firstName>" "<middleName>" and "<lastName>" for an employee
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | mike555   | meme       | lopez    |
      | andrei    | andrew     | drozzhin |
      | serge     | serge1     | serge2   |

  @smoke
  Scenario: adding an employee using data table
    When I add multiple employees and verify them that user has been added successfully
      | firstName | middleName | lastName |
      | mike555   | meme       | lopez    |
      | andrei    | andrew     | drozzhin |
      | serge     | serge1     | serge2   |
      | Eugene    | Eugene1    | Eugene2  |
      | Olena     | Olena1     | Olena2   |

  @excel
  Scenario:  Adding an employee from excel file
    When user adds multiple employees from excel file using "employeeData" sheet and verify the added employee

  @db @regression
  Scenario: Adding employee and validating in Database
    And user enters "Andrei777" "middle" and "Drozzhin"
    And captures employee id
    And user clicks on save button
    And employee added successfully
    Then query HRMS database and get data
    And verify employee data is matched in ui and db

