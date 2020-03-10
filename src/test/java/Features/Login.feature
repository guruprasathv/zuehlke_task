Feature: Login to the application
  Verify if user is able to Login to the application
	
	Scenario: Verify the options in the login page
		Given User navigates to the home page
    When user navigates to the Login Page
    Then Check for the  'Forgot password' option
    
	Scenario: Login with empty credentials
    Given user donot enter any values in email and password field
    Then Error message is thrown for entering emaild address
    
  Scenario: Login with invalid characters in email address field
    And user enters invalid characters for email address field
    Then Error message is thrown for authentication failure
    
  Scenario: Login with invalid email
    And user enters invalid username and valid password
    Then Error message is thrown for invalid username
    
  Scenario: Login with invalid password
    Given user enters valid username and invalid Password
    Then Error message is thrown for invalid password
    
  Scenario: Login with valid user credentials
    Given user enters valid username and Password
    Then My account page is shown
