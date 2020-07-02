Feature: Login Functionality

  In order to do the internet banking
  As a valid Parabank customer
  I want to login successfully

  Scenario: Login Successful
    Given user is on the index of the Parabank Application
    When user enters valid credentials
      | nenatester | Test@123 | nenatester nenatester |
    Then they should be taken to the Overview page


  Scenario Outline: Login Unsuccessful
    Given user is on the index of the Parabank Application
    When user enters invalid <username> and <password>
    Then they should see appropriate error

    Examples:
      | username | password   |
      | "tester" | "Test@123" |
      | "branko" | "kockica"  |











