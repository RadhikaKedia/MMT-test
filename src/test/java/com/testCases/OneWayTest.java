package com.testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseClass.Keywords;
import com.makemytrip.OneWayPage;

public class OneWayTest extends Keywords {
	JavascriptExecutor js;
	OneWayPage op;
	String Page2 = "abcd";

	@Test(priority = 1)
	public void loginbtnclick() throws Exception {

		try {
			implicitwait(10);
			logger.info("OneWayTrip TestCase 1: Checking Whether the Login/SignUp Button is Present in Home page or not");
			explicitWait(20, op.loginPop); // waiting for login popup
			op.getElement(driver, op.loginPopClos).click(); // closing login popup

		} catch (Exception e) {
			//takeSnap("loginSignupbtnFail");
			Reporter.log("FAIL");
			logger.error("OneWayTrip TestCase 1 Failed");
		}

	}

	@Test(priority = 2)
	public void selectFromCity() throws Exception {

		try {
			
			logger.info("OneWayTrip TestCase 2: Choosing From Location");
			op.getElement(driver, op.fromBox).click(); // Selecting from Box
			//op.getElement(driver, op.fromInput).sendKeys("Mumbai"); // Entering input in the from box
			op.getElement(driver, op.fromInput).sendKeys(getOneWayData("CityDetails", 1, 0));
			Thread.sleep(2000);
			op.getElement(driver, op.clickDrop).click(); // click first element from drop down
		} catch (Exception e) {
			
			Reporter.log("FAIL");
			//Assert.fail("selectFromCity() Failed");
		}

	}

	@Test(priority = 3)
	public void selectToCity() throws Exception {

		try {
			logger.info("OneWayTrip TestCase 3: Choosing To Location");
			implicitwait(30);
			op.getElement(driver, op.toBox).click(); // Selecting toBox
			op.getElement(driver, op.toInput).sendKeys(getOneWayData("CityDetails", 1, 1)); // Entering input in the to box
			
			Thread.sleep(1000);
			op.getElement(driver, op.toInput).sendKeys(Keys.DOWN);
			op.getElement(driver, op.toInput).sendKeys(Keys.ENTER); // click first element from drop down
			Thread.sleep(2000);

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			
		}

	}

	@Test(priority = 4)
	public void departureOption() throws Exception {

		try {
			logger.info("OneWayTrip TestCase 4: Closing Hindi Popup");
			implicitwait(30);
			op.getElement(driver, op.hindiPop).click(); // Closing Available In Hindi Popup
			Thread.sleep(2000);
			op.getElement(driver, op.deptDate).click(); // Selecting Date
			logger.info("OneWayTrip TestCase 4: Choosing Departure Date");

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			//Assert.fail("departureOption() Failed");
		}

	}

	@Test(priority = 5)
	public void clickSearch() throws Exception {

		try {
			logger.info("OneWayTrip TestCase 5: Clicking Search Button");
			op.getElement(driver, op.search).click(); // Click Search

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			//Assert.fail("clickSearch() Failed");
		}

	}

	@Test(priority = 6)
	public void closePopup() throws Exception {

		try {
			logger.info("OneWayTrip TestCase 6: Closing Popup");
			explicitWait(20, op.popClose); // Waiting for Search popup
			op.getElement(driver, op.popClose).click(); // Closing Popup

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			//Assert.fail("closePopup() Failed");
		}

	}

