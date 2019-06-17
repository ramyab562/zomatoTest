$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/navee/workspace/Cucumber_Zomato_API_Tests/src/main/java/com/api/features/APITests.feature");
formatter.feature({
  "line": 1,
  "name": "Zomato API Tests",
  "description": "",
  "id": "zomato-api-tests",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Validate Zomato API Endpoint",
  "description": "",
  "id": "zomato-api-tests;validate-zomato-api-endpoint",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user launches zomato app",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user is on Zomato endpoint page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Validate get city details endpoint with valid userkey",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Validate endpont with 2 valid parameters",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Validate endpoint with count parameter",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Validate get city details endpoint with invalid userkey",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Quit the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "APIPageSteps.user_launches_zomato_app()"
});
formatter.result({
  "duration": 8861777390,
  "status": "passed"
});
formatter.match({
  "location": "APIPageSteps.user_is_on_zomato_api_Page()"
});
formatter.result({
  "duration": 112956535,
  "status": "passed"
});
formatter.match({
  "location": "APIPageSteps.validate_getcitydetails_valid_userkey()"
});
formatter.result({
  "duration": 26306202084,
  "status": "passed"
});
formatter.match({
  "location": "APIPageSteps.validate_api_with_2_parameters()"
});
formatter.result({
  "duration": 5625729974,
  "status": "passed"
});
formatter.match({
  "location": "APIPageSteps.validate_count_param()"
});
formatter.result({
  "duration": 5319003643,
  "status": "passed"
});
formatter.match({
  "location": "APIPageSteps.validate_with_invalid_user_key()"
});
formatter.result({
  "duration": 25428231333,
  "status": "passed"
});
formatter.match({
  "location": "APIPageSteps.quit_browser()"
});
formatter.result({
  "duration": 739783445,
  "status": "passed"
});
});