Feature: verify the application login functionality


Scenario Outline: validate the login with valid crentails
	Given I launch <browserName> browser with <url> url
	When I enter the username as <> and password as <>
	Then I validate the homepage with successfully login message
	
Examples:
|browserName|url|username|password|
|chrome|https://www.facebook.com/|test@test.com|Test@1234|
|chrome|https://www.facebook.com/|test@test.com|Test@1234|
	