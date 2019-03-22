package selenium;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import selenium.Topic_03_WebElement_WebBrowser_Exercise;

public class Topic_06_Button_Radio_Checkbox_Alert {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	
	@BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		jsExecutor= (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
 
	 @Test
	  public void TC_01_CREATE_AN_ACCOUNT(){
		driver.get("http://live.guru99.com/");
		WebElement myAccountElement= driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		jsExecutor.executeScript("arguments[0].click();",myAccountElement );
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/login/");
		   WebElement creatAccount=driver.findElement(By.xpath("//a[@title='Create an Account']"));
		jsExecutor.executeScript("arguments[0].click();",creatAccount );
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/create/");
	 }
	 
	 @Test
	  public void TC_02_TelerikCheckbox() throws Exception{
		driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		WebElement dualZoneCheckbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
	   //1 click
		checkToRadioButtonOrToCheckbox(dualZoneCheckbox);
		Thread.sleep(3000);
		//2 verify
	   Assert.assertTrue(dualZoneCheckbox.isSelected());
	   //3 uncheck
	   uncheckCheckbox(dualZoneCheckbox);
	  //4 verify uncheck
	   Assert.assertFalse(dualZoneCheckbox.isSelected());
	   
	   
	 }
	 
	 @Test
	 public void TC_05_Accept_Confirm_Promt_Alert() throws Exception{
		 driver.get("https://daominhdam.github.io/basic-form/index.html");
		 //JS Alert Accept
		 driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		 Alert acceptAlert = driver.switchTo().alert();
		 Thread.sleep(3000);
		Assert.assertEquals(acceptAlert.getText(), "I am a JS Alert");
		 acceptAlert.accept();
		 Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result' and text()='You clicked an alert successfully ']")).isDisplayed());
		
		 //JS Alert Confirm
		 driver.navigate().refresh();
		 driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		 Alert acceptConfirm = driver.switchTo().alert();
		 Thread.sleep(3000);
		 Assert.assertEquals(acceptConfirm.getText(), "I am a JS Confirm");
		 acceptConfirm.dismiss();
		 Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result' and text()='You clicked: Cancel']")).isDisplayed());
		 
		 //JS Alert promt
		 driver.navigate().refresh();
		 driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		 Alert acceptPromt = driver.switchTo().alert();
		 Assert.assertEquals(acceptPromt.getText(), "I am a JS prompt");
		 acceptPromt.sendKeys("Automation Test");
		 Thread.sleep(3000);
		 acceptPromt.accept();
		 Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result' and text()='You entered: Automation Test']")).isDisplayed());
		 Thread.sleep(3000);
	 }

	 @Test
	 public void TC_07_AuthencationAlert() throws Exception{
		 driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		 Thread.sleep(3000);
		 Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
		 
	 }
	 
 public void checkToRadioButtonOrToCheckbox(WebElement element) {
		 if(!element.isSelected()) {
			 if(element.isDisplayed()) {
				element.click();
				 System.out.println("click by selenium");
			 }else {
				 jsExecutor.executeScript("arguments[0].click();", element);
				 System.out.println("click by js");
			 }
			
		 }
		 
	 }
	 public void uncheckCheckbox(WebElement element) {
		 if(element.isSelected()) {
			 jsExecutor.executeScript("arguments[0].click();", element);
		 }
		 
	 }
	 
  @AfterTest
  public void afterTest() {
	  driver.quit(); 
  }
  
}
