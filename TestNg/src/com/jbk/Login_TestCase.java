package com.jbk;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_TestCase {
	
	public static WebDriver driver;
	@BeforeMethod(groups="Smoke")
	public static WebDriver setup_Browser() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.get("file:///F:/Selinium%20File/Selenium%20Software/Offline%20Website/index.html");
		return driver;
		
	}
	
	@Test(priority = 1)
	public static void Verify_Url() {
		// Actual url
		String my_url = driver.getCurrentUrl();
		System.out.println("page title is " + my_url);

		// expected url
		String expected_url = "file:///F:/Selinium%20File/Selenium%20Software/Offline%20Website/index.html";
		AssertJUnit.assertEquals(my_url, expected_url);
		System.out.println("**************************");

		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
	}
	@Test(priority=2)
	public static void verifyApplicationTitle()
	{
		//Actual Title
		String my_title=driver.getTitle();
		System.out.println("Page title is"+my_title);
		System.out.println("********************");
		//expected title
		String expected_title ="AdminLTE 2 | Log in";
		AssertJUnit.assertEquals(my_title, expected_title);
		System.out.println("********************");
		System.out.println("Test case two with Thread Id:-"+Thread.currentThread().getId());
	}
	
	@Test(priority=3)
	public static void verifyTitle() {
		//Actual Title
		String stitle=driver.findElement(By.xpath("//a[@href='index2.html']")).getText();
		String exp="AdminLTE";
		AssertJUnit.assertEquals(stitle, exp);
		System.out.println("Application Title Is Verify"+ stitle);
		System.out.println("********************");
	}
		
		@Test(priority=4)
		public static void loginSession() {
			driver.findElement(By.xpath("//p[@class='login-box-msg']"));
			System.out.println("Sign in to start your session ");
			System.out.println("********************");
		}
		@Test(priority=5)
		public static void check_placeHolder_Username(){
			String str=driver.findElement(By.xpath("//input[@type='text']")).getAttribute("placeholder");
			String exp="Email";
			AssertJUnit.assertEquals(str, exp);
			System.out.println("placeholder Email_verified");
			System.out.println("*******************");
		}
		@Test(priority=6)
		public static void check_placeHolder_password()
		{
			String str=driver.findElement(By.xpath("//input[@type='password']")).getAttribute("placeholder");
			String exp="Password";
					AssertJUnit.assertEquals(str, exp);
					System.out.println("placeholder Password_verified");
					
			
		
		}
		@Test(priority=7)
		public static void check_Button_color() {
			WebElement signbtn=driver.findElement(By.xpath("//button[@type='submit']"));
			System.out.println("befor mouse over color button is"+signbtn.getCssValue("background-color"));
			Actions act=new Actions (driver);
			act.moveToElement(signbtn).build().perform();
			System.out.println("after mmouse over a button color"+signbtn.getCssValue("color"));
			System.out.println("*********************");
			
		}
		
		@Test(priority=8)
		public static void check_Links() {
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println(links.size());
			System.out.println(".......................");
			for (int i=0;i<links.size();i++) {
				System.out.println(links.get(i).getText());
			}
		}
		@Test(priority=9)
		public static void blank_username_password() {
			WebElement stract=driver.findElement(By.xpath("//input[@type='text']"));
			stract.sendKeys("");
			String strexp="sa";
			Assert.assertNotEquals(stract, strexp);
			WebElement passact=driver.findElement(By.xpath("//input[@type='password']"));
			passact.sendKeys("");
			String passexp="sa";
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Assert.assertNotEquals(passact, passexp);
			String uname=driver.findElement(By.xpath("//div[@ id='email_error']")).getText();
			System.out.println(uname);
			String password=driver.findElement(By.xpath("//div[@ id='password_error']")).getText();
			System.out.println(password);
			System.out.println("...............................");
			
		}
		@Test(priority = 10, groups = "Regression")
		public void invalidusername_password() throws InterruptedException {

			WebElement stract = driver
					.findElement(By.xpath("html/body/div[1]/div[2]/form/div[1]/input"));
			stract.sendKeys("kiran12@gmail.com");
			String strexp = "kiran@gmail.com";
			Assert.assertNotEquals(stract, strexp);
			Thread.sleep(2000);
			stract.clear();
			WebElement passact = driver.findElement(By
					.xpath("html/body/div[1]/div[2]/form/div[2]/input"));
			passact.sendKeys("12345");
			Thread.sleep(2000);
			passact.clear();
			String passexp = "123456";
			Assert.assertNotEquals(passact, passexp);
			driver.findElement(
					By.xpath("//button[contains(text(),'Sign In')]"))
					.click();
			System.out.println("Please enter email as kiran@gmail.com");
			System.out.println("Please enter password 123456");
			System.out.println("....................................");

		}
		@Test(priority=11)
		public static void validUsername_Password() throws InterruptedException{
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("kiran@gmail.com");
			
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			System.out.println("online");
			System.out.println("......................");
		}
		@Test(priority=12)
		public static void Verify_url_DashBoard() {
			//Actual url
			String my_url=driver.getCurrentUrl();
			System.out.println("page title is"+my_url);
			//expected url
			String expected_url="file:///F:/Selinium%20File/Selenium%20Software/Offline%20Website/pages/examples/dashboard.html";
			AssertJUnit.assertEquals(my_url, expected_url);
			System.out.println("...................");
			
	
		}
		@Test(priority=13)
		public static void VerifyApplicationTitle_DashBoard() {
			//Actual title
			String my_title=driver.getTitle();
			System.out.println("page title is "+my_title);
			System.out.println(".......................");
			
	//expected title
			String expected_title="AdminLTE 2 | DashBoard";
			AssertJUnit.assertEquals(my_title, expected_title);
			System.out.println("********************");
		}
		@Test(priority=14) 
		public static void heading_Dashboard() throws InterruptedException{
			String stitle=driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
			String exp="Dashboard control panel";
			AssertJUnit.assertEquals(stitle,exp);
			System.out.println("Application title verify"+stitle);
			System.out.println("........................");
			Thread.sleep(2000);
					
		}
		@Test(priority=15)
		public static void click_onUser() throws InterruptedException{
			driver.findElement(By.xpath("//a[@href='users.html']")).click();
			Thread.sleep(20000);
			driver.findElement(By.xpath("//span[@class='label label-danger']")).click();
			//click on first delete button
			@SuppressWarnings("unused")
			Alert alt=driver.switchTo().alert();
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
		}
	
		
}

