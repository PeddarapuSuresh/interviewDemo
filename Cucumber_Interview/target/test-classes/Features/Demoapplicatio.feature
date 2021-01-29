Feature: verifying the application for QA 

Scenario: Creating the Demo application mockup 

Given When user loads application URL  
When verify the right count of values appear on the screen
Then verify the values on the screen are greater than 0
Then verify the total balance is correct based on the values listed on the screen
Then verify the values are formatted as currencies
Then verify the total balance matches the sum of the values

