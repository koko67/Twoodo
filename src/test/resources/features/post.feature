@post

Feature: Posting
    This File test contains all scenarios related with create posts in a team project

@Test
Scenario assign a TODO to a teammate
Given I have posted a TODO in a team
When I change the default assignee to another team member
Then a notification counter should be displayed in the team on the teams panel for the member who has assigned the TODO
    And clicking over that team the TODO should be displayed as a post in the posts in the right panel


@Test
Scenario Voting increments the counter
Given I posted a question
    And I vote for the yes option
When another team member votes also for the yes option
Then the counter for that answer should increments to 2
    And the two team members who voted the yes option appears in the vote


@Test
Scenario Voting has been closed
Given I Posted a question
    And I vote for the no option
When another team member votes for the yes option
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
Given I Create a Team called Test
    And I add a todo task to myself
When I finish this task with a check
    And I go to the tasks section
    And I select the "My completed tasks" option
Then the Completed task should appears in the panel of tasks
    And the task completed should be crossed out