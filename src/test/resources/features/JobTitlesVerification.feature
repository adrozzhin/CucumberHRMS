Feature: Job Titles Verification

  @db1
  Scenario: Verifying that all job titles are displayed in Ascending order in HRMS Application (Must be verified against DB)
    Given user is logged in with valid admin credentials
    When admin user navigates to job titles table
    When admin user verifies that all job titles are displayed in Ascending order same as in job titles data base