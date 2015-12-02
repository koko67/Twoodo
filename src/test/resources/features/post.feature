@posts

Feature: Posting
    This File test contains all scenarios related with create posts in a team project

Background:
Given I am logged on the page with user "jorgetop14@gmail.com" and Password "Control123"
    And I have a team "TheTeam" created
    And the Team has a member that is "jorge.avila@fundacion-jala.org"


Scenario: assign a TODO to a teammate
Given I type the name "@javila" of a member in the post section
    And I click in the task button in the post section
    And I select the 'Add a #todo' button
    And I type a task name "first task"
When I perform the post
Then the new task should be added in the posts section
When I logout from the application
    And another team member "jorge.avila@fundacion-jala.org" with password "Control123" does login
    And I go to the company "Jala"
Then a notification counter should be displayed in the team
When I go to the Team created "TheTeam"
Then the new task should be added in the posts section


Scenario: Voting increments the counter
Given I post a voting question called "my question?"
    And vote for the "Yes" option
When I logout from the application
    And another team member "jorge.avila@fundacion-jala.org" with password "Control123" does login
    And I go to the company "Jala"
    And I go to the Team created "TheTeam"
    And vote for the "Yes" option
Then the counter for that answer option in the voting should increments to "2"


Scenario: Voting has been closed
Given I post a voting question called "voting question"
    And vote for the "No" option
When I logout from the application
    And another team member "jorge.avila@fundacion-jala.org" with password "Control123" does login
    And I go to the company "Jala"
    And I go to the Team created "TheTeam"
    And vote for the "Yes" option
    And close the voting
Then the voting is disabled for all users


Scenario: Assign Tasks to myself and complete it
Given I go to the Team created "TheTeam"
    And I click in the task button in the post section
    And I select the 'Add a #todo' button
    And I type a task name "MyTodo"
    And I click in the ask question button
When I finish this task with a check
    And I navigate to Tasks section
    And I select the 'My completed tasks' option
Then the Completed task should appears in the panel of tasks