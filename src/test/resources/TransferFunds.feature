Feature: Transfer funds

  As an existing Parabank user
  I can transfer funds between my accounts

  Scenario: Successful Transfer
    Given user is on Transfer Funds page
    When user has more than one account
    Then user can transfer chosen amount from one to another account
    And confirm that amounts on their both accounts changed accordingly

#  Transfer Complete!
#  $500.00 has been transferred from account #15453 to account #14676.
#
#  See Account Activity for more details.