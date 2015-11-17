@login
Feature: Login
test Successfully and unsuccessfully login logout

@smokeTest
Scenario: OutlineUsers should be able to login using valid credentials
Given I navigate to Login Page
When I Login as "jorgetop14@gmail.com" with Password "Control123"
Then I should login to

