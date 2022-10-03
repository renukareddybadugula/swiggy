package com.SwiggyTesting;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Location {

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
    public void location_Test() throws InterruptedException {
    	
    	driver.findElement(By.id("location")).sendKeys("Bangalore");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/button[1]")).click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/div/span[3]")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.className("Ku2oK")).click();
        Thread.sleep(10000);
    }
    
    @AfterTest
    public void tearDown(){

   driver.quit();

   }
    
}
