Feature: Accounts Overview

  In order to access my banking
  As a logged in user
  I can see my account overview and details

  Scenario: Account Table content is properly displayed
    Given user is logged in
    Then they can see account number, balance and available amount


  Scenario: User can see account details
    Given user is logged in
    When they want to see account details
    Then they see Account Number, Account Type, Balance, Available

  Scenario: User can check account activity
    Given user is at Account Details screen
    When they select Activity Period and Account Type
    Then they can see their account activity for the chosen period and account



