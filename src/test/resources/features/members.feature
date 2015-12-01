#@members
#
#  Feature: Members Management
#    This file test contains the scenarios for managing of team members
#
#
#  Scenario: assign a new member to a new Team
#  Given I have a team created called "TheTeam"
#    And I add a new member to this team with email "jorge.avila@fundacion-jala.org"
#    And I post a new content in that team that is "Welcome all"
#  When When the new member do login with credentials user "jorge.avila@fundacion-jala.org" with password "Control123"
#  Then the team should be displayed in the companies of the member added
#    And the post should be displayed in the posts of that team