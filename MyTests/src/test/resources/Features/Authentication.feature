Feature: Automate Form Authentication

  Scenario Outline: Try to login with correct username and wrong password and assert login
    Given User is on the Login page
    When User enters <username> and <password>
    Then User fails in login and an error message is shown

    Examples: 
      | username | password |
      | tomsmith | uj123!a  |

  Scenario Outline: Try to login with correct username and password and assert login validation
    Given User is on the Login page
    When User enters <username> and <password>
    Then User should be able to login sucessfully and a secure page opens

    Examples: 
      | username | password             |
      | tomsmith | SuperSecretPassword! |

  Scenario Outline: Try to login with correct username and password and then logout
    Given User is on the Login page
    When User enters <username> and <password>
    Then User should be able to login sucessfully and a secure page opens
    When User clicks on logout
    Then User returns to the login page

    Examples: 
      | username | password             |
      | tomsmith | SuperSecretPassword! |
