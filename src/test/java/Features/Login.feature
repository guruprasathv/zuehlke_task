Feature: Login to the application
  Verify if user is able to Login to the application

  Scenario: Login with invalid email
    Given User navigates to the home page
    When user navigates to the Login Page
    And user enters invalid username and valid password
    Then Error message is thrown for invalid username
    
  Scenario: Login with invalid password
    Given user enters valid username and invalid Password
    Then Error message is thrown for invalid password
    
  Scenario: Login with valid user credentials
    Given user enters valid username and Password
    Then My account page is shown
