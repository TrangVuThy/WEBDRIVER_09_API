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

public class Topic_03_WebElement_WebBrowser_Exercise2 {
	WebDriver driver;
	By emailpath = By.xpath("//input[@id='mail']");
	 By educationArea= By.xpath("//textarea[@id='edu']");
	 By AgeRadio= By.xpath("//input[@id=\"under_18\"]");
	 By JobRole1= By.xpath("//select [@id=\"job1\"]");
	 By development= By.xpath("//input[@id='development']");
	 By slide1= By.xpath("//input[@id='slider-1']");
	 By buttonEnabled= By.xpath("//button[@id='button-enabled']");
	 By passWord = By.xpath("//input[@id='password']");
	 By RadioDisable = By.xpath("//input[@id=\"radio-disabled\"]");
	 
	 @BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	    }
	 
	 @Test
	  public void TC_01_KtraPtuHienThi(){
		 driver.get("https://daominhdam.github.io/basic-form/index.html");
		 if(isElementDisplayed(emailpath)) {
			 driver.findElement(emailpath).sendKeys("Autumation Testing");
		 }
		 if(isElementDisplayed(educationArea)) {
			 driver.findElement(educationArea).sendKeys("Autumation Testing");
		 }
		 if(isElementDisplayed(AgeRadio)) {
			 driver.findElement(AgeRadio).click();			 
		 }
       }
	 public boolean isElementDisplayed(By value) {
		  if(driver.findElement(value).isDisplayed()) {
			  return true;
		  }else {
			  return false;
			}
	 }
	 
	 @Test
	 public void TC_02_Enable_Disable()  {
		 System.out.println("Elements are enable is: ");
		 driver.get("https://daominhdam.github.io/basic-form/index.html");
		 if(isEnableDisable(emailpath)) {
			System.out.println("Email");
		 }
		
		 if(isEnableDisable(AgeRadio)) {
			 System.out.println("Under 18");			 
		 }
		 if(isEnableDisable(educationArea)) {
			 System.out.println("Education");	 
		 }
		 if(isEnableDisable(JobRole1)) {
			 System.out.println("Automation Test");	 
		 }
		 if(isEnableDisable(development)) {
			 System.out.println("Development");	 
		 }
		 if(isEnableDisable(slide1)) {
			 System.out.println("slide1");	 
		 }
		 if(isEnableDisable(buttonEnabled)) {
			 System.out.println("buttonEnabled");	 
		 }
		 System.out.println("Elements are disable is:");
		 if(!isEnableDisable(passWord)) {
			 System.out.println("passWord");	 
		 }
		 if(!isEnableDisable(RadioDisable)) {
			 System.out.println("RadioDisable");	 
		 }
       }
		 public boolean isEnableDisable(By value) {
		  if(driver.findElement(value).isEnabled()) {
			  return true;
		  }else {
			  return false;
			  	  }
	 
	 } 
 
		 public void TC_03_IsSelected() {
			driver.get("https://daominhdam.github.io/basic-form/index.html");
						
			 if(!isSeleted(AgeRadio)) {
				 driver.findElement(AgeRadio).click();

				 System.out.println("Selected Under 18");	 
			 }
			 if(!isSeleted(development)) {
				 driver.findElement(development).click();
				 System.out.println("Selected development");	 
			 }
			 if(!isSeleted(AgeRadio)) {
				 driver.findElement(AgeRadio).click(); 
			 }
			 if(!isSeleted(development)) {
				 driver.findElement(development).click(); 
			 }
			 if(!isSeleted(AgeRadio)) {
				 System.out.println("Not select Uder 18");
			 }
			 if(!isSeleted(development)) {
				 System.out.println("Not select development");
			 }
			 
	       }
			 public boolean isSeleted(By value) {
			  if(driver.findElement(value).isSelected()) {
				  return true;
			  }else {
				  return false;
				  	  }
		 
		 } 
	 
 
  @AfterTest
  public void afterTest() {
	  driver.quit(); 
  }
  
}
