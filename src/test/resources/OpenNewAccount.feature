Feature: New account

  As an existing Parabank user
  when I am logged in
  I should be able to open a new account

  Scenario: User can choose between Checking and Savings account
    Given user is at Open Account page
    Then options for opening a new account would be "Checking" and "Savings"

  Scenario: User must previously have an account to open a new one
    Given user is at Open Account page
    Then user will see their account number in dropdown
    And user will see instruction message

  Scenario: Open a new account
    Given user is at Open Account page
    And Account Services menu is displayed on the left
    When user attempts to open a new account
    Then a new account should be created
