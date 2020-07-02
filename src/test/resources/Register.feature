Feature: Registration
  In order to start using Parabank services
  As a new user
  I can register a new account


  Scenario: Successful Registration
    Given user wants to register an account
    When they enter valid data
    Then new account is created


