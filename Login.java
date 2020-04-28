package org.Adactin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Login {
	
public static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\Chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@Before
	public void before() {
		Date date=new Date();
		System.out.println("Start Time :"+ date);		
	}
	
	
	@Test //Valid Details/Input
	public void A() {
		System.out.println("------Login Page------");
		driver.get("https://adactin.com/HotelApp/");
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("NaveenShankar1");
		String strUserName=userName.getAttribute("value");
		
		Assert.assertTrue("UserName", strUserName.equals("NaveenShankar1"));		
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("naveen123");
		String strPassword=password.getAttribute("value");
		
		Assert.assertTrue("Password", strPassword.equals("naveen123"));
		
		WebElement loginClick=driver.findElement(By.id("login"));
		loginClick.click();
		String strLoginUrl=driver.getCurrentUrl();
		
		Assert.assertEquals("https://adactin.com/HotelApp/SearchHotel.php", strLoginUrl);		
	}
	
	
	@Test
	public void B() {
		System.out.println("------ Search Hotel ------");
		WebElement selectLocation=driver.findElement(By.name("location"));
		Select selLoc = new Select(selectLocation);
		selLoc.selectByValue("London");
		String strLoc =selLoc.getFirstSelectedOption().getText();
		
		Assert.assertEquals("London", strLoc);
		
		WebElement selectHotel=driver.findElement(By.name("hotels"));
		Select selHotel = new Select(selectHotel);
		selHotel.selectByIndex(1);
		String strHotel =selHotel.getFirstSelectedOption().getText();
		
		Assert.assertEquals("Hotel Creek", strHotel);
		
		WebElement selectRoom=driver.findElement(By.name("room_type"));
		Select selRm = new Select(selectRoom);	
		selRm.selectByIndex(2);
		String strRoom =selRm.getFirstSelectedOption().getText();
		
		Assert.assertEquals("Double", strRoom);
		
		WebElement selectRmNum=driver.findElement(By.name("room_nos"));
		Select selRmNum = new Select(selectRmNum);	
		selRmNum.selectByIndex(1);
		
		Assert.assertEquals("1 - One", selRmNum.getFirstSelectedOption().getText());
		
		WebElement inDate=driver.findElement(By.id("datepick_in"));
		inDate.getAttribute("value");
		
		Assert.assertNotNull("Not Null", inDate.getAttribute("value"));
		
		WebElement outDate=driver.findElement(By.id("datepick_out"));
		outDate.getAttribute("value");
		
		Assert.assertNotNull("Not Null", outDate.getAttribute("value"));
		
		WebElement selectAdltNum=driver.findElement(By.name("adult_room"));
		Select selAdltNum = new Select(selectAdltNum);	
		selAdltNum.selectByIndex(2);

		Assert.assertEquals("2 - Two", selAdltNum.getFirstSelectedOption().getText());
		
		WebElement selectChildNum=driver.findElement(By.name("child_room"));
		Select selChldNum = new Select(selectChildNum);	
		selChldNum.selectByIndex(1);
		
		Assert.assertEquals("1 - One", selChldNum.getFirstSelectedOption().getText());
		
		WebElement searchUrl=driver.findElement(By.id("Submit"));
		searchUrl.click();
		String strSearchUrl=driver.getCurrentUrl();
		
		Assert.assertEquals("https://adactin.com/HotelApp/SelectHotel.php", strSearchUrl);		
	}
	
	
	@Test
	public void C() {
		System.out.println("------- Select Hotel --------");
		WebElement rdbtnClick=driver.findElement(By.id("radiobutton_0"));
		rdbtnClick.click();
		
		Assert.assertTrue(rdbtnClick.isSelected());
		
		WebElement rdbtnCont=driver.findElement(By.id("continue"));
		rdbtnCont.click();
		String strSelectUrl=driver.getCurrentUrl();
		
		Assert.assertEquals("https://adactin.com/HotelApp/BookHotel.php", strSelectUrl);		
	}
	
	
	@Test
	public void D() {
		System.out.println("-------- Payment Details -------");
		
		WebElement fName = driver.findElement(By.id("first_name"));
		fName.sendKeys("Naveen");
		String strFName=fName.getAttribute("value");
		
		Assert.assertTrue("FirstName", strFName.equals("Naveen"));
		
		WebElement lName = driver.findElement(By.id("last_name"));
		lName.sendKeys("Shankar");
		String strLName=lName.getAttribute("value");
		
		Assert.assertTrue("LastName", strLName.equals("Shankar"));
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("SSM Nagar,Chennai-63");
		String adres=address.getAttribute("value");
		
		Assert.assertTrue("Address", adres.equals("SSM Nagar,Chennai-63"));
		
		WebElement cc_num = driver.findElement(By.id("cc_num"));
		cc_num.sendKeys("9876543210123456");
		String ccNum=cc_num.getAttribute("value");
		
		Assert.assertTrue("CC_Num", ccNum.equals("9876543210123456"));
		
		WebElement cardType = driver.findElement(By.id("cc_type"));
		Select cType =new Select(cardType);
		cType.selectByValue("VISA");
		
		Assert.assertEquals("VISA", cType.getFirstSelectedOption().getText());
		
		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		Select ccExpMnth =new Select(expMonth);
		ccExpMnth.selectByIndex(5);
		
		Assert.assertEquals("May", ccExpMnth.getFirstSelectedOption().getText());

		WebElement expYear = driver.findElement(By.id("cc_exp_year"));
		Select ccExpYr =new Select(expYear);
		ccExpYr.selectByValue("2022");
		
		Assert.assertEquals("2022", ccExpYr.getFirstSelectedOption().getText());
		
		WebElement cc_cvv = driver.findElement(By.id("cc_cvv"));
		cc_cvv.sendKeys("123");
		String ccv=cc_cvv.getAttribute("value");
		
		Assert.assertTrue("CCV", ccv.equals("123"));
		
		
		WebElement bookClick = driver.findElement(By.id("book_now"));
		bookClick.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("order_no")));
		
		String strPaymentUrl=driver.getCurrentUrl();
		
		Assert.assertEquals("https://adactin.com/HotelApp/BookingConfirm.php", strPaymentUrl);	
	}
	
	
	@Test
	public void E() {
		//Scroll Down
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//Random Scroll
		//js.executeScript("window.scrollBy(0,1500)");
		
		//Scroll Till mentioned element i.e Element Scroll
		WebElement scrollOrderID=driver.findElement(By.id("order_no"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrollOrderID);
		
		
		TakesScreenshot tkscrshot=(TakesScreenshot)driver;
		File f1=tkscrshot.getScreenshotAs(OutputType.FILE);
		File f2=new File("D:\\orderid.jpg");
		try {
			FileHandler.copy(f1, f2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after() {	
		Date date=new Date();
		System.out.println("End Time :"+ date);
	}
}
