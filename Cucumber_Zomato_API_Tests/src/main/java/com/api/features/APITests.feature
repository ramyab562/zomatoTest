Feature: Zomato API Tests

Scenario: Validate Zomato API Endpoint 
	
	Given user launches zomato app
	Then user is on Zomato endpoint page
	Then Validate get city details endpoint with valid userkey
	And  Validate endpont with 2 valid parameters
	And  Validate endpoint with count parameter
	And  Validate get city details endpoint with invalid userkey
	Then Quit the browser
	
	