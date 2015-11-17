@login
Feature: Login
test Successfully and unsuccessfully login logout

@smokeTest
Scenario: OutlineUsers should be able to login using valid credentials
Given I navigate to Login Page
When I Login as "jorgetop14@gmail.com" with Password "Control123"
Then I should login to

#
#@smokeTest
#Scenario Outline: Users should be able to login using valid credentials
#Given I navigate to Login Page
#When I Login as "<User Name>" with Password "<Password>"
#Then I should login to
#
#  Examples:
#| User Name              | Password |
#| jorgetop14@gmail.com   | L0b3vu5z |
#| jorge_top14@yahoo.com  | L0b3vu5z |