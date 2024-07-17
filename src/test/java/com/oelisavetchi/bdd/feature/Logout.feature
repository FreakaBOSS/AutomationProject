@tag
Feature: Logout from the Swag labs

  @Run @tag1
  Scenario Outline: Logout from the Swag labs
    Given user should login to swag labs using correct <Username> and <Password>
    And user should navigate to left sidebar
    When user click the logout button
    Then user should logout from Swag Labs

    Examples:
      | Username                  | Password       |
      | "standard_user"           | "secret_sauce" |
      | "problem_user"            | "secret_sauce" |
      | "performance_glitch_user" | "secret_sauce" |