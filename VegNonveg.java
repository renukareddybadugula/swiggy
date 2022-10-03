package com.SwiggyTesting;



import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VegNonveg {
	public static WebDriver driver;
	public static WebElement edit,dish;
	/*public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harshada_more\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 
       driver.get("https://www.swiggy.com/search");
       driver.manage().window().maximize();
       Thread.sleep(2000);
       //System.out.println("SetUp Successful !!");
        
       driver.findElement(By.name("location")).sendKeys("Nagpur");
       driver.findElement(By.xpath("//span[contains(text(),'Nagpur, Maharashtra, India')]")).click();
       Thread.sleep(1000);
         
       driver.findElement(By.xpath("//a[@href='/search']")).click();
       System.out.println("User on the Search Page !!");
       driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[1]/div/form/div/div[1]/input")).sendKeys("KFC");
     
 
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/button[1]")).click();
      System.out.println("restaurant");
      // Dishes button is selected
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/span[2]/span")).click();
      System.out.println("Dishes are shown ");
      Thread.sleep(2000);
      
      */
       
       @BeforeTest
		public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harshada_more\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		 driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/search");
       driver.manage().window().maximize();
       Thread.sleep(2000);
      // System.out.println("SetUp Successful !!");
		}
		
		
       //SetLocation
		@Test(priority=0)
		public void setLocation() throws InterruptedException {
        driver.findElement(By.name("location")).sendKeys("Nagpur");
        driver.findElement(By.xpath("//span[contains(text(),'Nagpur, Maharashtra, India')]")).click();
        Thread.sleep(1000);
		}
		
		
        //SearchPage
		@Test(priority=1)
		public void vegSelect() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/search']")).click();
        Thread.sleep(2000);
        System.out.println("User on the Search Page !!");
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[1]/div/form/div/div[1]/input")).sendKeys("KFC");
      
  
       driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/button[1]")).click();
       System.out.println("restaurant");
       // Dishes button is selected
       driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/span[2]/span")).click();
       System.out.println("Dishes are shown ");
       Thread.sleep(2000);
       
      // veg option is selected
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[3]/div[1]/div/div/div[5]/div/div/button")).click();
      System.out.println("Veg option is selected");
      Thread.sleep(5000);
      // veg dishes on left side is displayed
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[5]")).isDisplayed();
      System.out.println("Veg dishes which are displayed on left side");
      Thread.sleep(3000);
      // Veg dishes are displayed on right side
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[5]")).isDisplayed();
      System.out.println("Veg dishes which are displayed on right side ");
      Thread.sleep(3000);
      //veg option is is unselected
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[3]/div[1]/div/div/div[4]/div/div/button/span")).click();
      System.out.println("Veg option is disselected");
      Thread.sleep(3000);
		}
		@Test(priority=2)
		public void nonVegSelect() throws InterruptedException {
      // Non-veg is selected
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[3]/div[1]/div/div/div[6]/div/div/button")).click();
      System.out.println("Non-veg option is selected");
      Thread.sleep(3000);
      // Non-Veg dishes are displayed on left-side
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[4]")).isDisplayed();
      System.out.println("Non-veg dishes which are displayed on left side");
      Thread.sleep(3000);
      // Non-veg displayed hich are displayed on Right-side
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[5]")).isDisplayed();
      System.out.println("Non-veg didhes which are displayed on right side");
      Thread.sleep(3000);
      //Non-veg option is unselected
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/div/div/div[3]/div[1]/div/div/div[4]/div/div/button")).click();
      System.out.println("Non-veg option is disselected");
      Thread.sleep(3000);
	}

}
