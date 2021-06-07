Feature: verify the application login functionality


Scenario Outline: validate the login with valid crentails
	Given I launch "<browserName>" browser with url as "<url>" 
	When I enter the username as "<username>" and password as "<password>"
	Then I validate the homepage with successfully login message
	
Examples:
|browserName|url|username|password|
|firefox|https://www.facebook.com/|test@test1.com|Test@1234|
|chrome|https://www.facebook.com/|test@test2.com|Test@1234|

Scenario Outline: validate the login with invalid crentails
	Given I launch "<browserName>" browser with url as "<url>" 
	When I enter the username as "<username>" and password as "<password>"
	Then I validate the homepage with successfully login message
	
Examples:
|browserName|url|username|password|
|firefox|https://www.facebook.com/|test@test1.com|Test@1234|
|chrome|https://www.facebook.com/|test@test2.com|Test@1234|
	