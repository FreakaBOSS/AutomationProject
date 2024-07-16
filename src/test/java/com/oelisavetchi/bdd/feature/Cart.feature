@tag
Feature: Cart functionality
  User want to use all cart functions correctly

@tag1
   Scenario Outline: Check whether user can see the cart badge get updated when add items to cart
     Given user should login to swag labs using correct <Username> and <Password>
     When user click the add to cart button <itemNumber>
     Then user should see the updated cart badge
      
  Examples: 
   |Username | Password |itemNumber|
   |"standard_user"|"secret_sauce" |0|
   |"problem_user"|"secret_sauce" |0|
   |"performance_glitch_user"|"secret_sauce" |0|
   |"standard_user"|"secret_sauce" |1|
   |"problem_user"|"secret_sauce" |1|
   |"performance_glitch_user"|"secret_sauce" |1|
   |"standard_user"|"secret_sauce" |2|
   |"problem_user"|"secret_sauce" |2|
   |"performance_glitch_user"|"secret_sauce" |2|
   |"standard_user"|"secret_sauce" |3|
   |"problem_user"|"secret_sauce" |3|
   |"performance_glitch_user"|"secret_sauce" |3|
   |"standard_user"|"secret_sauce" |4|
   |"problem_user"|"secret_sauce" |4|
   |"performance_glitch_user"|"secret_sauce" |4|
   |"standard_user"|"secret_sauce" |5|
   |"problem_user"|"secret_sauce" |5|
   |"performance_glitch_user"|"secret_sauce" |5|
   
   
@tag2
   Scenario Outline: Check whether user can see the remove button when add items to cart
     Given user should login to swag labs using correct <Username> and <Password>
     When user click the add to cart buttons
     Then user should see the remove button
     
    Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" |
     
   
@tag3
   Scenario Outline: Check whether user can see the full product view
     Given user should login to swag labs using correct <Username> and <Password>
     When user click the product title <itemNumber>
     Then user should see the full product view
     
    Examples: 
   |Username | Password |itemNumber|
   |"standard_user"|"secret_sauce" |0|
   |"problem_user"|"secret_sauce" |0|
   |"performance_glitch_user"|"secret_sauce" |0|
   |"standard_user"|"secret_sauce" |1|
   |"problem_user"|"secret_sauce" |1|
   |"performance_glitch_user"|"secret_sauce" |1|
   |"standard_user"|"secret_sauce" |2|
   |"problem_user"|"secret_sauce" |2|
   |"performance_glitch_user"|"secret_sauce" |2|
   |"standard_user"|"secret_sauce" |3|
   |"problem_user"|"secret_sauce" |3|
   |"performance_glitch_user"|"secret_sauce" |3|
   |"standard_user"|"secret_sauce" |4|
   |"problem_user"|"secret_sauce" |4|
   |"performance_glitch_user"|"secret_sauce" |4|
   |"standard_user"|"secret_sauce" |5|
   |"problem_user"|"secret_sauce" |5|
   |"performance_glitch_user"|"secret_sauce" |5|

 @tag4
   Scenario Outline: Check whether user can see the cart items added to cart
     Given user should login to swag labs using correct <Username> and <Password>
     When user click the add to cart buttons
     And user click the cart icon
     Then user should see the cart items added to cart
 
   Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" |
     
 @tag5
   Scenario Outline: Check whether user can remove cart items from cart
     Given user should login to swag labs using correct <Username> and <Password>
     And user click the add to cart buttons
     And user click the cart icon
     When user click the remove buttons
     Then user should see the cart without removed item
 
   Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" | 
     
   
 @tag6
   Scenario Outline: Check whether user can go to products when full product view
     Given user should login to swag labs using correct <Username> and <Password>
     And user click the product title <itemNumber>
     When user click the back to products button
     Then user should see the product page
     
  Examples: 
   |Username | Password |itemNumber|
   |"standard_user"|"secret_sauce" |0|
   |"problem_user"|"secret_sauce" |0|
   |"performance_glitch_user"|"secret_sauce" |0|
     
 @tag7
   Scenario Outline: Check whether user can go to shop from cart
     Given user should login to swag labs using correct <Username> and <Password>
     And user click the add to cart buttons
     And user click the cart icon
     When user click the continue shopping button
     Then user should see the product page
 
   Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" |     
  
 @tag8
   Scenario Outline: Check whether user can go to checkout from cart
     Given user should login to swag labs using correct <Username> and <Password>
     And user click the add to cart buttons
     And user click the cart icon
     When user click the checkout button
     Then user should see the checkout info page
 
   Examples: 
   |Username | Password |
   |"standard_user"|"secret_sauce" |
   |"problem_user"|"secret_sauce" |
   |"performance_glitch_user"|"secret_sauce" | 