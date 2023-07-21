@e2e-with-multi-uom @sanity
Feature: Cash order placement for single item and multiple uom

  Scenario: Verify cash order placement for single item and multiple uom

    * user login to the experience layer sales app with valid details
      | ${wh2-se1} | ${common-password} |
    * user click on beat button
    * user click on locality and store
      | ${wh2-sp1.locality} | ${wh2-customer-1-title} |
    * user clicks on take a remote order button
    * user add item to cart
      #| Item or Category Name | Index No | Uom |Quantity|
      | Automation-Category-1 | ${NUMBER-1-5} | Piece | ${NUMBER-5-10} |
      | Automation-Category-2 | ${NUMBER-1-5} | Bag   | ${NUMBER-5-10} |
      | Automation-Category-2 | ${NUMBER-1-5} | Case  | ${NUMBER-5-10} |
    * user place local order


    

