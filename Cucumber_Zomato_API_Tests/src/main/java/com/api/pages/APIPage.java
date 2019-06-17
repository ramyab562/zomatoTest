package com.api.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.api.util.TestBase;

public class APIPage extends TestBase {

	//Page Factory or Object Repository(OR)
	
	@FindBy(linkText="Get city details")
	WebElement GetCityDetailsLink;
	
	//Using the below xpath because this is unique
	@FindBy(xpath="//div[@id='common_cities_content']/form/table/tbody/tr/td[2]/input[contains(@name,'user-key')]")
	WebElement userkey;
	
	//Not using the below locator because it is not unique
	//@FindBy(name="q")
	@FindBy(xpath="//div[@id='common_cities_content']/form/table/tbody/tr[2]/td[2]/input[contains(@name,'q')]")
	WebElement cityName;
	
	//@FindBy(name="count")
	@FindBy(xpath="//div[@id='common_cities_content']/form/table/tbody/tr[6]/td[2]/input[contains(@name,'count')]")
	WebElement maxDisplaycount;
	
	@FindBy(xpath="//div[@id='common_cities_content']/form/div[3]/input")
	WebElement TryButton;
	
	@FindBy(xpath="//div[@id='common_cities_content']/div[3]/div[4]/pre")
	WebElement ResponseCode;
	
	@FindBy(xpath="//div[@id='common_cities_content']/div[3]/div[3]/pre/code/span[4]/span")
	WebElement StatusMessage;
	
	@FindBy(xpath="//div[@id='common_cities_content']/div[3]/div[3]/pre/code/span[2]")
	WebElement locationSuggestions;
	
	@FindBy(xpath="//div[@id='common_cities_content']/div[3]/div[3]/pre/code/span[2]/span[starts-with(text(),'id')]")
	List<WebElement> numberOfCities;
	
	//Initializing the above web elements(in this class) with driver using PageFactory initElements Method
	//Initializing the page Objects:
	public APIPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public String[] validate_api_with_diff_valid_params(Params params) throws InterruptedException {
		driver.findElement(By.id("cookie_msg_dismiss")).click();
		Thread.sleep(2000);
		
		//Clicking on get_city_details link on API Page
    	GetCityDetailsLink.click();
    	
    	//Scrolling down the page to the element to enter API_Key
    	APIPage.scrollToElement(userkey);
    	System.out.println("userkey2 " +params.api_key);
	    userkey.sendKeys(params.api_key);
	  
	    // Entering the parameters into the input field if they are not null
	    if(params.CityName!=null){
	       cityName.sendKeys(params.CityName);
	    }
	    
	    if(params.Count!=0){
	    	maxDisplaycount.sendKeys(String.valueOf(params.Count));
	    }
	    
	    APIPage.scrollToElement(TryButton);
	    TryButton.click();
	    String result[] = new String[3];
	    Thread.sleep(1000);
	    String responseCode = ResponseCode.getText();
	    String statusMessage = StatusMessage.getText();

	    List<WebElement> CityIds = numberOfCities;
	    int numberofCities = CityIds.size();

	    //Storing the Response code, Status Message and Number of Cities displayed into an Array
	    result[0] = responseCode;
	    result[1] = statusMessage.replaceAll("^\"+|\"+$", "");
	    result[2] = Integer.toString(numberofCities);

	    return result;
			
    }

	public static void scrollToElement(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		
	}

}
