@tag
Feature: Display login error messages

  @tag1
  Scenario Outline: Check the error message when login with blank username and password
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should see the correct error message

    Examples:
      | Username | Password |
      | ""       | ""       |

  @tag2
  Scenario Outline: Check the error message when login with blank username and some password
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should see the correct error message

    Examples:
      | Username | Password    |
      | ""       | "something" |

  @tag3
  Scenario Outline: Check the error message when login with some username and blank password
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should see the correct error message

    Examples:
      | Username    | Password |
      | "something" | ""       |


  @tag4
  Scenario Outline: Check the error message when login with wrong username and password
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should see the correct error message

    Examples:
      | Username    | Password     |
      | "something" | "somethings" |
   
   