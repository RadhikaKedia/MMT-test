package com.makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseClass.Keywords;

public class OneWayPage  {
	
	static WebElement webelem;
	static WebElement E;
	WebDriver driver;
	public static By loginPop = By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']");//Login Popup appearing
	public static By loginPopClos = By.xpath("//*[@id='SW']/div[1]/div[1]/ul/li[3]");//Closing the Login Popup
	public static By hindiPop = By.xpath("//*[@id='root']/div/div[2]/div/main/div[6]/span");//closing hindi Popup
	//public static By roundOpt =  By.xpath("//div[@class='makeFlex']/ul/li[2]");//Selecting RoundTrip option
	public static By fromBox = By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]"); //Selecting from Box
	public static By fromInput = By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input");//Entering input in the from box
	public static By clickDrop = By.id("react-autowhatever-1-section-0-item-0");//click first element from drop down
	public static By toBox = By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[2]");//Selecting To Box
	public static By toInput = By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input");//Entering input in the to box
	
	
	public static By deptDate = By.xpath("//div[@aria-label='Sat Oct 23 2021']//p[contains(text(),'23')]");//Selecting date in Departure option
	//public static By retDate =By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Day DayPicker-Day--selected']//p[.='26']");//Selecting date in Return option
	//public static By travel = By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[5]/label");//Selecting Traveller's option
	//public static By travApply = By.xpath("//div[@class='right makeFlex hrtlCenter']/button");//Applying the selected class
	public static By search = By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/p/a");//Clicking the search button
	//public static By pricePop = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div");//Waiting for popup to appear
	public static By popClose = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/span");//Closing the price Popup
	public static By popuFil = By.xpath("//span[contains(.,'+ 6 more')]");//To show all the filters in Popular Filter
	public static By selIndiGo = By.xpath("(//span[text()='IndiGo'])[1]");//To select Indigo
	public static By oneStop = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div/div[4]/div/label[2]/div/span[2]/span");//To Click One Stop checkbox
	public static By depFromMum = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div/div[5]/div/div/div[3]/span");//To Select Departure From Time
	public static By arrivalAtChennai = By.xpath("//div[@class='filterWrapper']/div[6]//div[.='After 6 PM']");//To Select Arrival At Time
//	public static By viewDetails = By.xpath("(//span[text()='View Flight Details'])[2]");//For Viewing Flight Details Of 2nd Result
//	public static By fareSummary = By.xpath("(//a[@id='flightDetailsTab-5000-tab-2'])[2]");//For Viewing the Fare Summary
//	
	public static By viewPrice = By.xpath("(//span[text()='View Prices']/parent::button)[2]");// For Viewing the Price of 2nd Result
	public static By bookWithPrice = By.xpath("//div[@class='collapse show']/div[@class='viewFaresOuter ']/div[3]//button[@class='button corp-btn latoBlack buttonPrimary fontSize13  ']");//Booking for Rs.6,678/- Flight
//	public static By morDepart = By.xpath("(//span[text()='Morning Departures'])[1]");//Morning Departure filter
//	public static By bookNow = By.xpath("//button[@class='splitFooterButton button buttonPrimary buttonBig ']");//Clicking BookNow button
//	public static By contButton = By.xpath("//button[@class='buttonPrimary buttonBig  lato-black button']");//Clicking continue on select fare window
	public static By bookPage = By.xpath("//h2[text()='Complete your booking']");//Complete Your Booking Page is displayed or not
	public static By travInsur= By.cssSelector(".insRadioSection:nth-child(2) .darkText");//Do not wish to secure trip option
	public static By addDetails = By.xpath("//button[@class='addTravellerBtn']");//To add details, clicking on plus sign
	public static By firstName = By.xpath("//input");//Entering first Name
	public static By lastName = By.xpath("//div[2]/div/input");//Entering Last Name
	public static By gender = By.xpath("//label[contains(.,'MALE')]");//Selecting gender
	public static By contDetails = By.cssSelector(".adultItemRow:nth-child(2)");//Entering details where booking details will be sent
	public static By mobileNo = By.xpath("//div[@id='Mobile No']/div/input");//To enter Mobile number
	public static By emailId = By.xpath("//*[@id='Email']/div/input");//To enter Email id
	public static By rarePopup = By.xpath("//*[@id='root']/div/div[2]/div[5]/div/div[2]/button"); //RarePopup 
	
	public static By revConf = By.xpath("//button[@class='button buttonPrimary buttonBig fontSize14']");//Review details confirmation 
	public static By freeSeat = By.xpath("//button[@class='lato-black button buttonPrimary buttonBig fontSize12']");//Clicking Yes please 
	public static By skipAddon = By.xpath("//span[text()='Skip to add-ons']");//Skipping the add-ons
	public static By proceedPay = By.xpath("//button[.='Proceed to pay']");//Proceed to pay button 
	//Review your booking page
	public static By notSecure = By.xpath("//span[text()='No, I do not wish to secure my trip']");//Click I do Not Wish Secure My Trip
	public static By proceed = By.id("review-continue");//Click Continue Button
	public static By name = By.xpath("//input[@placeholder='First & Middle Name']");//Input First And Middle Name
	public static By surname = By.xpath("//input[@placeholder='Last Name']");//Input Last Name
	public static By genderMale = By.xpath("//div[@class='append_bottom15']//div[@class='collapse in']//label[1]");//Clicking Male
	public static By mobNum = By.xpath("//input[@placeholder='Mobile No']");//Input Mobile No
	public static By email = By.xpath("//input[@placeholder='Email']");//Input Email
	public static By continueButton = By.xpath("//button[text()='Continue']");//Click Continue
	public static By confirm = By.xpath("//a[text()='CONFIRM']");//Click Confirm
	public static By skipButton= By.xpath("//a[text()='Skip to Payment']");//Click Skip To Payment
	public static By contAnyway = By.xpath("//a[text()='CONTINUE ANYWAY']");//Click Continue Anyway
	public OneWayPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public static WebElement getElement(WebDriver driver, By byvariable){
		
		E = driver.findElement(byvariable);
		
		return  E;
	}
	

	

}
