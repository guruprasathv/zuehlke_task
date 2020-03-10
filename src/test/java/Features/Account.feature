Feature: Verify account signup and login to the account
  Scenario: Verify the ability to register and login to the same account
    Given User is on the sign in page
    And Fill out the personal information form
    Then My account page should be open