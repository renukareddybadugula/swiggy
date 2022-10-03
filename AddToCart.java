package com.SwiggyTesting;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {
	
	
		public static WebDriver driver;
		
		
		
		public static WebElement edit,dish;
		public static String popupText;
		public static boolean address;
		
		//Setup
		@BeforeTest
		public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harshada_more\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/search");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("SetUp Successful !!");
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
		public void cartTest() throws InterruptedException {
         driver.findElement(By.xpath("//a[@href='/search']")).click();
         Thread.sleep(2000);
         System.out.println("User on the Search Page !!");
         
         //Search Paneer Butter Masala
         edit = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
         edit.click();
         Thread.sleep(2000);
         edit.sendKeys("Paneer Butter Masala");
         driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/div[2]/div[1]")).click();
         Thread.sleep(2000);
         
        //Clicking on the Restaurant page
         driver.findElement(By.xpath("//div[contains(text(),'By Sindh Punjab Tadka')]")).click();
         dish=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/span[2]/input"));
         dish.click();
         Thread.sleep(2000);
         dish.sendKeys("Paneer Butter Masala");
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id=\"h-1212697893\"]/div[2]/div/div/div[1]/div[2]/div/div/div[1]")).click();
         Thread.sleep(2000);
         System.out.println("Paneer Butter Masala is added to the cart");
      	 Thread.sleep(2000);
		}
		
		@Test(priority=2)
		public void viewCart() throws InterruptedException {
      	 
      	 //View the cart if item is added or not
      	 driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]")).click();
         Thread.sleep(2000);
		}
		@Test(priority=3)
		public void minimisedCart() throws InterruptedException {
      	driver.navigate().back();
      	Thread.sleep(2000);
      	driver.navigate().back();
      	System.out.println("Cart is minimised ");
      	System.out.println("reopening the cart ");
      	 driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]")).click();
         Thread.sleep(2000);
         System.out.println("User on the Cart Page !! Paneer Butter Masala is Still in the cart");
         driver.navigate().back();
         driver.navigate().back();
		}
		@Test(priority=4)
		public void addAnotherDishFromDiffRestaurant() throws InterruptedException {
         
         

        driver.findElement(By.xpath("//a[@href='/search']")).click();
        System.out.println("User on the Search Page !!");
        edit = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        edit.click();
        edit.sendKeys("KFC");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/div[2]/div[1]/b[1]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'KFC')]")).click();
        //System.out.println("Tested using valid Restaurant name !!");
        Thread.sleep(2000);
        dish=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/span[2]/input"));
        dish.click();
        Thread.sleep(2000);
        dish.sendKeys("Peri Peri 5 Leg Pc Meal");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"h-863889455\"]/div[2]/div[1]/div/div[1]/div[2]/div[4]/div[2]/div[1]")).click();
        Thread.sleep(2000);
        System.out.println("Adding Another dish from different Restaurant");
		}
		@Test(priority=5)
		public void newDishOverridePrev() throws InterruptedException {
        
        Actions a=new Actions(driver);
        WebElement popup=driver.findElement(By.xpath("//div[contains(text(),'Your cart contains items from other restaurant. Would you like to reset your cart for adding items from this restaurant?')]"));
        popupText=popup.getText();
       System.out.println(popupText);
       a.moveToElement(popup).build().perform() ;
       System.out.println("Click button - Yes, start a fresh");
       driver.findElement(By.xpath("//button[contains(text(),'Yes, start afresh')]")).click();
       
       
        Thread.sleep(2000); 
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]")).click();
        Thread.sleep(2000);
        System.out.println("User on the Cart Page !!");
        System.out.println("Peri Peri 5 Leg Pc Meal is displaying in the cart");
        Thread.sleep(2000);
		}
		@Test(priority=6)
		public void incrementQuantity() throws InterruptedException {
        driver.findElement(By.className("_1ds9T")).click(); 
        System.out.println("Quantity of Peri Peri 5 Leg Pc Meal becomes :Two");
        System.out.println("--------------------Tested with Increment option-------------------");
        Thread.sleep(2000);
		}
		@Test(priority=7)
		public void decrementQuantity() throws InterruptedException {
        driver.findElement(By.className("_29Y5Z")).click();
        Thread.sleep(2000);
        System.out.println("Quantity of Peri Peri 5 Leg Pc Meal becomes :One");
        System.out.println("----------------------Tested with Decrement option------------------");
		}
		@Test(priority=7)
		public void checkLocationTabOnCart() throws InterruptedException {
        address= driver.findElement(By.xpath("//div[contains(text(),'Delivery address')]")).isDisplayed();
        System.out.println("Location tab is present :"+address);
        System.out.println("--------------------Tested with location tab on cart option-----------------");
        Thread.sleep(2000);
		}
		@Test(priority=8)
		public void emptyCart() throws InterruptedException {
        driver.findElement(By.className("_29Y5Z")).click();
        System.out.println("Peri Peri 5 Leg Pc Meal is removed now cart is empty");
        Thread.sleep(2000);
        System.out.println("-------------------Tested by removing item from cart---------------");
        
		}
		
		@AfterTest
		public void tearDown(){
			driver.quit();
		}
     
		//}//main closing bracket

}
