package roundTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.Robot;	
import com.baseClass.Keywords;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;	
import java.awt.Robot;	
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Booking extends Keywords 
{


	@Test
	public void loginSignupbtn() throws Exception
	{
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		caps.setCapability("acceptInsecureCerts", true);
		
		JavascriptExecutor js ;
//		WebDriverManager.chromedriver().setup();  
//		WebDriver driver = new ChromeDriver(); 
		
		//driver.manage().window().maximize();
		
		// driver.get("https://www.makemytrip.com/");
	        
		//Handling the Popups
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, 20) ;
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));  //Login Popup
				driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]")).click();      //Login Popup Close
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div[6]/span")).click();    //Hindi Popup
				
				
				//Selecting Round Trip
				driver.findElement(By.xpath("//div[@class=\"makeFlex\"]/ul/li[2]")).click(); 
				
				
				//FROM option
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]")).click();     //From box
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("che");     //typing input in the box
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.DOWN);    //Same xpaths, moving to the option for autocomplete
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);   //Same xpaths, moving to the option for autocomplete
				
				
				//TO option
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]")).click();      //To box
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input")).sendKeys("del");     //typing input in the box
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input")).sendKeys(Keys.DOWN);    //Same xpaths, moving to the option for autocomplete
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input")).sendKeys(Keys.ENTER);    //Same xpaths, moving to the option for autocomplete
				
				
				//Departure option
				driver.findElement(By.xpath("//div[@aria-label='Sat Oct 23 2021']//p[contains(text(),'23')]")).click();    //Selecting the date
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				
				//Return option
				JavascriptExecutor sc = (JavascriptExecutor) driver;
				sc.executeScript("window.scrollBy(0,100)");
				driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Day DayPicker-Day--selected']//p[.='26']")).click();    //Selecting the date
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				
				//Travellers and Class option
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/label")).click();    //Selecting the box
//				driver.findElement(By.xpath("//div[@class=\"makeFlex column childCounter\"]/ul/li[2]")).click();      //Selecting no. of children
//				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[2]/div[1]/ul[2]/li[2]")).click();      //Selecting travel class
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//div[@class=\"right makeFlex hrtlCenter\"]/button")).click();       //Apply Button
				
				
				//Selecting Fare Type
//				driver.findElement(By.xpath("//div[@class=\"makeFlex hrtlCenter\"]/ul/li[2]")).click();
				
				
				//Search Button
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();
				
		
		//For the Popup
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			boolean exists=false;
			
	        try
	        {
	            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div"));    //Waiting for popup to appear
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
	            	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/span")).click();    //Closing the popup
	            }
	            catch (ElementNotVisibleException b) 
	            {
	                exists = false;
	            }

	        }
		
			
			//Popular Filter
			driver.findElement(By.xpath("//span[contains(.,'+ 6 more')]")).click();    //To show all the filters
			driver.findElement(By.xpath("(//span[text()='Morning Departures'])[1]")).click();    //Selecting Morning Departures
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			//Selecting Flight
			js = (JavascriptExecutor) driver;
////			WebElement Element = driver.findElement(By.xpath("//label[@id='flightCard-5000']//p[@class='alertMsg appendBottom10 appendTop10'][contains(text(),'Use code FLYFESTIVE and get FLAT Rs. 1500 instant ')]"));
////			
////			JavascriptExecutor js = (JavascriptExecutor) driver;
////			js.executeScript("arguments[0].scrollIntoView();", Element);
////			Thread.sleep(2000);
//			
//			js.executeScript("window.scrollBy(0,1000)");
//			
//			driver.findElement(By.xpath("//label[@id='flightCard-5000']//p[@class='alertMsg appendBottom10 appendTop10'][contains(text(),'Use code FLYFESTIVE and get FLAT Rs. 1500 instant ')]")).click();   //Chennai -> New Delhi
//			
//			JavascriptExecutor up = (JavascriptExecutor) driver;
//			up.executeScript("window.scrollBy(500,0)");
//			driver.findElement(By.xpath("//div[@class='splitVw']//div[2]/label[@class='splitViewListing   ']//span[@class='outer']")).click();    //New Delhi -> Chennai
//			
			
			//Booking Flight
			driver.findElement(By.xpath("//button[@class='splitFooterButton button buttonPrimary buttonBig ']")).click();     //Clicking Book Now
			driver.findElement(By.xpath("//button[@class='buttonPrimary buttonBig  lato-black button']")).click();     //Clicking continue 
			
//		String currentwindow = driver.getWindowHandle();
//		driver.switchTo().window(driver.getWindowHandle());
		
		String parent=driver.getWindowHandle();
		System.out.println(driver.getWindowHandle()+"parent");
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
			
		driver.switchTo().window(child_window);
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
			
			implicitwait(10);
			//span[text()='Skip to add-ons']
			
			String Page2 = "";
			try {
			Page2 = driver.findElement(By.xpath("//h2[text()='Complete your booking']")).getText();
			}
			catch (Exception e) {
				
			}
			if(Page2.contains("Complete your"))
		    try {
		    implicitwait(10);
		    driver.findElement(By.cssSelector(
		    		".insRadioSection:nth-child(2) .darkText")).click();
		    System.out.println("1");
		    implicitwait(10);
		    js.executeScript("window.scrollBy(0,500)");
		    System.out.println("2");
		    
		    Thread.sleep(2000);
		    wait = new WebDriverWait(driver, 10);
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='addTravellerBtn']"))); 
		    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[@class='addTravellerBtn']")).click();
		  //  driver.findElement(By.xpath("//button[contains(.,\'+ ADD NEW ADULT\')]")).click();
		    System.out.println("3");
		   
		   // driver.findElement(By.cssSelector(".addTravellerBtn")).click();
		    driver.findElement(By.xpath("//input")).click();
