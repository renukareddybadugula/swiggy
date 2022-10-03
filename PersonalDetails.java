package com.SwiggyTesting;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PersonalDetails {
		public static WebDriver driver;
        
		@BeforeTest
		public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harshada_more\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("SetUp Successful !!");
		}
		
		@Test(priority=0)
		public void webtest01() throws InterruptedException {
        driver.findElement(By.className("x4bK8")).click();
		}
		@Test(priority=1)
		public void webtest02() throws InterruptedException {
        driver.findElement(By.id("mobile")).sendKeys("9021184452");
        Thread.sleep(2000);
        driver.findElement(By.className("a-ayg")).click();
        Thread.sleep(20000);
        driver.findElement(By.className("a-ayg")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("LukWG")).click();
        Thread.sleep(10000);
        driver.findElement(By.className("_1qbcC")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("DCrYO")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("_2ZH3s")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("_3QCnP")).click();
        Thread.sleep(5000);
		}
        @Test(priority=2)
		public void webtest03() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[2]/div[2]/form/div[1]/input")).clear();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[2]/div[2]/form/div[1]/input")).sendKeys("9359317483");;
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[2]/div[2]")).click();
        }
        @Test(priority=3)
		public void webtest04() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[2]/form/div[1]/input")).clear();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[2]/form/div[1]/input")).sendKeys("adamtejashri30@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div[2]/form/div[2]/div/a")).click();
        }
        @Test(priority=4)
		public void webtest05() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[4]/div[2]/div[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"newPassword\"]")).sendKeys("Royalenfield@0002");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("Royalenfield@0002");
        Thread.sleep(5000);
        }
        @AfterTest
		public void tearDown() throws InterruptedException {
        driver.close();
        }
}







