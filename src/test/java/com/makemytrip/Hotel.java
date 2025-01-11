package com.makemytrip;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.compiler.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hotel 
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
		
		
		//Selecting Hotel
		driver.findElement(By.xpath("//span[contains(@class,'chNavIcon appendBottom2 chSprite chHotels')]")).click();
		
		
		//Selecting city 
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5']")).click(); //Selecting the city box
		driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']")).sendKeys("mumbai");  //typing input in the box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']")).sendKeys(Keys.DOWN);    //Same xpaths, moving to the option for autocomplete
		driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']")).sendKeys(Keys.ENTER);   //Same xpaths, moving to the option for autocomplete
		
		
		//Check-in
		driver.findElement(By.xpath("//div[@aria-label='Sat Oct 23 2021']")).click();  //Selecting the date
		
		
		//Check-out
		driver.findElement(By.xpath("//div[@aria-label='Mon Oct 25 2021']")).click();   //Selecting the date
		
		
		//Selecting reason for travelling
		driver.findElement(By.xpath("//p[@class='font14 greyText']")).click();
		driver.findElement(By.xpath("//li[.='Leisure']")).click();  //Selecting leisure as reason
		
		
		//search button
		driver.findElement(By.xpath("//button[@id='hsw_search_button']")).click();
		
		
		//Selecting the hotel
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/a[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/p[1]")).click();
		
		
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
				
				//Booking the hotel
				driver.findElement(By.xpath("//button[@id='detpg_headerright_book_now']")).click();
				
				
				//Entering guest details
				//Thread.sleep(3000);
				driver.findElement(By.xpath("(//input[@id='fName'])[1]")).click();
				driver.findElement(By.xpath("(//input[@id='fName'])[1]")).sendKeys("Radhika");
				driver.findElement(By.xpath("(//input[@id='lName'])[1]")).click();
				driver.findElement(By.xpath("(//input[@id='lName'])[1]")).sendKeys("Kedia");
				driver.findElement(By.xpath("(//input[@id='email'])[1]")).click();
				driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("kediaradhika01@gmail.com");
				driver.findElement(By.xpath("(//input[@id='mNo'])[1]")).click();
				driver.findElement(By.xpath("(//input[@id='mNo'])[1]")).sendKeys("9747548975");
				
				//Clicking Pay Now button
				driver.findElement(By.xpath("//a[normalize-space()='Pay Now']")).click();
				
				
			}
		}
		

	}

}
