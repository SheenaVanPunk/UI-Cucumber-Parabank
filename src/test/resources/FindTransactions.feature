Feature: Find Transactions

Given I am an existing Parabank user
If I had made any transactions from my account/s
I should be able to find them using different parameters

  Scenario: Find a transaction by Transaction ID
    Given user is on Find Transactions Page
    |amccarty|1DL5OYvo|
    When user selects a targeted account
    And if user had any past transactions
    Then user should be able to look up for a transaction with using Transaction ID

  Scenario: Find a transaction by Date
    Given user is on Find Transactions Page
    When user selects a targeted account
    And if user had any past transactions
    Then user should be able to look up for a transaction by Date

  Scenario: Find a transaction by Date Range
    Given user is on Find Transactions Page
    When user selects a targeted account
    And if user had any past transactions
    Then user should be able to look up for a transaction by Date Range

  Scenario: Find a transaction by Amount
    Given user is on Find Transactions Page
    When user selects a targeted account
    And if user had any past transactions
    Then user should be able to look up for a transaction by its Amount