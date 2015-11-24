@files

Feature: Upload files
  Test about upload files

Scenario: upload an image as a post in a voting
Given I navigate to files section
  And I select the team "jala"
  And I upload an image with path "..\resources\image.png"
  And I type a question called "what to do with this image?"
  And I click in the ask question button
When I go to the team where I posted that image called "jala"
Then the image uploaded should be displayed in the top of the posts
  And the question posted should be displayed with that image