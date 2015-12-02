@teamsAndMembers

Feature: Team Members
  This is the test about left teams

Background:
  Given I am logged on the page with user "jorgetop14@gmail.com" and Password "Control123"
    And I have a team "TheTeam" created

Scenario: Delete a team for redirecting to the default team company
  Given I go to the Team created "TheTeam"
    And I go to the team settings
  When I click the Delete team button
    And I confirm the dialog for deleting
  Then the application should redirect to the default team "Jala"
    And a notification message should be displayed

Scenario: Delete a member from a team
  Given I go to the Team created "TheTeam"
  When I add a new member with mail "jorge.avila@fundacion-jala.org"
  Then an information message should be displayed
  When I enter to the member settings of the team
    And I remove the member "@javila" from the team
    And I accept the confirm message dialog
  Then the member should be removed from the members panel