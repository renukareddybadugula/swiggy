package com.SwiggyTesting;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select; 
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test; 

public class Filters {
	
	
	public static WebDriver driver;

	@BeforeTest
	
	public void setUp() throws InterruptedException{ 

		System.setProperty("webdriver.chrome.driver","C:\\Users\\harshada_more\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	     driver = new ChromeDriver(); 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/search"); 
        driver.manage().window().maximize();
		Thread.sleep(2000); 
		System.out.println("SetUp Successful !!"); 
	
}
	
	@Test
	
	public void filterTest() throws InterruptedException {
		
		driver.findElement(By.className("_1fiQt")).click();
		Thread.sleep(10000);
		
		WebElement Test1 = driver.findElement(By.cssSelector("div._3arMG div.nDVxx div._3kbpE div._29kDH._3pFoM:nth-child(5) div._1LV_f.undefined div._10p2- div.k4axS div._19Aso div._2LB31 div._3IrNP div._3Ynv- div._2-ofZ:nth-child(7) > span.h0xOG"));
		Test1.click();
		System.out.println("Website allows using of filter option before searching");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='overlay-sidebar-root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]")).click();
		Thread.sleep(2000);
		
		
		Test1.click();
		System.out.println("All the Filter Options is opened");
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[1]/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[9]/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[13]/div/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[3]/div[1]/div[2]/label[8]/div/div[1]")).click();
		Thread.sleep(1000);
		
		System.out.println("Filter option allows to filter the user requirements in it");
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div[4]/div/a[2]")).click();
		Thread.sleep(1000);
		
		System.out.println("Results displayed with applied filters on the page");
	}
	
	@AfterTest 
	public void tearDown(){ 

	driver.quit(); 

	} 
}