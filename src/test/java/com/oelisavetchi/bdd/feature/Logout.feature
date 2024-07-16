@tag
Feature: Logout from the Swag labs

  @Run @tag1
  Scenario Outline: Logout from the Swag labs
    Given User should login to swag labs using correct <Username> and <Password>
    And User should navigate to left sidebar
    When User click the logout button
    Then User should logout from Swag Labs

    Examples:
      | Username                  | Password       |
      | "standard_user"           | "secret_sauce" |
      | "problem_user"            | "secret_sauce" |
      | "performance_glitch_user" | "secret_sauce" |



 

   
   
 