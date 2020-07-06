Feature: Apply for a Loan

  As an existing Parabank user
  If I have sufficient funds and I provide expected down payment
  I can apply for a loan

  Scenario: Smaller down payment than expected
    Given user is on Loan Request page
    |isabellaa|7MQqr2Mo|
    When user submits a down payment smaller than 20% of requested loan amount
    Then user will be denied for loan

#  Loan Request Processed
#  Loan Provider:	Wealth Securities Dynamic Loans (WSDL)
#  Date:	07-4-2020
#  Status:	Denied
#
#  We cannot grant a loan in that amount with the given down payment.

  Scenario: Insufficient funds for down payment
    Given user is on Loan Request page
    And user provides a higher down payment than available on primary account
    Then user will be denied for loan

#  Loan Request Processed
#  Loan Provider:	Wealth Securities Dynamic Loans (WSDL)
#  Date:	07-4-2020
#  Status:	Denied
#
#  You do not have sufficient funds for the given down payment.

  Scenario: Loan approved
    Given user is on Loan Request page
    And user provides a down payment high enough for the desirable loan amount
    And user has sufficient funds on primary account
    Then loan will be approved
    And new account will be listed at Accounts Overview page

#      Loan Request Processed
#      Loan Provider:	Wealth Securities Dynamic Loans (WSDL)
#      Date:	07-4-2020
#      Status:	Approved
#
#      Congratulations, your loan has been approved.
#
#      Your new account number: 15453

