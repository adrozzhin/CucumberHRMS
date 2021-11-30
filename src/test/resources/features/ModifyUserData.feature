#Fields to modify -
#DL
#License exp date
#DOB
#Marital status
#Smoker
#Nationality
#Military services

Feature: Modify fields DL, License exp date, DOB, Marital status, Smoker, Nationality, Military services

  Background:
    Given user is logged in with valid admin credentials
    And user clicks on PIM option
    And user clicks on Add Employee button

  @modify
  Scenario Outline: fields are interactive and user can modify employee's data
    When user enters "<firstName>", "<middleName>" and "<lastName>" for test employee
    And user clicks on save button
    Then employee added successfully
    And user clicks on Edit button
    Then fields are interactive
    And user enters DL Number "<dlNumber>"
    And user enters DL Expiration date "<dlExpirationYear>" "<dlExpirationMonth>" "<dlExpirationDay>"
    And user enters marital status "<marital>"
    And user enters nationality "<nationality>"
    And user enters date of birth "<dOBYear>" "<dOBMonth>" "<dOBDay>"
    And user enters smoker status
    And user enters military Status "<military>"
    And user clicks on save button
    Then military status added successfully "<military>"
    Then smoker status chosen successfully
    Then date of birth added successfully "<dOBYear>" "<dOBMonth>" "<dOBDay>"
    Then nationality added successfully "<nationality>"
    Then marital status added successfully "<marital>"
    Then DL Expiration date added successfully "<dlExpirationYear>" "<dlExpirationMonth>" "<dlExpirationDay>"
    Then Driver's License Number added successfully "<dlNumber>"
    Examples:
      | firstName | middleName | lastName | dlNumber | dlExpirationYear | dlExpirationMonth | dlExpirationDay | marital | nationality | dOBYear | dOBMonth | dOBDay | military |
      | Harry     | V          | Potter   | B123456  | 2027             | May               | 22              | Married | British     | 1990    | Aug      | 15     | Veteran  |
