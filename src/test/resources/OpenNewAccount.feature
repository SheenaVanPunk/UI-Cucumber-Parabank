Feature: New account

  If I am an existing Parabank user
  and I am logged in
  I should be able to open a new account

  Scenario: Open a new account
    Given user is logged in
    And Account Services menu is displayed on the left
    When user attempts to open a new account
    Then a new account should be created