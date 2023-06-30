Feature: Add to Cart on Store Page

  Scenario: Add one item on Store Page
    Given I'm on the Store Page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart

    Scenario Outline:
      Given I'm on the Store Page
      When I add a "<product_name>" to the cart
      Then I should see 1 <"product_name"> in the cart
      Examples:
      |product_name    |
      |Blue Shoes      |
      |Anchor Bracelet |


