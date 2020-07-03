Feature: Accounts Overview

  In order to access my banking
  As a logged in user
  I can see my account overview and details

  Scenario: Account Table content is properly displayed
    Given user is logged in
    Then account number, balance and available amount are properly displayed

  Scenario: Account Details are correct
    Given user has seen Account Number, Balance and Available sum
    When user is at Account Details screen
    Then values for all parameters are matching

  Scenario: User can select values from dropdowns
    Given user is logged in
    When user is at Account Details screen
    Then they can select from Activity Period and Account Type dropdowns




