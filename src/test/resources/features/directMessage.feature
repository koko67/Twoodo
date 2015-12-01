@directMessage

Feature: Messaging
    This is the test about sending messages between members in a team

Background:
Given I am logged on the page with user "jorgetop14@gmail.com" and Password "Control123"
    And I have a team "TheTeam" created
    And the Team has a member that is "jorge.avila@fundacion-jala.org"

Scenario: Send a message to a team member
Given I go to the Team created "TheTeam"
    And I select the member of that team that is "@javila"
When I send a direct message to that team member as "Hi there"
    And I logout from the application
    And I Login as "jorge.avila@fundacion-jala.org" with Password "Control123"
    And I go to the company "Jala"
    And I go to the Team created "TheTeam"
Then the destination member should has a notification when this do login
    And the message must be the same that I sent