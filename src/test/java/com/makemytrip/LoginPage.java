package com.makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
static WebElement webelem;
	WebDriver driver;	
	static By loginbtn = By.xpath("//label[normalize-space()='Login with Phone/Email']");//Pop Having the Login with Phone/Email
	static By loginpagedisp = By.xpath("//span[@class='font26 latoBlack']");//To Check whether the  LoginPage Displayed or not 
	static By usernameid = By.id("username");//user input box
	static By emaillabel =  By.xpath("//label[@class='font14 latoBold appendBottom10']");//Checking whether the Email Is written above the email input box 
	static By emailmessg = By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/section/form/div[1]/p"); //after entering email click continue then ..
	static By enter_username = By.cssSelector("input[id='username']");//
	static By continuebtn = By.xpath("//button[@class='capText font16']");//cpntinue button
	static By loginwthpassmessg = By.xpath("//span[@class='font26 latoBlack']");//Login Page Header like "Login With Password"
	static By passid = By.id("password");//password Input Box
	static By passlbl =By.xpath("//label[@class='font14 latoBold']");//Above the Password input box to check whether "Password" is written or  not
	static By entrpassmssg = By.xpath("//p[@class='validity font12 redText appendTop5 makeFlex']");//inside the input box Whether the box as empty the "Please enter password"
	static By lgnpagebtn = By.xpath("//button[@class='capText font16']");//Login Page Login Button
	static By inccrtmsg = By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/section/div[2]/p[3]/span[2]");//Incorrect Password Message
	static By rstpasslnk = By.xpath("//a[@class='pushRight modalResetBtn font12 appendRight5']");//Reset Password Link
	static By rstpasslbl = By.xpath("//p[@class='modalTitle makeFlex hrtlCenter font26 latoBold appendBottom5']");//Header Label for Reset password page
	static By vrfymobno = By.xpath("//p[@class='modalTitle makeFlex hrtlCenter font26 latoBold appendBottom5']");//Header Label for Verify Mobile number
	static By notregmssg = By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div[2]/div/div[2]/p");
	static By servererror = By.xpath("//span[@data-cy='serverError']");//Invalid Phone number error message
	static By mincharpassmsg = By.cssSelector("input[id='password']");//password
	static By loginSignupbtn = By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']");//Login/CreateAccount
	static By finlogbtn= By.xpath("//button[@class='capText font16']");//login buttton
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public static WebElement LoginSignupbtn(WebDriver driver) {
		webelem= driver.findElement(loginSignupbtn);
		return webelem;
	}
	public static WebElement Loginbtn(WebDriver driver) {
		webelem= driver.findElement(loginSignupbtn);
		return webelem;
	}
	public static WebElement Loginpagedisp(WebDriver driver) {
		webelem= driver.findElement(loginpagedisp);
		return webelem;
	}
	public static WebElement UsernameID(WebDriver driver) {
		webelem= driver.findElement(usernameid);
		return webelem;
	}
	public static WebElement EmailLabel(WebDriver driver) {
		webelem= driver.findElement(emaillabel);
		return webelem;
	}
	public static WebElement EmailMessage(WebDriver driver) {
		webelem= driver.findElement(emailmessg);
		return webelem;
	}
	public static WebElement EmailTextBoxMessage(WebDriver driver) {
		webelem= driver.findElement(enter_username);
		return webelem;
	}
	public static WebElement ContinueBtn(WebDriver driver) {
		webelem= driver.findElement(continuebtn);
		return webelem;
	}
	public static WebElement LoginWthPassMessg(WebDriver driver) {
		webelem= driver.findElement(loginwthpassmessg);
		return webelem;
	}
	public static WebElement PassID(WebDriver driver) {
		webelem= driver.findElement(passid);
		return webelem;
	}
	public static WebElement PassLbl(WebDriver driver) {
		webelem= driver.findElement(passlbl);
		return webelem;
	}
	public static WebElement EntrPassMssg(WebDriver driver) {
		webelem= driver.findElement(entrpassmssg);
		return webelem;
	}
	public static WebElement LgnPageBtn(WebDriver driver) {
		webelem= driver.findElement(lgnpagebtn);
		return webelem;
	}
	public static WebElement InccrtMsg(WebDriver driver) {
		webelem= driver.findElement(inccrtmsg);
		return webelem;
	}
	public static WebElement RstPassLnk(WebDriver driver) {
		webelem= driver.findElement(rstpasslnk);
		return webelem;
	}
	public static WebElement RstPassLbl(WebDriver driver) {
		webelem= driver.findElement(rstpasslbl);
		return webelem;
	}
	public static WebElement VrfyMobNo(WebDriver driver) {
		webelem= driver.findElement(vrfymobno);
		return webelem;
	}
	public static WebElement NotRegMssg(WebDriver driver) {
		webelem= driver.findElement(notregmssg);
		return webelem;
	}
	public static WebElement errorMsg(WebDriver driver) {
		webelem= driver.findElement(servererror);
		return webelem;
	}
	public static WebElement MinCharPassMssg(WebDriver driver) {
		webelem= driver.findElement(mincharpassmsg);
		return webelem;
	}
	public static WebElement FinalLoginbtn(WebDriver driver) {
		webelem = driver.findElement(finlogbtn);
		return webelem;
	}

	
}

	
	
	
	