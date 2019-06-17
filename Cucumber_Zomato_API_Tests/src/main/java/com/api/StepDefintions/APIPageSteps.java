package com.api.StepDefintions;


import com.api.pages.APIPage;
import com.api.pages.Params;
import com.api.util.TestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class APIPageSteps extends TestBase {
	APIPage apiPage;
	Params params =  new Params();
	
	@Given("^user launches zomato app$")
	public void user_launches_zomato_app()  {
		TestBase.initialization();
	}

	@Then("^user is on Zomato endpoint page$")
	public void user_is_on_zomato_api_Page() {
		apiPage = new APIPage();
		String title = apiPage.verifyHomePageTitle();
		Assert.assertEquals("Zomato API", title);
		System.out.println("Successfuly on Zomato API Page");
	}

	@Then("^Validate get city details endpoint with valid userkey$")
	public void validate_getcitydetails_valid_userkey() throws InterruptedException {
		System.out.println("Now Validating the API with valid user key");
		params.api_key = prop.getProperty("apikey");
		String[] result = apiPage.validate_api_with_diff_valid_params(params);
		//System.out.println("Status is "+result[0]+ "," +result[1]);
		boolean Output = result[0].equalsIgnoreCase("200") && result[1].equalsIgnoreCase("success");
		//System.out.println("Output is " +Output);
		try {
			Assert.assertTrue(Output);
		} catch (AssertionError e) {
		    System.out.println("Not equal : Status is "+result[0]+ "," +result[1]);
		    throw e;
		}
		System.out.println("Result is Success with ResponseCode "+result[0]+" and Status "+result[1]);
	}

	@And("^Validate endpont with 2 valid parameters$")
	public void validate_api_with_2_parameters() throws InterruptedException {
		System.out.println("Now Validating the API with valid user key and City Name");
		driver.navigate().refresh();
		params.api_key = prop.getProperty("apikey");
		params.CityName = prop.getProperty("cityname");
		String[] result = apiPage.validate_api_with_diff_valid_params(params);
		System.out.println("Status is "+result[0]+ "," +result[1]);
		
		boolean Output =  (result[0]).equals("200") && (result[1]).equals("success") ;
		//System.out.println("Output is " +Output);
		try {
			Assert.assertTrue(Output);
		} catch (AssertionError e) {
		    System.out.println("Not equal : Status is "+result[0]+ "," +result[1]);
		    throw e;
		}
		System.out.println("Result is Success and "+result[2]+" Cities has Displayed");
		
	}

   
	@And("^Validate endpoint with count parameter$")
	public void validate_count_param() throws InterruptedException {
		System.out.println("Now Validating the API with valid user key and Display Cities with specified count");
		driver.navigate().refresh();
		params.api_key = prop.getProperty("apikey");
		params.CityName = prop.getProperty("cityname");
		params.Count = 5;

		String[] result = apiPage.validate_api_with_diff_valid_params(params);
		System.out.println("Status is "+result[0]+ "," +result[1]);
		
		boolean Output =  (result[0]).equals("200") && (result[1]).equals("success") && (result[2]).equals(String.valueOf(params.Count));
		//System.out.println("Output is " +Output);
		try {
			Assert.assertTrue(Output);
		} catch (AssertionError e) {
		    System.out.println("Not equal : Status is "+result[0]+ "," +result[1]+ "," +result[2]);
		    throw e;
		}
		System.out.println("Result is Success and "+result[2]+" Cities has Displayed");
	    	
	}
	
	@And("^Validate get city details endpoint with invalid userkey$")
	public void validate_with_invalid_user_key() throws InterruptedException{
		System.out.println("Now Validating the API with invalid user key/Negative Case");
		driver.navigate().refresh();
		
		//Providing the invalid API Key(Negative case)
		params.api_key = "4a2d96738d07ebfac7c3c3459b318";
		String[] result = apiPage.validate_api_with_diff_valid_params(params);
		
		boolean Output =  (result[0]).equals("403") && (result[1]).equals("Forbidden") ;

		try {
			Assert.assertTrue(Output);
		} catch (AssertionError e) {
		    System.out.println("Not equal : Status is "+result[0]+ "," +result[1]);
		    throw e;
		}
		System.out.println("Negative case is Success with expected result "+result[0]+"and "+result[1]);
	}
	
	@Then("^Quit the browser$") 
	public void quit_browser() {
		System.out.println("Now Close the browser");
		driver.quit();
	}
}
