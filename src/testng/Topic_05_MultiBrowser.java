package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Topic_05_MultiBrowser {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void preCondition(String browserName) {
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver= new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("headless")) {
           System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");		
 ChromeOptions options= new ChromeOptions();
 options.addArguments("headless");
 options.addArguments("window-size=2560x1440");

 driver = new ChromeDriver(options);
           
		}
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
			}
	@Parameters({"username","password"})
	  public void Login_01_LoginWithValidInformation(String us, String pass) {
		driver.get("http://live.guru99.com");
		  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
           driver.findElement(By.xpath("//input[@id='email']")).sendKeys(us);
         driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
         driver.findElement(By.xpath("//button[@id='send2']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed());
           driver.findElement(By.xpath("//span[text()='Account']")).click();
         driver.findElement(By.xpath("//a[text()='Log Out']")).click();
         Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'This is demo site')]")).isDisplayed());

	  }
  
	@AfterTest
		public void postCondition() {
		
		
	}
}
