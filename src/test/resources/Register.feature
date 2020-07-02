Feature: Registration
  In order to start using Parabank services
  As a new user
  I can register a new account


  Scenario: Successful Registration
    Given user wants to register an account
    When they enter valid <data>
#      | Drake | Mrakovic | Ontario Street 45 | Hamilton | Canada | T6P F3C | 90876578483 | 778990774 | drake | mrakovic |
    Then new account is created


