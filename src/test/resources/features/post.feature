@posts

Feature: Posting
    This File test contains all scenarios related with create posts in a team project

Background:
Given I am logged on the page with user "jorgetop14@gmail.com" and Password "Control123"
    And a have a team "TheTeam" created
    And I add a new member with mail "jorge.avila@fundacion-jala.org" in that team


Scenario: assign a TODO to a teammate
Given I type the name "@javila" of a member in the post section
    And I click in the task button in the post section
    And I select the 'Add a #todo' button
    And I type a task name "first task"
When I perform the post
Then the new task should be added in the posts section
When I logout from the application
    And I Login as "jorge.avila@fundacion-jala.org" with Password "Control123"
    And I go to the company "Jala"
Then a notification counter should be displayed in the team
When I go to the Team created "TheTeam"
Then the new task should be added in the posts section
#
#

#Scenario: Voting increments the counter
#Given I post a voting question called "my question?"
#    And I vote for the yes option
#When another team member "jorge.avila@fundacion-jala.org" with password "Control123" does login
#    And votes also for the yes option
#Then the counter for that answer option in the voting should increments to 2
#    And the two team members who voted the yes option appears in the vote
#
#
#@Test
#Scenario Voting has been closed
#Given I Posted a voting question called "voting question"
#    And I vote for the no option
#When another team member "jorge,avila@fundacion-jala.org" with password do login
#    And votes for the yes option
#    And close the voting
#Then the voting is disabled for all users
#    And no one can continue voting
#
#
#Scenario Assign Tasks to myself and complete it
#Given I Create a Team called "Test"
#    And I add a todo task to myself
#When I finish this task with a check
#    And I go to the tasks section
#    And I select the "My completed tasks" option
#Then the Completed task should appears in the panel of tasks
#    And the task completed should be crossed out