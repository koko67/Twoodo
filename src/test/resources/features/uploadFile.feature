@files

Feature: Upload files
  Test about upload files

Background:
Given I am logged on the page with user "jorgetop14@gmail.com" and Password "Control123"
  And a have a team "TheTeam" created

@uploadImage
Scenario: upload an image as a post in a voting
Given I navigate to files section
  And I select the team "TheTeam"
  And I upload an image with name "C:\cat.gif"
  And I type a question called "what to do with this image?"
  And I click in the ask question button
When I go to the team where I posted that image called "TheTeam"
Then the image uploaded should be displayed in the top of the posts