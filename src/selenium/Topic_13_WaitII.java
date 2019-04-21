package selenium;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import javafx.util.Duration;
public class Topic_13_WaitII {
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
	@Test
	public void TC_05_AjaxLoading_WithoutExplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='contentWrapper']")).isDisplayed());

		String beforeDateSelected = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText();
		System.out.println("Date before selected is: " + beforeDateSelected);

		driver.findElement(By.xpath("//a[text() = '17']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1' and text()='Wednesday, April 17, 2019']")).isDisplayed());

		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '17']/parent::td[@class='rcSelected']")).isDisplayed());

		String afterDateSelected = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText().trim();
		System.out.println("Date after selected is: " + afterDateSelected);

		Assert.assertEquals(afterDateSelected, "Wednesday, April 17, 2019");
	}

	@Test
	public void TC_05_AjaxLoading_WithExplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		waitExplicit = new WebDriverWait(driver, 30);

		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='contentWrapper']")));
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@class='contentWrapper']")).isDisplayed());

		String beforeDateSelected = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText();
		System.out.println("Date before selected is: " + beforeDateSelected);

		driver.findElement(By.xpath("//a[text() = '17']")).click();

		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='raDiv']")));
		// Assert.assertTrue(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1' and text()='Wednesday, April 17, 2019']")).isDisplayed());

		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = '17']/parent::td[@class='rcSelected']")));
		// Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '17']/parent::td[@class='rcSelected']")).isDisplayed());

		String afterDateSelected = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText().trim();
		System.out.println("Date after selected is: " + afterDateSelected);

		Assert.assertEquals(afterDateSelected, "Wednesday, April 17, 2019");
	}

	@Test
	public void TC_06_FluentWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://daominhdam.github.io/fluent-wait/");
		waitExplicit = new WebDriverWait(driver, 30);
		
		WebElement countdount =  driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));
		waitExplicit.until(ExpectedConditions.visibilityOf(countdount));

		// Khởi tạo Fluent wait
		new FluentWait<WebElement>(countdount)
		           // Tổng time wait là 15s
//		           .withTimeout(Duration.seconds(15))
		            // Tần số mỗi 1s check 1 lần
//		            .pollingEvery(Duration.seconds(1))
		           // Nếu gặp exception là find ko thấy element sẽ bỏ  qua
//		            .ignoring(NoSuchElementException.class)
		            // Kiểm tra điều kiện
		            .until(new Function<WebElement, Boolean>() {
		                @Test
						public Boolean apply(WebElement element) {
		                           // Kiểm tra điều kiện countdount = 00
		                           boolean flag =  element.getText().endsWith("00");
		                           System.out.println("Time = " +  element.getText());
		                           // return giá trị cho function apply
		                           return flag;
		                }
		           });
	}

	@Test
	public Date getDateTimeSecond() {
		Date date = new Date();
		date = new Date(date.getTime());
		return date;
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}


}
