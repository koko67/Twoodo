@members

  Feature: Members Management
    This file test contains the scenarios for managing of team members

  @Test
  Scenario assign a new member to a Team
  Given I have a team created
  When I add a new team member user to this team
  Then the team shoul be displayed in the companies of the member added