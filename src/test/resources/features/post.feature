@post

Feature: Posting
    This File test contains all scenarios related with create posts in a team project

Background:
Given a team Created called "TheTeam"
    And the Team has a member that is  "jorge.avila@fundacion-jalaorg"

@Test
Scenario assign a TODO to a teammate
Given I type the name o a member called "@javila"
And I type the TODO tag "#todo" with value "first task"
When I click in the button Add task
Then the new task should be added in the posts section
    And a notification counter should be displayed in the team on the teams panel for the member who has assigned the TODO
    And clicking over that team the TODO should be displayed as a post in the posts in the right section


@Test
Scenario Voting increments the counter
Given I post a voting question called "my question?"
    And I vote for the yes option
When another team member "jorge.avila@fundacion-jala.org" with password "Control123" do login
    And votes also for the yes option
Then the counter for that answer option in the voting should increments to 2
    And the two team members who voted the yes option appears in the vote


@Test
Scenario Voting has been closed
Given I Posted a voting question called "voting question"
    And I vote for the no option
When another team member "jorge,avila@fundacion-jala.org" with password do login
    And votes for the yes option
    And close the voting
Then the voting is disabled for all users
    And no one can continue voting


@Test
Scenario Voting has been closed
Given I Posted a question
    And I vote for the no option
When another team member votes for the yes option
    And close the voting
Then the voting is disabled for all users
    And no one can continue voting


Scenario Assign Tasks to myself and complete it
Given I Create a Team called "Test"
    And I add a todo task to myself
When I finish this task with a check
    And I go to the tasks section
    And I select the "My completed tasks" option
Then the Completed task should appears in the panel of tasks
    And the task completed should be crossed out