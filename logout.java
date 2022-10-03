package miniproject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logout {

WebDriver driver;
	
	@BeforeTest
	public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.swiggy.com/");
        driver.manage().window().maximize();
	}
	@Test
	
	public void main() throws Exception {

		//login
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div/a[1]")).click();
		driver.findElement(By.id("mobile")).sendKeys("9381294409");
		driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/form/div[2]/a")).click();
		
		//enter otp manually
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/div[2]/form/div[2]/div[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/button/span[2]")).click();
		driver.get("https://www.swiggy.com/my-account");
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[2]/div"))).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[2]/div/div[2]/div/div/div/div/a[5]"))).click().perform();
		System.out.println("logout successful");
	}
	@AfterTest
	public void quit() throws InterruptedException {
		Thread.sleep(300);
		driver.close();
	}
	


}
