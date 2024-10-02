Feature: Online order Functionalities of Domino's

  Scenario Outline: Add and Remove products into cart
    Given user launch the "<Browser>" browser
    Then user verifies the homepage
    And user click order online now
    And user click enter address and enter pincode and select first suggestion
    And user goes to veg pizza section and add "primavera Gourmet Pizza" as quantity 2
    And user want to add 2 "Margherita" and 2 "Peppy Paneer" pizzas to my cart
    And user goes to beverages section and select "pepsi 475ml" with quantity 12
    Then user verifies Cart Subtotal Value with Sum of Each Products and their quantities
    And user goes to the veg section in  removing "Margherita" pizza with quantity 1
    And user goes to the beverages section and removing "pepsi 475ml" with quantity 6
    Then user verifies Cart Subtotal Value with Sum of Each Product Value and quantity after removing products
    And user Get Sub Total Value & Click Check Out
    Then user verifies the Subtotal Checkout With Subtotal Place Order Price Details

Examples:
  | Browser |
  | chrome  |
  | firefox |
  | edge    |