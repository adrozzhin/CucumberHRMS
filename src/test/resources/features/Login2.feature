Feature: Error validation in login page

  @errorvalidation1
  Scenario: valid username and invalid password
    When user enters invalid credentials and clicks on login verify the error
      | username | password    | errorMessage             |
      | Admin    | Hum@n       | Invalid credentials      |
      | Admin1   | Hum@nhrm123 | Invalid credentials      |
      |          | Hum@nhrm123 | Username cannot be empty |
      | Admin    |             | Password cannot be empty |


  @errorvalidation
  Scenario Outline: valid username and invalid password
    When user enters invalid "<username>" and "<password>" and clicks on login and verify the "<errorMessage>"
    Examples:
      | username | password    | errorMessage             |
      | Admin    | Hum@n       | Invalid credential      |
      | Admin1   | Hum@nhrm123 | Invalid credential      |
      |          | Hum@nhrm123 | Username cannot be empty |
      | Admin    |             | Password cannot be empty |