	@Test(priority = 7)
	public void popularFiltersSelect() throws Exception {

		try {
			logger.info("OneWayTrip TestCase 7: Choosing Popular Filters");
			op.getElement(driver, op.popuFil).click(); // Click + 6 more
			op.getElement(driver, op.selIndiGo).click(); // Select IndiGo Check Box
			op.getElement(driver, op.oneStop).click(); // Select 1 Stop CheckBox
			op.getElement(driver, op.depFromMum).click(); // To Select Departure From Time
			explicitWait(20, op.arrivalAtChennai); // Waiting For arrival time checkbox to appear
			op.getElement(driver, op.arrivalAtChennai).click(); // To Select Arrival At Time

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 8)
	public void checkingFlightDetails() throws Exception {

		try {
			logger.info("OneWayTrip TestCase 8: Clicking and Checking Flight Details");
			op.getElement(driver, op.viewPrice).click(); // Click View Price
			op.getElement(driver, op.bookWithPrice).click(); // Select Book Now With 2nd Price

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 9)
	public void handlingWindows() throws Exception {

		try {
			logger.info("OneWayTrip TestCase 9: Window Handling ");
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
			Page2 = driver.findElement(By.xpath("//h2[text()='Complete your booking']")).getText();// bookPage

			if (Page2.contains("Complete your"))

				implicitwait(10);
			else
				Assert.fail("Booking Page Not Found");

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			Assert.fail("Booking Page Not Found");

		}

	}

	@Test(priority = 11, dependsOnMethods = "pageSelection1")
	public void passengerDetails() throws Exception {

		try {

			op.getElement(driver, op.travInsur).click(); // Do not wish to secure trip option
			Thread.sleep(2000);
			explicitWait(20, op.addDetails);
			Thread.sleep(2000);
			op.getElement(driver, op.addDetails).click();
			op.getElement(driver, op.firstName).click();
			op.getElement(driver, op.firstName).sendKeys(getOneWayData("InputData", 1, 0));
			op.getElement(driver, op.lastName).click();
			op.getElement(driver, op.lastName).sendKeys(getOneWayData("InputData", 1, 1));
			op.getElement(driver, op.gender).click();
			op.getElement(driver, op.contDetails).click();
			op.getElement(driver, op.mobileNo).click();
			op.getElement(driver, op.mobileNo).sendKeys(Keys.CLEAR);
			op.getElement(driver, op.mobileNo).sendKeys(getOneWayData("InputData", 1, 2));
			op.getElement(driver, op.mobileNo).sendKeys(Keys.TAB);
			op.getElement(driver, op.emailId).sendKeys(getOneWayData("InputData", 1, 3));
			op.getElement(driver, op.emailId).sendKeys(Keys.TAB);

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 12, dependsOnMethods = "pageSelection1")
	public void confirmProceedClick() throws Exception {

		try {

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

	@Test(priority = 13, dependsOnMethods = "pageSelection1")
	public void rarePopupHandling() throws Exception {

		try {

			explicitWait(10, op.rarePopup);
			op.getElement(driver, op.rarePopup).click();

		} catch (Exception e) {

		}

	}

	@Test(priority = 14, dependsOnMethods = "pageSelection1")
	public void selectingSeats() throws Exception {

		try {
			// op.getElement(driver, op.revConf).click();//Review details confirmation

			Thread.sleep(2000);
			op.getElement(driver, op.freeSeat).click(); // Clicking Yes please
			Thread.sleep(3000);
			op.getElement(driver, op.skipAddon).click(); // Skipping the add-ons

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 15, dependsOnMethods = "pageSelection1")
	public void proceedToPay() throws Exception {

		try {

			op.getElement(driver, op.proceedPay).click(); // Clicking Yes please

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 16)
	public void pageSelection2() throws Exception {

		try {

			Thread.sleep(4000);
			op.getElement(driver, op.notSecure).click();// Click I do Not Wish Secure My Trip in 2nd Page

		} catch (Exception e) {
			
			Reporter.log("FAIL");
			Assert.fail("Not In Page two");

		}

	}

	@Test(priority = 17, dependsOnMethods = "pageSelection2")
	public void proceed() throws Exception {

		try {

			Thread.sleep(3000);
			op.getElement(driver, op.proceed).click(); //Click Continue Button

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 18, dependsOnMethods = "pageSelection2")
	public void inputDetails() throws Exception {

		try {

			Thread.sleep(3000);
			op.getElement(driver, op.name).sendKeys(getOneWayData("InputData", 1, 0));// Input First Name
			op.getElement(driver, op.surname).sendKeys(getOneWayData("InputData", 1, 1));// Input Last Name
			op.getElement(driver, op.genderMale).click(); // Select Gender Male
			op.getElement(driver, op.mobNum).sendKeys(getOneWayData("InputData", 1, 2)); // Input Mobile No
			op.getElement(driver, op.email).sendKeys(getOneWayData("InputData", 1, 3)); // Input Email

		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

	@Test(priority = 19, dependsOnMethods = "pageSelection2")
	public void confirmDetails() throws Exception {

		try {

			op.getElement(driver, op.continueButton).click(); // Click Continue
			Thread.sleep(2000);
			op.getElement(driver, op.skipButton).click(); // Click Skip To Payment
			Thread.sleep(2000);
			op.getElement(driver, op.contAnyway).click(); // Click Continue
			Thread.sleep(5000);
		} catch (Exception e) {
			
			Reporter.log("FAIL");
		}

	}

}
