Feature: National Park Geek

Scenario: Go to park details page
	Given I am on the home page
	When I click on a park image
	Then I am taken to the park details page
	
Scenario: Go to the survey
	Given I am on the home page
	When I click on the survey link
	And I enter my state PA
	And I enter my email address ron@techelevator.com
	And I submit my survey
	Then I am taken to a survey results page

Scenario: Go to the home page
	Given I am on the home page
	When I click on a park image
	And I click on home page link
	Then I am taken to the home page
#
#Scenario: Go to park details page
#	Given I am on the home page
#	When I click on a 
	
	
