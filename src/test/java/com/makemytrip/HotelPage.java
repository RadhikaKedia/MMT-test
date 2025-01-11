package com.makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelPage 
{
	static WebElement webelem;
	static WebElement E;
	WebDriver driver;	
	
	
	public HotelPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public static WebElement getElement(WebDriver driver, By byvariable)
	{
		
		E = driver.findElement(byvariable);
		
		return  E;
	}


}
