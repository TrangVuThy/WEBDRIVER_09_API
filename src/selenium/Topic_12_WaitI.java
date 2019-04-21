package selenium;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Topic_12_WaitI {
	WebDriver driver;
	By startbtn = By.xpath("//div[@id='start']/button");
	By loadingIcon = By.xpath("//div[@id='loading']/img");
	By helloWorld = By.xpath("//div[@id='finish']/h4[text()='Hello World!']");
	
	
WebDriverWait waitExplicit;
	@BeforeTest
	  public void beforeTest() {
//		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	 

	  }

	
	public void TC_01_Implicit5s() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(startbtn).click();
		//Maats 5s de render ra Hello World text
		Assert.assertTrue(driver.findElement(helloWorld).isDisplayed());
	}
	
	public void TC_02_LoadingIconInvisible() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 waitExplicit = new WebDriverWait(driver, 5);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(startbtn).click();
		//Maats 5s de render ra Hello World text
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		Assert.assertTrue(driver.findElement(helloWorld).isDisplayed());
	}
	
	public void TC_03_LoadingHelloVisible() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 waitExplicit = new WebDriverWait(driver, 2);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		//Maats 5s de render ra Hello World text
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(helloWorld));
		Assert.assertTrue(driver.findElement(helloWorld).isDisplayed());
	}
	@Test
	public void TC_04_LoadingHello_loadingIcon_NoLongerInDOM() {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		 waitExplicit = new WebDriverWait(driver, 5);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
// khong hien thi va khong co trong DOM
		System.out.println("Start times"+ getDateTimeSecond());
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(helloWorld));
		System.out.println("End times"+ getDateTimeSecond());
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));

		driver.findElement(startbtn).click();
		System.out.println("Start times"+ getDateTimeSecond());
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		System.out.println("End times"+ getDateTimeSecond());
		System.out.println("Start times"+ getDateTimeSecond());
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(startbtn));
		System.out.println("End times"+ getDateTimeSecond());

		Assert.assertTrue(driver.findElement(helloWorld).isDisplayed());
		
	}
	
	@AfterTest
	public void TC_AfterTest() {
	driver.quit();
	}
	public Date getDateTimeSecond() {
		Date date = new Date();
		date = new java.sql.Timestamp(date.getTime());
		return date;
	}
}
