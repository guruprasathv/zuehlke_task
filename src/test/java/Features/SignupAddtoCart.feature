Feature: Add a product to the cart as logged-in user
  Verify if user is able to signup and add a product to the cart
  
  Scenario: Add a product to the cart as logged-in user
  	Given Signup as a new user and navigate to account page
    When Search for a new product
    And User should navigate to the product page
    And Add a new product to the cart
    Then Product is successfully added to the cart
