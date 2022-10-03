package com.SwiggyTesting;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	public static WebDriver driver;

		@BeforeTest
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\harshada_more\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			//driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url= "https://www.swiggy.com/";
		driver.get(url);
		}

		//For Login
		//WebElement login = driver.findElement(By.linkText("Login"));
		@Test(priority=0)
		public void testUsingInvalidCred() throws Exception {
		driver.findElement(By.linkText("Login")).click();
		
		System.out.println("Clicking on the login element on the login page");
	//Login using Invalid credentials
		System.out.println("login using invalid Credentials");
		driver.findElement(By.id("mobile")).sendKeys("90211844");
		Thread.sleep(5000);
		driver.findElement(By.className("a-ayg")).click();
		driver.findElement(By.id("mobile")).clear();
		//Thread.sleep(30000);
		}
		@Test(priority=1)
		public void testUsingValidCred() throws Exception {
		
		//Login using valid credentials
		System.out.println("login using valid Credentials");
		driver.findElement(By.id("mobile")).sendKeys("9021184452");
		Thread.sleep(5000);

		driver.findElement(By.className("a-ayg")).click();
		Thread.sleep(30000);
		
	 	//Enter the OTP

		driver.findElement(By.className("a-ayg")).click();
		System.out.println("Entered the OTP Manually");
		
		driver.findElement(By.className("LukWG")).click();

		Thread.sleep(5000);
		}
		@AfterTest
		public void tearDown() throws Exception {
		driver.navigate().back();
		driver.close();

}
}

