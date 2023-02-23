Feature: Amazon a product feature.

  Scenario: Verify user is able to search a product
    Given  the user navigates to the home Page
    When  the user enter the product name
    Then  the product result should be displayed

  Scenario: Verify user is able to select category
    Given the user navigates to  Home Page
    When the user select a category
    Then the category should be selected and displayed

  Scenario: Verify user is able to enter address
    Given the user goes to the home Page
    When the user click and enter address
    Then the address should be displayed

@smoke
   Scenario Outline: User able to select category and sort the result
      Given the user searches a product
      When the user navigates to the result page
      And the user selects the "<brand>" and "<sort>"
      Then selected options should be displayed
      Examples:
        | brand  | sort     |
        | Cadbury| Low_to_High |
