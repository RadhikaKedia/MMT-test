package com.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {

	public static WebDriver driver;
	String browser;
	String read;
	public static Logger logger;

	public String url;
	
	//Excel Data declaration

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	// login
	public String invalidemail;
	public String validemail;
	public String invalidpass;
	public String validpass;
	public String validmobno;
	public String invalidmobno;

	// flights

	public String firstname;
	public String lastname;
	public String mobileno;
	public String emailid;
	public String furl;

	// registration
	static String regEmail;
	static String regMobile;
	static String newEmail;
	static String newMobile;
	static String newEmailPass;
	static String newMobPass;
	static String newMobName;
	static String newEmailName;

	

	public void getUrl(String url) {
		driver.get(url);

	}

	public void implicitwait(int timeinseconds) {
		driver.manage().timeouts().implicitlyWait(timeinseconds, TimeUnit.SECONDS);
	}
	
	public void explicitWait(int timeinseconds,By element) {
		WebDriverWait wait = new WebDriverWait(driver, timeinseconds);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(element));
	}
	
	

	public void takeSnap(String filename) throws IOException {

		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		 File file= new File("ScreenShots\\" + filename + ".png");
		 String path = "ScreenShots\\" + filename + ".png";
		try {
			FileUtils.copyFile(srcfile, file);
			 Reporter.log(path); 
			
		} catch (Exception E) {
			System.out.println("Error with taking ScreenShot");
		}

	}

	public String readproperty(String data) throws IOException {
		String READ;
		FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		READ = prop.getProperty(data);
		fis.close();
		return READ;

	}
	

	public static String readlocator(String data) throws IOException {
		String READ;
		FileInputStream fis = new FileInputStream("src\\test\\resources\\locator.properties");
		Properties prop = new Properties();
		prop.load(fis);
		READ = prop.getProperty(data);
		fis.close();
		return READ;

	}
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	
	public String getOneWayData(String sheetname,int rownum, int colnum) throws IOException{
		return getCellData("src\\test\\resources\\OneWayData.xlsx", sheetname, rownum, colnum);
	}
	
	public String getRoundTripData(String sheetname,int rownum, int colnum) throws IOException{
		return getCellData("src\\test\\resources\\RoundTripData.xlsx", sheetname, rownum, colnum);
	}
	
	public String getHotelData(String sheetname,int rownum, int colnum) throws IOException{
		return getCellData("src\\test\\resources\\HotelData.xlsx", sheetname, rownum, colnum);
	}
	
	
	
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
	
	
	
	
	

	@BeforeTest
	public void setUp() throws Exception {

		FileInputStream finput = new FileInputStream("src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(finput);

		browser = prop.getProperty("browser");
		url = prop.getProperty("URL");

		// login
		invalidemail = prop.getProperty("InvalidEmail");
		validemail = prop.getProperty("ValidEmail");
		invalidpass = prop.getProperty("InvalidPassword");
		validpass = prop.getProperty("ValidPassword");
		validmobno = prop.getProperty("ValidMobileNo");
		invalidmobno = prop.getProperty("InvalidMobNo");

		// flight
		firstname = prop.getProperty("fristname");
		lastname = prop.getProperty("lastname");
		mobileno = prop.getProperty("mobileno");
		emailid = prop.getProperty("emailid");

		furl = prop.getProperty("URL");
		firstname = prop.getProperty("firstname");

		// registration
		regEmail = prop.getProperty("regisEmail");
		regMobile = prop.getProperty("regisMob");
		newEmail = prop.getProperty("newEmail");
		newMobile = prop.getProperty("newMob");
		newEmailPass = prop.getProperty("newEmailPass");
		newMobName = prop.getProperty("newMobName");
		newMobPass = prop.getProperty("newMobPass");
		newEmailName = prop.getProperty("newEmailName");

		Reporter.log("Setting up " + browser + " with" + url);

		finput.close();

		switch (browser) {
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}
		
		driver.manage().window().maximize();

		driver.get(url);
		
		logger = Logger.getLogger("***MakeMyTrip--PROJECT****");
		PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@AfterMethod(alwaysRun=true)

	public void screenshot(ITestResult Result) throws IOException {
	String newDate = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
	takeSnap(Result.getName()+newDate+".png");

	}

}
