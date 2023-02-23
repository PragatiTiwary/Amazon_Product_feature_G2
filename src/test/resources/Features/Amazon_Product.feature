Feature: Amazon a product feature.

  Scenario: Verify user is able to search a product
    Given  the user navigates to the home Page
    When  the user enter the product name
    Then  the product result should be displayed

  Scenario: Verify user is able to select category
    Given the user navigates to  Home Page
    When the user select a category
    Then the category should be selected and displayed
@smoke
  Scenario: Verify user is able to enter address
    Given the user goes to the home Page
    When the user click and enter address
    Then the address should be displayed


   Scenario Outline: Verify user able to search more than one product
      Given user navigates to amazon home page
      When the user searches the "<products>"
      Then Searched products "<results>" should be displayed
      Examples:
        | products   | results |
        | chocolates |  chocolates|
        | kurti      |  kurti   |
        | toys       |  toys|

  Scenario: Verify user is able to sort results
    Given the navigates to result page
    When the user sort the feature
    Then sorted result should be displayed to user