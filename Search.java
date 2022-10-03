package com.SwiggyTesting;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import com.swiggy.page.SearchPage;

public class Search {
		WebDriver driver;
		WebElement edit;
		String result1;
		//SearchPage s = new SearchPage(driver);
		
		@SuppressWarnings("deprecation")
		@BeforeTest
		public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harshada_more\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/search");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        System.out.println("SetUp Successful !!");
        
		}
		 
		@Test(priority = 1)
		public void webTest01() throws Exception {
        
         driver.findElement(By.name("location")).sendKeys("Nagpur");
         driver.findElement(By.xpath("//span[contains(text(),'Nagpur, Maharashtra, India')]")).click();
         //driver.findElement(By.xpath("//span[contains(text(),'FIND FOOD')]")).click();
         Thread.sleep(3000);
         
        //driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[1]/ul[1]/li[5]/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//a[@href='/search']")).click();
        System.out.println("User on the Search Page !!");
        edit = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        edit.click();
        //s.setSearch("ksjd");
        edit.sendKeys("ksjd");
        Thread.sleep(3000);
        
        //s.setSearch("SFGYV");
        edit.sendKeys("SFGYV");
        Thread.sleep(3000);
        System.out.println("Search Box field is editable by User !!");
        edit.clear(); 
        }
		
		@Test(priority = 2)
		public void webTest02() throws Exception {
        edit.sendKeys("KFC");
        //s.setSearch("KFC");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/div[2]/div[1]/b[1]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'KFC')]")).click();
        System.out.println("Tested using valid Restaurant name !!");
        Thread.sleep(3000);
		}
        
		@Test(priority = 3)
		public void webTest03() throws Exception {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/search']")).click();
        edit = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        edit.click();
        //s.clickSearch();
        //s.setSearch("Paneer Butter Masala");
        edit.sendKeys("Paneer Butter Masala");
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/div[2]/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[9]/div[1]/div[1]/a[1]/div[1]/div[1]")).click();
     	Thread.sleep(3000);
     	System.out.println("Tested using valid food name !!");
}
     	
		@Test(priority = 4)
		public void webTest04() throws Exception {
        driver.findElement(By.xpath("//a[@href='/search']")).click();
        edit = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //s.clickSearch();
        edit.click();
        //s.setSearch("Furniture");
        edit.sendKeys("Furniture");
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/div[2]/div[1]")).click();
        //result1 = driver.findElement(By.xpath("//div[contains(text(),'No match found for \"Furniture\"')]")).getText();
        //System.out.println("Tested using invalid Restaurant/food name! Error msg - "+result1);
		}
        
		@AfterTest
		public void quitDriver() throws Exception {
			driver.quit();
		}

}