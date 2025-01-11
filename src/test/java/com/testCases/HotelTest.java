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
import com.makemytrip.HotelPage;
import com.makemytrip.LoginPage;
import com.makemytrip.OneWayPage;
import com.makemytrip.RoundTrip;

public class HotelTest extends Keywords
{
	JavascriptExecutor js;
	HotelPage hp;
	String Page2 = "";

	@Test(priority = 1)
	public void handlingPopup() throws Exception 
	{

		try 
		{
			implicitwait(10);
			logger.info("RoundTrip TestCase 1: Closing the Popups appearing on screen");
			explicitWait(20, By.xpath(readlocator("loginPop_xpath"))); // waiting for login popup
			hp.getElement(driver, By.xpath(readlocator("loginPopClos"))).click(); // closing login popup
			hp.getElement(driver, By.xpath(readlocator("hindiPop"))).click(); // Closing Available In Hindi Popup

		} 
		catch (Exception e) 
		{
			//takeSnap("loginSignupbtnFail");
			Reporter.log("FAIL");
			logger.error("RoundTrip TestCase 1 Failed");
		}

	}
	
	
	@Test(priority = 2)
	public void selectHotels() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 2: Selecting Hotel");
			hp.getElement(driver, By.xpath(readlocator("hotelOpt"))).click(); // Selecting Hotels option
			
			
		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			
		}

	}

	@Test(priority = 3)
	public void selectCity() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 3: Selecting the city");
			hp.getElement(driver, By.xpath(readlocator("city"))).click(); // Selecting city Box
			hp.getElement(driver, By.xpath(readlocator("cityInput"))).sendKeys("mumbai"); // Entering input in the city box
			Thread.sleep(2000);
			hp.getElement(driver, By.xpath(readlocator("cityInput"))).sendKeys(Keys.DOWN);    //Selecting first element from drop down
			hp.getElement(driver, By.xpath(readlocator("cityInput"))).sendKeys(Keys.ENTER);
		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("selectCity() Failed");
		}

	}

	@Test(priority = 4)
	public void checkIn() throws Exception {

		try {
			logger.info("RoundTrip TestCase 4: Selecting Check-in date");
			implicitwait(30);
			hp.getElement(driver, By.xpath(readlocator("checkIn"))).click(); // Selecting check-in date

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			
		}

	}

	@Test(priority = 5)
	public void checkOut() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 5: Selecting Check-out date");
			hp.getElement(driver, By.xpath(readlocator("checkOut"))).click(); // Selecting check-out Date

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("checkOut() Failed");
		}

	}
	
	@Test(priority = 6)
	public void travelReason() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 6: Selecting reason for travel");
			hp.getElement(driver, By.xpath(readlocator("travReason"))).click(); //Clicking the Travel Reason option
			hp.getElement(driver, By.xpath(readlocator("leisure"))).click();  //Selecting the leisure option

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("travelReason() Failed");
		}

	}
	
	
	@Test(priority = 7)
	public void clickSearch() throws Exception {

		try 
		{
			logger.info("RoundTrip TestCase 7: Clicking Search Button");
			Thread.sleep(2000);
			hp.getElement(driver, By.xpath(readlocator("search"))).click(); // Clicking Search Button

		} 
		catch (Exception e) 
		{
			
			Reporter.log("FAIL");
			//Assert.fail("clickSearch() Failed");
		}

	}

	@Test(priority = 8)
	public void selectHotel() throws Exception 
	{

		try 
		{
			logger.info("RoundTrip TestCase 8: Selecting the hotel");
			hp.getElement(driver, By.xpath(readlocator("selHotel"))).click(); // Selecting the hotel

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			//Assert.fail("selectHotel() Failed");
		}

	}


	@Test(priority = 9)
	public void handlingWindows() throws Exception {

		try {
			logger.info("RoundTrip TestCase 9: Window Handling ");
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

	@Test(priority = 10, enabled = true)
	public void pageSelection1() throws Exception {

		try {

			implicitwait(10);
			hp.getElement(driver, By.xpath(readlocator("bookNow"))).click();  //Clicking on Book Now button

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			Assert.fail("Booking Page Not Found");

		}

	}

	@Test(priority = 11, dependsOnMethods = "pageSelection1")
	public void guestDetails() throws Exception {

		try {

			hp.getElement(driver, By.xpath(readlocator("fName"))).click();
			hp.getElement(driver, By.xpath(readlocator("fName"))).sendKeys("Radhika");
			hp.getElement(driver, By.xpath(readlocator("lName"))).click();
			hp.getElement(driver, By.xpath(readlocator("lName"))).sendKeys("Kedia");
			hp.getElement(driver, By.xpath(readlocator("emailId"))).click();
			hp.getElement(driver, By.xpath(readlocator("emailId"))).sendKeys("kediaradhika01@gmail.com");
			hp.getElement(driver, By.xpath(readlocator("mobNo"))).click();
			hp.getElement(driver, By.xpath(readlocator("mobNo"))).sendKeys("9747548975");
			

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 12, dependsOnMethods = "pageSelection1")
	public void proceedToPay() throws Exception {

		try {

			hp.getElement(driver, By.xpath(readlocator("payNow"))).click();  //Clicking the PayNow button
			Thread.sleep(5000);

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}


}
