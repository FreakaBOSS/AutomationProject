@tag
Feature: Login to Swag lab page


  @tag1
  Scenario Outline: Login with valid credentials
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should navigate to Swag Labs home page

    Examples:
      | Username        | Password       |
      | "standard_user" | "secret_sauce" |
#      | "locked_out_user"         | "secret_sauce" |
      | "problem_user"  | "secret_sauce" |
#      | "performance_glitch_user" | "secret_sauce" |

  @tag2
  Scenario Outline: Check the login functionality with valid usernames and invalid passwords
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should not navigate to Swag Labs home page

    Examples:
      | Username        | Password        |
      | "standard_user" | "secrets_sauce" |
#   |"standard_user"|" "  |
#   |"standard_user"|""|
#   |"locked_out_user"|"secret_sauce" |
#   |"locked_out_user"|" " |
#   |"locked_out_user"|"" |
#   |"problem_user"|"wsecret_sauce" |
#   |"problem_user"|" " |
#   |"problem_user"|""  |
#   |"performance_glitch_user"|"secret_sauced" |
#   |"performance_glitch_user"|" "  |
#   |"performance_glitch_user"|""  |


  @tag3
  Scenario Outline: Check the login functionality with invalid username and valid password
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should not navigate to Swag Labs home page

    Examples:
      | Username     | Password       |
      | "wrong_user" | "secret_sauce" |

  @tag4
  Scenario Outline: Check the login functionality with invalid usernames and passwords
    Given user should navigate to swag labs login page
    When user enter the <Username> and <Password>
    And user click the login button
    Then user should not navigate to Swag Labs home page

    Examples:
      | Username     | Password        |
      | "wrong_user" | "wrog_password" |
#   |""|"secret_sauce" |
#   |" "|"" |
#   |" " |"secret_sauce" |
#   |"" |"" |
   
   
 # de combinat negative TC
