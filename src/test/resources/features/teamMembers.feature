@teams

Feature: Team Members
  This is the test about left teams

Background:
  Given I navigate to Login Page
    And I Login as "jorgetop14@gmail.com" with Password "Control123"
    And a team Created called "TheTeam"


Scenario: left current team company
  Given I enter to a Team created called "TheTeam"
    And I enter to the team settings
  When I click the Delete team button of the current team
    And I confirm the dialog for deleting
  Then the application should to redirect to the default team Called "Jala"
    And a notification message should be displayed with the teamname deleted

Scenario: Delete a member from a team
  Given I enter to a Team created called "TheTeam"
  When I add a new member with mail "jorge.avila@fundacion-jala.org" in that team
  Then an information message should be displayed
  When I enter to the member settings of the team
    And I remove that member who has a user name "@javila"
    And I accept the confirm message dialog
  Then the member should be removed from the members panel