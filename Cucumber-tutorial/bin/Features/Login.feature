Feature: Test login functionality
Scenario: Check login is successful with valid credentials
Given Browser is open
And User is on login page
When User enters <username> and <password>
And User clicks on login
Then Performing log-out

   
