Feature: Pay for a bill

  As an existing Parabank user
  I can pay a bill

  Scenario: Pay a bill
    Given user is at Bill Pay page
    When user enters valid payee information
    Then user can succeffully pay a bill
    And the same amount will deduct from chosen account