@search

Feature: Searching
  this file test contains all scenarios related with search something in a company

Background:
  Given I am logged on the page with user "jorgetop14@gmail.com" and Password "Control123"
  And I posted "yellowSubmarine"

Scenario: Make a search of something that was posted or sent in a company
  Given I enter a text to search that is "yellowSubmarine"
  When I click in the search button
  Then a result with the text entered should be displayed in the search content