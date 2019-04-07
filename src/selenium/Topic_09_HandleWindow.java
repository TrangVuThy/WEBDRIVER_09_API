package selenium;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic_09_HandleWindow {
	WebDriver driver;
	JavascriptExecutor js;
	 @BeforeTest
	  public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor)driver;
	  }
//
//  @Test
//  public void Test_Script_02() throws Exception {
//	  //Parent Window
//	  driver.get("https://daominhdam.github.io/basic-form/index.html");
//	  String parentID = driver.getWindowHandle();
//	  System.out.println("ParentID "+parentID);
//	  //Click lần 1
//	  driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//	  Thread.sleep(2000);
//	  switchToChildWindowbyID(parentID);
//
//	 
//	  String googleTittle = driver.getTitle();
//	  Assert.assertEquals(googleTittle, "Google");
//	  Assert.assertTrue(closeAllWithoutParentWindows(parentID));
//	  Assert.assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");  
//  }
//  
//  
//  @Test
//  public void Test_Script_03() throws Exception {
//	  driver.get("http://www.hdfcbank.com/");
//		// Khai bao notificationIframe
//	  
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		List <WebElement> notificationIframe = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
//		int notificationIframeSize = notificationIframe.size();
//		System.out.println("Notification iframe displayed = "+notificationIframeSize);
//		if(notificationIframeSize>0) {
//			 driver.switchTo().frame(notificationIframe.get(0));
//			 Assert.assertTrue(driver.findElement(By.xpath("//div[@id='container-div']/img")).isDisplayed());
//			 driver.findElement(By.xpath("//div[@id='container-div']/img")).click();
//			Assert.assertTrue(driver.findElement(By.xpath("//span[@id='messageText' and text()='What are you looking for?']")).isDisplayed());
//			 //Close popup đó
//			
//			
//			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='div-close']")));
//			System.out.println("Close popup success");
//			
//			driver.switchTo().defaultContent();
//			
//		}
//		System.out.println("Pass handel popup");
//
//	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	  String parentID = driver.getWindowHandle();
//	  driver.findElement(By.xpath("//a[text()='Agri']")).click();
//	  switchToChildWindowbyID(parentID);
//	  driver.findElement(By.xpath("//p[text()='Account Details']")).click();
//	  switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
//	  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='footer']")));
//	  driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
//	  switchToWindowByTitle("HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
//	  driver.findElement(By.xpath("//div[@class='hygeinenav']//a[text()='CSR']")).click();
//	  Assert.assertTrue(closeAllWithoutParentWindows(parentID));
//
//	  
//  }
//  
  @Test
  public void Test_Scrpit_04() throws Exception{
	  driver.get("http://live.guru99.com/index.php/");
	  String parentID = driver.getWindowHandle();
	  driver.findElement(By.xpath("//a[text()='Mobile']")).click();
	  driver.findElement(By.xpath("//html[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("//html[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("//div[@class='actions']//button[@title='Compare']")).click();
	  switchToWindowByTitle("Products Comparison List - Magento Commerce");
	  Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
	  System.out.println(driver.getTitle());
	  closeAllWithoutParentWindows(parentID);
	  
  }
  
// Switch to child Windows (only 2 windows)
  public void switchToChildWindowbyID(String parent) {
	  // lấy ra id của tất cả các cửa sổ đang có
      Set<String> allWindows = driver.getWindowHandles();
      for (String runWindow : allWindows) {
                  if (!runWindow.equals(parent)) {
                              driver.switchTo().window(runWindow);
                              break;
                  }
      }
}
  
//  Switch to child Windows (greater than 2 windows and title of the pages are unique)
  public void switchToWindowByTitle(String expectTitle) {
      Set<String> allWindows = driver.getWindowHandles();
      for (String runWindows : allWindows) {
                  driver.switchTo().window(runWindows);
                  String currentWin = driver.getTitle();
                  if (currentWin.equals(expectTitle)) {
                              break;
                  }
      }
}
  
//  Close all windows without parent window
  public boolean closeAllWithoutParentWindows(String parentWindow) {
      Set<String> allWindows = driver.getWindowHandles();
      for (String runWindows : allWindows) {
                  if (!runWindows.equals(parentWindow)) {
                              driver.switchTo().window(runWindows);
                              driver.close();
                  }
      }
      driver.switchTo().window(parentWindow);
      if (driver.getWindowHandles().size() == 1)
                 return true;
      else
                 return false;
}

  @AfterTest
  public void afterTest() {
//	  driver.quit(); 
  }
  
}
