package oneWay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyFilter {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flight/search?itinerary=BOM-MAA-23/10/2021&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		
		
		
		//For the Popup
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20) ;
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/span")).click();    //To handle the Air Asia popup
		
		
		//Popular Filter
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/div[1]/div/p/span")).click();    //To show all the filters
		driver.findElement(By.xpath("(//span[text()='IndiGo'])[1]")).click();    //Selecting Indigo
		
		
		//1 Stop from Mumbai
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/div[4]/div/label[2]/div/span[2]/span")).click();
		
		
		//Departure from Mumbai
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/div[5]/div/div/div[3]/span")).click();
		
		
		//Arrival to Chennai
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='filterWrapper']/div[6]//div[.='After 6 PM']")).click();
		
		
		/*
		 * //Indigo Airlines driver.findElement(By.xpath(
		 * "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/div[7]/div/label[4]/div/span[2]/span"
		 * )).click();
		 */
		
		
		//Checking Flight Details
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//span[text()='View Flight Details'])[2]")).click();     //For Viewing the Flight Details of 2nd result
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@id='flightDetailsTab-5000-tab-2'])[2]")).click();    //Viewing the Fare Summary Tab
		driver.findElement(By.xpath("(//span[text()='View Prices']/parent::button)[2]")).click();    //For Viewing the Price of 2nd Result
		
		
		// Clicking on Book Now button
		driver.findElement(By.xpath("//div[@class='collapse show']/div[@class='viewFaresOuter ']/div[3]//button[@class='button corp-btn latoBlack buttonPrimary fontSize13  ']")).click();    //Booking for Rs.6,678/- Flight
		
		
		//Review Booking
		JavascriptExecutor sc = (JavascriptExecutor) driver;
		sc.executeScript("window.scrollBy(0,2000)");
		
		driver.findElement(By.xpath("//div[@class='insRadioSection appendBottom8 checked']//span[@class='inner']")).click();
//		driver.findElement(By.xpath("//*[@id=\"bookbutton-RKEY:d5989e1b-ce05-4475-b42b-46b49c6af7fa:32_0\"]/span[1]")).click();
		
		
		//driver.close();

	}

}
