@tag
Feature: Footer functionality
  User want to use functionalities in footer

@tag1
   Scenario Outline: Check whether footer is displayed
     Given user should login to swag labs using correct <Username> and <Password>
     Then user should see the footer
      
  Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" |

@tag2
   Scenario Outline: Check whether footer text is displaying correctly
     Given user should login to swag labs using correct <Username> and <Password>
     Then user should see the correct footer text
      
  Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" |
   
@tag3
   Scenario Outline: Check whether twitter is working correctly
     Given user should login to swag labs using correct <Username> and <Password>
     When user clicked the twitter icon
     Then user should navigate to swag labs twitter page
      
  Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" |
   

@tag4
   Scenario Outline: Check whether facebook is working correctly
     Given user should login to swag labs using correct <Username> and <Password>
     When user clicked the facebook icon
     Then user should navigate to swag labs facebook page
      
  Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" |  
   
@tag5
   Scenario Outline: Check whether linkedin is working correctly
     Given user should login to swag labs using correct <Username> and <Password>
     When user clicked the linkedin icon
     Then user should navigate to swag labs linkedin page
      
  Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" | 
