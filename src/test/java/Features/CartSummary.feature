Feature: Check few details in the cart summary
  Verify the cart summary details as a non-login user 
  
  Scenario: Add a product to the cart as non-login user
  	Given Add a single product to the cart
    Then Check the details in the cart summary
	
	Scenario: Add multiple product to the cart as non-login user
  	Given Add multiple product to the cart
    Then Check the products in the cart
  