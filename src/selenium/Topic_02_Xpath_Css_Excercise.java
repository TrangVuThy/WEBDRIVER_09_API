package selenium;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic_02_Xpath_Css_Excercise {
	WebDriver driver;
	
	 @BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/");
	  }
	 Random rd = new Random();

//  @Test
//  public void TC_01_EmailAndPasswordEmpty() {
//	 driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
//	 driver.findElement(By.id("email")).sendKeys("");
//	 driver.findElement(By.name("login[password]")).sendKeys("");
//	 driver.findElement(By.xpath("//button[@title='Login']")).click();
//	 
//	String messageEmail=driver.findElement(By.id("advice-required-entry-email")).getText();
//	Assert.assertTrue(messageEmail.equals("This is a required field."));
//	Assert.assertFalse(messageEmail.equals("This is a required field.shshhs"));
//	Assert.assertEquals(messageEmail, "This is a required field.");
//	
//	String messagePassword= driver.findElement(By.id("advice-required-entry-pass")).getText();
//	Assert.assertEquals(messagePassword, "This is a required field.");
//	  }
//  
//  @Test
//  public void TC_02_LoginEmail() {
//	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//	  driver.findElement(By.id("email")).sendKeys("123434234@12312.123123");
//	  driver.findElement(By.id("send2")).click();
//	  
//	  String messageEmailInvalid = driver.findElement(By.id("advice-validate-email-email")).getText();
//	  Assert.assertTrue(messageEmailInvalid.equals("Please enter a valid email address. For example johndoe@domain.com."));
//	  Assert.assertFalse(messageEmailInvalid.equals("Please enter a valid email addresskslsmm,s,,s,slsl"));
//	  Assert.assertEquals(messageEmailInvalid, "Please enter a valid email address. For example johndoe@domain.com.");
//	  }
//  
//  @Test
//  public void TC_03_LoginPasswordSmaller6character() {
//	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//	  driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
//	  driver.findElement(By.name("login[password]")).sendKeys("123");
//	  driver.findElement(By.id("send2")).click();
//	  String messagePassInvalid = driver.findElement(By.id("advice-validate-password-pass")).getText();
//	  Assert.assertTrue(messagePassInvalid.equals("Please enter 6 or more characters without leading or trailing spaces."));
//	  Assert.assertFalse(messagePassInvalid.equals("Please enter 6 or more characters without leading or trailing spsss"));
//	  Assert.assertEquals(messagePassInvalid, "Please enter 6 or more characters without leading or trailing spaces.");
//	  
//  }
//  
//  @Test
//  public void TC_04_LoginPasswordIncorrect() {
//	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//	  driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
//	  driver.findElement(By.name("login[password]")).sendKeys("123123123");
//	  driver.findElement(By.id("send2")).click();
//	  String messagePasswordIncorrect = driver.findElement(By.xpath("//li[@class='error-msg']//ul//li//span")).toString();
//	  
//	 System.out.println(messagePasswordIncorrect);
//	  Assert.assertTrue(messagePasswordIncorrect.equals("Invalid login or password."));
//	  Assert.assertFalse(messagePasswordIncorrect.equals("Invalid login or password.kajkaja"));
//	  Assert.assertEquals(messagePasswordIncorrect, "Invalid login or password.");
//	  
//  }
//  
  
  @Test
  public void TC_05_CreateAnAccount() {
	  driver.findElement(By.xpath("//a[@class=\"skip-link skip-account\"]")).click();
	  driver.findElement(By.xpath(".//*[@id='header-account']/div/ul/li[5]/a")).click();
	  driver.findElement(By.id("firstname")).sendKeys("Lka");
	  driver.findElement(By.id("middlename")).sendKeys("Moa");
	  driver.findElement(By.id("lastname")).sendKeys("Thko");
	  driver.findElement(By.id("email_address")).sendKeys(rd.toString()+"@"+rd.toString()+"."+rd.toString());
	  driver.findElement(By.id("password")).sendKeys("123456");
	  driver.findElement(By.id("confirmation")).sendKeys("123456");
	  driver.findElement(By.id("form-validate")).click();
	  String messagePasswordIncorrect = driver.findElement(By.xpath("//ul[@class=\"messages\"]//li//ul//li//span")).toString();
	  
	 System.out.println(messagePasswordIncorrect);
	  Assert.assertTrue(messagePasswordIncorrect.equals("Thank you for registering with Main Website Store."));
//	  Assert.assertFalse(messagePasswordIncorrect.equals("Invalid login or password.kajkaja"));
	  Assert.assertEquals(messagePasswordIncorrect, "Thank you for registering with Main Website Store.");
	  
  }
  
  
 
  @AfterTest
  public void afterTest() {
	  driver.quit(); 
  }
  
}
