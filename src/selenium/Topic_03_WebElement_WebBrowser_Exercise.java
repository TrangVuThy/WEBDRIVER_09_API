package selenium;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.protocol.MinimalServantCacheLocalCRDImpl;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic_03_WebElement_WebBrowser_Exercise {
	WebDriver driver;
	
	 @BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/");
			                }
	 public int randomNubmer() {
		 Random rd = new Random();
		int n = rd.nextInt(999999);
		System.out.println("Randơm Number is "+n);
		return n;
		 	 
	 }
	  

	 @Test
	  public void TC_05_CreateAnAccount() throws Exception {
		
		  driver.findElement(By.xpath("//div[@class=\"footer-container\"]//a[@title='My Account']")).click();
		  driver.findElement(By.xpath("//a[@title=\"Create an Account\"]")).click();
		  driver.findElement(By.id("firstname")).sendKeys("Lka");
		  driver.findElement(By.id("middlename")).sendKeys("Moa");
		  driver.findElement(By.id("lastname")).sendKeys("Thko");
		  driver.findElement(By.id("email_address")).sendKeys("automation"+randomNubmer()+"@gmail.com");;
		  driver.findElement(By.id("password")).sendKeys("123456");
		  driver.findElement(By.id("confirmation")).sendKeys("123456");
		  driver.findElement(By.xpath("//button[@title=\"Register\"]")).click();
		  String messagePasswordIncorrect = driver.findElement(By.xpath("//li[@class=\"success-msg\"]")).getText();
		 System.out.println(messagePasswordIncorrect);
		  Assert.assertTrue(messagePasswordIncorrect.equals("Thank you for registering with Main Website Store."));
//		  Assert.assertFalse(messagePasswordIncorrect.equals("Invalid login or password.kajkaja"));
		  Assert.assertEquals(messagePasswordIncorrect, "Thank you for registering with Main Website Store.");
		  
	  }

	 
	  
 
 
  @AfterTest
  public void afterTest() {
	  driver.quit(); 
  }
  
}
