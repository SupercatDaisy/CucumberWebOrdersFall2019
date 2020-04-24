Feature: Create Order
  As a user , I want to be able to place order

  @Test2
  Scenario: Create Order
    Given user is on landing page
    When user enters following credentials:
      | username | Tester |
      | password | test   |
    Then user click on submit button
    And user navigates to "Order" page
    When user enters following product information:
      | Product     | Quantity | Price per unit | Discount |
      | FamilyAlbum | 28       | 80             | 15       |
    And user click on calculate button
    Then user should verify that total is 1904 is displayed
    When user enters address information as following :
      | Customer name | Street | City    | State | Zip   |
      | Survivor Jack | Trader | Vault62 | Vegas | 06514 |
    And user enters payment information as following :
      | Card       | Card Nr   | Expire date (mm/yy) |
      | MasterCard | 123456789 | 01/21               |
    And user clicks on process button
    And user navigates to "View all orders" page
    Then user verifies that order is placed with following data :
      | Name          | Product     | Quantity | Date       | Street | City    | State | Zip   | Card       | Card Number | Exp   |
      | Survivor Jack | FamilyAlbum | 28       | 04/24/2020 | Trader | Vault62 | Vegas | 06514 | MasterCard | 123456789   | 01/21 |





