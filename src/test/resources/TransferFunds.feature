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

  Scenario: Unsuccessful Transfer due to insufficient amount
    Given user is on Transfer Funds page
    When user tries to transfer bigger amount of money than it is available on chosen account
    Then transfer will be refused
    # a bug - it will show a transfer complete msg

  Scenario: Unsuccessful Transfer due to transfer attempt to same account
    Given user is on Transfer Funds page
    When user selects to transfer money to same account
    Then transfer will be refused
      # another bug - it will show a transfer complete msg