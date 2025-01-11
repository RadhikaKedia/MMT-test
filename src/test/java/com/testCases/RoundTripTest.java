package com.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseClass.Keywords;
import com.makemytrip.LoginPage;
import com.makemytrip.OneWayPage;
import com.makemytrip.RoundTrip;

public class RoundTripTest extends Keywords
{
	JavascriptExecutor js;
	RoundTrip rt;
	String Page2 = "";

	@Test(priority = 1)
	public void handlingPopup() throws Exception 
	{

		try 
		{
			implicitwait(10);
			logger.info("RoundTrip TestCase 1: Closing the Popups appearing on screen");
			explicitWait(20, By.xpath(readlocator("loginPop_xpath"))); // waiting for login popup
			rt.getElement(driver, By.xpath(readlocator("loginPopClos"))).click(); // closing login popup
			rt.getElement(driver, By.xpath(readlocator("hindiPop"))).click(); // Closing Available In Hindi Popup

		} 
		catch (Exception e) 
		{
			//takeSnap("loginSignupbtnFail");
			Reporter.log("FAIL");
			logger.error("RoundTrip TestCase 1 Failed");
		}

	}
	
	
	@Test(priority = 2)
	public void selectReturn() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 2: Choosing Return option");
			rt.getElement(driver, By.xpath(readlocator("roundOpt"))).click(); // Selecting round trip option
			
			
		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			
		}

	}

	@Test(priority = 3)
	public void selectFromCity() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 3: Choosing Source Location");
			rt.getElement(driver, By.xpath(readlocator("fromBox"))).click(); // Selecting from Box
			rt.getElement(driver, By.xpath(readlocator("fromInput"))).sendKeys(getRoundTripData("LocDetails", 1, 0)); // Entering input in the from box
			Thread.sleep(2000);
			rt.getElement(driver, By.xpath(readlocator("fromInput"))).sendKeys(Keys.DOWN);    //Selecting first element from drop down
			rt.getElement(driver, By.xpath(readlocator("fromInput"))).sendKeys(Keys.ENTER);
		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("selectFromCity() Failed");
		}

	}

	@Test(priority = 4)
	public void selectToCity() throws Exception {

		try {
			logger.info("RoundTrip TestCase 4: Choosing Destination Location");
			implicitwait(30);
			rt.getElement(driver, By.xpath(readlocator("toBox"))).click(); // Selecting toBox
			rt.getElement(driver, By.xpath(readlocator("toInput"))).sendKeys(getRoundTripData("LocDetails", 1, 1)); // Entering input in the to box
			Thread.sleep(1000);
			rt.getElement(driver, By.xpath(readlocator("toInput"))).sendKeys(Keys.DOWN);
			rt.getElement(driver, By.xpath(readlocator("toInput"))).sendKeys(Keys.ENTER); // click first element from drop down
			Thread.sleep(2000);

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			
		}

	}

	@Test(priority = 5)
	public void departureOption() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 5: Choosing Departure Date");
			rt.getElement(driver, By.xpath(readlocator("deptDate"))).click(); // Selecting Date
			

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("departureOption() Failed");
		}

	}
	
	@Test(priority = 6)
	public void returnOption() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 6: Choosing Return Date");
			
			JavascriptExecutor sc = (JavascriptExecutor) driver;
			sc.executeScript("window.scrollBy(0,100)");
			rt.getElement(driver, By.xpath(readlocator("retDate"))).click(); // Selecting Date
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("returnOption() Failed");
		}

	}
	
	
	@Test(priority = 7)
	public void travellers() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 7: Selecting Travellers and class option");
			Thread.sleep(2000);
			rt.getElement(driver, By.xpath(readlocator("travel"))).click(); // Clicking the Travel option
			rt.getElement(driver, By.xpath(readlocator("travApply"))).click(); //Applying the changes

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("travellers() Failed");
		}

	}

	@Test(priority = 8)
	public void clickSearch() throws Exception 
	{

		try 
		{
			logger.info("RoundTrip TestCase 8: Clicking Search Button");
			rt.getElement(driver, By.xpath(readlocator("searchButton"))).click(); // Click Search

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			//Assert.fail("clickSearch() Failed");
		}

	}

	@Test(priority = 9)
	public void closePopup() throws Exception {

		try {
			logger.info("RoundTrip TestCase 9: Closing Popup");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean exists=false;
			
	        try
	        {
	            rt.getElement(driver, By.xpath(readlocator("pricePop")));    //Waiting for popup to appear
	            exists = true;
	        }

	        catch (Exception e)
	        {
	            exists = false;
	        }

	        if (exists)
	        {
	            try
	            {
	            	rt.getElement(driver, By.xpath(readlocator("popClose"))).click();    //Closing the popup
	            }
	            catch (ElementNotVisibleException b) 
	            {
	                exists = false;
	            }

	        }

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			//Assert.fail("closePopup() Failed");
		}

	}

	@Test(priority = 10)
	public void popularFiltersSelect() throws Exception {

		try {
			logger.info("RoundTrip TestCase 10: Choosing Popular Filters");
			rt.getElement(driver, By.xpath(readlocator("popuFil"))).click(); // Click + 6 more
			rt.getElement(driver, By.xpath(readlocator("morDepart"))).click(); // To Select Morning Departure option

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 11)
	public void bookingFlight() throws Exception {

		try {
			logger.info("RoundTrip TestCase 11: Booking the Flight");
			rt.getElement(driver, By.xpath(readlocator("book"))).click(); //Clicking Book Now
			rt.getElement(driver, By.xpath(readlocator("contButton"))).click(); //Clicking continue on the selecting fare page

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 12)
	public void handlingWindows() throws Exception {

		try {
			logger.info("RoundTrip TestCase 12: Window Handling ");
			String parent = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();

			// Iterate using Iterator
			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {

				String child_window = I1.next();

				if (!parent.equals(child_window)) {

					driver.switchTo().window(child_window);

				}

			}

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 13, enabled = true)
	public void pageSelection1() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 13: Booking Page displayed or not ");
			implicitwait(10);
			Page2 = rt.getElement(driver, By.xpath(readlocator("bookPage"))).getText();//Checking if Booking Page is displayed

			if (Page2.contains("Complete your"))

				implicitwait(10);
			else
				Assert.fail("Booking Page Not Found");

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			Assert.fail("Booking Page Not Found");

		}

	}

	@Test(priority = 14, dependsOnMethods = "pageSelection1")
	public void passengerDetails() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 14: Entering Passenger Details ");

			rt.getElement(driver, By.cssSelector(readlocator("travInsur"))).click(); // Do not wish to secure trip option
			Thread.sleep(2000);
			explicitWait(20, By.xpath(readlocator("addDetails")));
			Thread.sleep(2000);
			rt.getElement(driver, By.xpath(readlocator("addDetails"))).click();
			rt.getElement(driver, By.xpath(readlocator("firstName"))).click();
			rt.getElement(driver, By.xpath(readlocator("firstName"))).sendKeys(getRoundTripData("Details", 1, 0));
			rt.getElement(driver, By.xpath(readlocator("lastName"))).click();
			rt.getElement(driver, By.xpath(readlocator("lastName"))).sendKeys(getRoundTripData("Details", 1, 1));
			rt.getElement(driver, By.xpath(readlocator("gender"))).click();
			rt.getElement(driver, By.cssSelector(readlocator("contDetails"))).click();
			rt.getElement(driver, By.xpath(readlocator("mobileNo"))).click();
			rt.getElement(driver, By.xpath(readlocator("mobileNo"))).sendKeys(Keys.CLEAR);
			rt.getElement(driver, By.xpath(readlocator("mobileNo"))).sendKeys(getRoundTripData("Details", 1, 2));
			rt.getElement(driver, By.xpath(readlocator("mobileNo"))).sendKeys(Keys.TAB);
			rt.getElement(driver, By.xpath(readlocator("emailIds"))).sendKeys(getRoundTripData("Details", 1, 3));
			rt.getElement(driver, By.xpath(readlocator("emailIds"))).sendKeys(Keys.TAB);

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 15, dependsOnMethods = "pageSelection1")
	public void confirmProceedClick() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 15: Clicking on Continue after entering details ");

			Robot robot = new Robot();
			// Press key Enter Multiple Times To Confirm Details
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 16, dependsOnMethods = "pageSelection1")
	public void rarePopupHandling() throws Exception {

		try {
			logger.info("RoundTrip TestCase 16: If Rare Popup comes ");

			explicitWait(10, By.xpath(readlocator("rarePopup")));
			rt.getElement(driver, By.xpath(readlocator("rarePopup"))).click();    //Handling the popup that appears rarely

		} catch (Exception e) {

		}

	}

	@Test(priority = 17, dependsOnMethods = "pageSelection1")
	public void selectingSeats() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 17: Selecting seats page ");
			// op.getElement(driver, op.revConf).click();//Review details confirmation

			Thread.sleep(2000);
			rt.getElement(driver, By.xpath(readlocator("freeSeat"))).click(); // Clicking Yes please
			Thread.sleep(3000);
			rt.getElement(driver, By.xpath(readlocator("skipAddon"))).click(); // Skipping the add-ons

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 18, dependsOnMethods = "pageSelection1")
	public void proceedToPay() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 18: Clicking on proceed to pay ");

			rt.getElement(driver, By.xpath(readlocator("proceedPay"))).click(); // Clicking Yes please

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 19)
	public void pageSelection2() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 19: If the other booking page is displayed ");

			Thread.sleep(4000);
			rt.getElement(driver, By.xpath(readlocator("notSecure"))).click();// Click I do Not Wish Secure My Trip in 2nd Page

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			Assert.fail("Not In Page two");

		}

	}

	@Test(priority = 20, dependsOnMethods = "pageSelection2")
	public void proceed() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 20: Clicking on proceed button ");

			Thread.sleep(3000);
			rt.getElement(driver, By.id(readlocator("proceed"))).click(); //Click Continue Button

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 21, dependsOnMethods = "pageSelection2")
	public void inputDetails() throws Exception {

		try {
			
			logger.info("RoundTrip TestCase 21: Entering passenger details ");

			Thread.sleep(3000);
			rt.getElement(driver, By.xpath(readlocator("name"))).sendKeys(getRoundTripData("Details", 1, 0));// Input First Name
			rt.getElement(driver, By.xpath(readlocator("surname"))).sendKeys(getRoundTripData("Details", 1, 1));// Input Last Name
			rt.getElement(driver, By.xpath(readlocator("genderMale"))).click(); // Select Gender Male
			rt.getElement(driver, By.xpath(readlocator("mobNum"))).sendKeys(getRoundTripData("Details", 1, 2)); // Input Mobile No
			rt.getElement(driver, By.xpath(readlocator("email"))).sendKeys(getRoundTripData("Details", 1, 3)); // Input Email

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 22, dependsOnMethods = "pageSelection2")
	public void confirmDetails() throws Exception {

		
		
		try {
			
			logger.info("RoundTrip TestCase 22: Confirming the details entered"
					+ " ");

			rt.getElement(driver, By.xpath(readlocator("continueButton"))).click(); // Click Continue
			Thread.sleep(2000);
			rt.getElement(driver, By.xpath(readlocator("confirm"))).click();  //Click Confirm
			Thread.sleep(2000);
			rt.getElement(driver, By.xpath(readlocator("skipButton"))).click(); // Click Skip To Payment
			Thread.sleep(2000);
			rt.getElement(driver, By.xpath(readlocator("contAnyway"))).click(); // Click Continue Anyway
			Thread.sleep(5000);
		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}


}
