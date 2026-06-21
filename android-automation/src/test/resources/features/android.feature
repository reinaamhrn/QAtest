Feature: Android MyDemoApp Flow

  Scenario: Login, buy product, checkout, and sort product
    Given user is on product page
    When user login from menu
    And user selects product Sauce Labs Backpack
    And user configures product and add to cart
    And user opens cart and checkout
    And user completes checkout process
    And user returns to product page
    And user sorts product by name descending
    And user sorts product by price ascending
    Then product list should be displayed