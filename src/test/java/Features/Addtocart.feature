Feature: Add a product to the cart
  Verify if user is able to add a product to the cart

  Scenario: Check the empty cart
    Given User navigates to the home view
    Then Cart is empty
    
  Scenario: Add a product to the cart as non-login user
    When Search for a product
    And User navigates to the product page
    And Add the product to the cart
    Then Product successfully added to the cart
  