@directMessage

Feature: Messaging
    This is the test about sending messages between members in a team

Background:
Given I navigate to Login Page
    And I Login as "jorgetop14@gmail.com" with Password "Control123"
    And I have a team "TheTeam" created
    And the Team has a member that is "jorge.avila@fundacion-jala.org"

Scenario: Send a message to a team member
Given I go to the Team created "TheTeam"
    And I select the member of that team that is "@javila"
When I send a direct message to that team member as "Hi there"
Then the destination member should has a notification when this do login
    And the message must be the same that I sent