//		    driver.findElement(By.xpath("//input")).click();
		    driver.findElement(By.xpath("//input")).sendKeys("Ishan ");
		    driver.findElement(By.xpath("//div[2]/div/input")).click();
		    driver.findElement(By.xpath("//div[2]/div/input")).sendKeys("Sharma");
		    driver.findElement(By.xpath("//label[contains(.,\'MALE\')]")).click();
		    driver.findElement(By.cssSelector(".adultItemRow:nth-child(2)")).click();
		    driver.findElement(By.xpath("//div[@id=\'Mobile No\']/div/input")).click();
		    driver.findElement(By.xpath("//div[@id=\'Mobile No\']/div/input")).sendKeys(Keys.CLEAR);
		    driver.findElement(By.xpath("//div[@id=\'Mobile No\']/div/input")).sendKeys("8077106228");
		    driver.findElement(By.xpath("//div[@id=\'Mobile No\']/div/input")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath("//*[@id=\"Email\"]/div/input")).sendKeys("ishansharma@gmail.com");
		    System.out.println("2");
		    driver.findElement(By.xpath("//*[@id=\"Email\"]/div/input")).sendKeys(Keys.TAB);
		    
		    Robot robot = new Robot();
		  //Press key Enter
		  robot.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  Thread.sleep(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		    System.out.println("3");
		    try {
		    wait = new WebDriverWait(driver, 10);
		    
//		    WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div/div[2]/button"))); 
//		    ((JavascriptExecutor)driver).executeScript("//*[@id=\"root\"]/div/div[2]/div[5]/div/div[2]/button", element2);
//		    System.out.println("4");
		    }
		   
		    catch (Exception e) {
				// TODO: handle exception
			}
		  
		    driver.findElement(By.xpath("//button[@class='button buttonPrimary buttonBig fontSize14']")).click();
		   
		    System.out.println("5");
		    
		    //Clicking Yes Please
//		    try {
//		    driver.findElement(By.xpath("//button[@class='lato-black button buttonPrimary buttonBig fontSize12']")).click();
//		    System.out.println("6");
//		    }
//		    catch (Exception e) {
//				
//			}
		    System.out.println("7");
		    try {
		  //Clicking Yes Please
		    wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='lato-black button buttonPrimary buttonBig fontSize12']"))); 
		  
		    driver.findElement(By.xpath("//button[@class='lato-black button buttonPrimary buttonBig fontSize12']")).click();
		    System.out.println("7.1");
		    //Skip Addons
//		    js.executeScript("window.scrollBy(0,800)");
//		    wait = new WebDriverWait(driver, 2);
//		    driver.findElement(By.xpath("//button[@class='lato-black button buttonPrimary extraPadBtn fontSize16']")).click();
		    
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Skip to add-ons'")));
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//span[text()='Skip to add-ons']")).click();
		    System.out.println("7.2");
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
		    
		    //Skip Addons
		  //span[@class='linkText ']
		    
		    //Proceed to pay
		    System.out.println("7.3");
		    driver.findElement(By.xpath("//button[.='Proceed to pay']")).click();
		    System.out.println("8");
		    }
		    
		    catch (Exception e) {
		    	e.printStackTrace();
				System.out.println("fail");
			}
			
			else {
		    
		    try {
		    	
		    	implicitwait(30);
		    	//Click I do Not Wish Secure My Trip
		    	Thread.sleep(3000);
		    	driver.findElement(By.xpath("//span[text()='No, I do not wish to secure my trip']")).click();
		    	System.out.println("0.5");
		    	//Click Continue Button
		    	Thread.sleep(3000);
		    	driver.findElement(By.id("review-continue")).click();
		    	System.out.println("1");
		    	Thread.sleep(3000);
		    	//Input First And Middle Name
		    	driver.findElement(By.xpath("//input[@placeholder='First & Middle Name']")).sendKeys("Ishan");
		    	System.out.println("2");
		    	//Input Last Name
		    	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Sharma");
		    	System.out.println("3");
		    	//Clicking Male
		    	driver.findElement(By.xpath("//div[@class='append_bottom15']//div[@class='collapse in']//label[1]")).click();
		    	System.out.println("4");
		    	//Input Mobile No
		    	
		    	driver.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys("8077106228");
		    	System.out.println("5");
		    	//Input Email
		    	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("ishansharma@gmail.com");
		    	System.out.println("6");
		    	//Click Continue
		    	driver.findElement(By.xpath("//button[text()='Continue']")).click();
		    	System.out.println("7");
		    	
		    	//Click Confirm
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//a[text()='CONFIRM']")).click();
		    	
		    	//Click Skip To Payment
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//a[text()='Skip to Payment']")).click();
		    
		    	//Click Continue Anyway
		    	Thread.sleep(2000);
		    	driver.findElement(By.xpath("//a[text()='CONTINUE ANYWAY']")).click();
		    	
		    	 
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    	
			}
			}
		   
		    
		  // driver.quit();
		    
		   
		}
	}

}

}
