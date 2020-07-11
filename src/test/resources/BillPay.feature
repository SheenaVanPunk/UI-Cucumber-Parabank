Feature: Pay for a bill

  As an existing Parabank user
  I can pay a bill

  Scenario: Pay a bill
    Given user is at Bill Pay page
    When user enters valid payee information
    Then user can successfully pay a bill
    And same amount will be deducted from chosen account

#  Bill Payment Complete
#  Bill Payment to fgdktu in the amount of $1.00 from account 14121 was successful.
#
#  See Account Activity for more details.