@teams

Feature: Messaging
  This is the test about left teams

  Background:
    Given a team Created called "TheTeam"

  Scenario: left current team company
    Given I enter to a Team
    And I enter to the member settings
    When I remove to myself from this team
    Then the application should do logout
    And i should be redirected to the homepage

  Scenario: Delete a member from a team
    Given Have a team created
    And this team has the member "@JuanPeres"
    When I enter to the member settings
    And I remove that member
    And I accept the confirm message dialog
    Then the member should be removed from the members panel