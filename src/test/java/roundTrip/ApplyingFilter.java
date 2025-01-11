package roundTrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyingFilter {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flight/search?itinerary=MAA-DEL-23/10/2021_DEL-MAA-26/10/2021&tripType=R&paxType=A-1_C-1_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		
		
		
		//For the Popup
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean exists=false;
		
        try
        {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div"));
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
            	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/span")).click();
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
//		WebElement Element = driver.findElement(By.xpath("//label[@id='flightCard-5000']//p[@class='alertMsg appendBottom10 appendTop10'][contains(text(),'Use code FLYFESTIVE and get FLAT Rs. 1500 instant ')]"));
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", Element);
//		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.xpath("//label[@id='flightCard-15']//span[@class='flexOne makeFlex']")).click();   //Chennai -> New Delhi
		
//		JavascriptExecutor up = (JavascriptExecutor) driver;
//		up.executeScript("window.scrollBy(500,0)");
//		driver.findElement(By.xpath("//div[@class='splitVw']//div[2]/label[@class='splitViewListing   ']//span[@class='outer']")).click();    //New Delhi -> Chennai
//		
		
		//Booking Flight
		driver.findElement(By.xpath("//button[@class='splitFooterButton button buttonPrimary buttonBig ']")).click();     //Clicking Book Now
		driver.findElement(By.xpath("//button[@class='buttonPrimary buttonBig  lato-black button']")).click();     //Clicking continue 
		

	
//		//driver.close();

	}

}
