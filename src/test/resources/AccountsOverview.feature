Feature: Accounts Overview

  In order to access my banking
  As a logged in user
  I can see my account overview and details

  Scenario: Account Table content is properly displayed
    Given user is logged in
    |huntero|TPjrHEaA|
    Then account number, balance and available amount are properly displayed

  Scenario: Account Details are matching on two pages
    Given user has seen Account Number, Balance and Available sum
      |kennedyw|7MMgivJq|
    When user is at Account Details screen
    Then values for all given parameters are matching






