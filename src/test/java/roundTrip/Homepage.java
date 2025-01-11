package roundTrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Homepage 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		
		//Handling the Popups
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20) ;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]")).click();    //Login Popup
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
		driver.findElement(By.xpath("//div[@class=\"makeFlex column childCounter\"]/ul/li[2]")).click();      //Selecting no. of children
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[2]/div[1]/ul[2]/li[2]")).click();      //Selecting travel class
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class=\"right makeFlex hrtlCenter\"]/button")).click();       //Apply Button
		
		
		//Selecting Fare Type
//		driver.findElement(By.xpath("//div[@class=\"makeFlex hrtlCenter\"]/ul/li[2]")).click();
		
		
		//Search Button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();
		

				
		//driver.close();
		  
		  

	}

}
