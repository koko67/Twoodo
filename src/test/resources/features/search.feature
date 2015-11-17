@search

Feature: Searching
  this file test contains all scenarios related with search something in a company

Background:
  Given I navigate to Login Page
  And I Login as "jorgetop14@gmail.com" with Password "Control123"
  And I posted "yellowSubmarine"

Scenario: make a search of something that was posted or sent in a company
  Given I enter a text to search
  When I click in the search button
  Then a result with the text entered should be displayed in the search content