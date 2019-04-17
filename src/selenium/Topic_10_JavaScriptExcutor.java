package selenium;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic_10_JavaScriptExcutor {
	WebDriver driver;
	String userIDText= "mngr181358";
	String passWord = "berydUp";
	String customerName,genDer, dateOfBirthday, address, city, state,email, pin, moblieNo, Password;
	String CustomerIDValues;
	String addressEX,cityEX,stateEX,pinEX,emailEX,moblieNoEX;
	
	By userIDTextBox = By.xpath("//input[@name=\"uid\"]");
	By passWordTextBox= By.xpath("//input[@name=\"password\"]");
	
	By CustomerNameTextBox= By.xpath("//input[@name=\"name\"]");
	By genderRadio= By.xpath("//input[@value=\"m\"]");
	By dateOfBirthdayTB= By.xpath("//input[@id=\"dob\"]");
	By addressTB= By.xpath("//textarea[@name=\"addr\"]");
	By cityTB= By.xpath("//input[@name=\"city\"]");
	By stateTB= By.xpath("//input[@name=\"state\"]");
	By pinTB= By.xpath("//input[@name=\"pinno\"]");
	By moblieNoTB= By.xpath("//input[@name=\"telephoneno\"]");
	By emailTB= By.xpath("//input[@name=\"emailid\"]");
	By PasswordTB= By.xpath("//input[@name=\"password\"]");
	By submitButton= By.xpath("//input[@value=\"Submit\"]");
	
	
	
	By firstNameE = By.xpath("//input[@title='First Name']");
	By middleNameE = By.xpath("//input[@title='Middle Name/Initial']");
	By lastNameE = By.xpath("//input[@title='Last Name']");
	By emailE = By.xpath("//div[@class='fieldset']//input[@type='email']");
	By passwordE = By.xpath("//input[@title='Password']");
	By confirmPassE =By.xpath("//input[@title='Confirm Password']");
	By btnSubmit = By.xpath("//span[text()='Register']");
	
	 @BeforeTest
	  public void beforeTest() {
		 System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		driver.findElement(userIDTextBox).sendKeys(userIDText);
		 driver.findElement(passWordTextBox).sendKeys(passWord);
		 driver.findElement(By.xpath("//input[@name=\"btnLogin\"]")).click();
		 Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
		
		 addressEX="dong da ha noi";
		 cityEX="Ha Noi";
		 stateEX="minh khai";
		 pinEX="999999";
		 emailEX="Ivy"+ Topic_03_WebElement_WebBrowser_Exercise.randomNubmer() +"@gmail.com"; 
		 moblieNoEX="0999999999";
	  }

 
//  @Test
//  public void TC_01_Name() throws Exception{
//	  navigateToUrlByJS("http://live.guru99.com/");
//	  	  String domainName = executeForBrowser("return document.domain;");
//	  Assert.assertEquals("live.guru99.com", domainName);
//     
//	  String URLName = executeForBrowser("return document.URL;");
//	  Assert.assertEquals("http://live.guru99.com/", URLName);
//	  Thread.sleep(3000);
//	  WebElement MobileE = driver.findElement(By.xpath("//a[text()='Mobile']"));
//	  Thread.sleep(3000);
//
//	  clickToElementByJS(MobileE);
//	  WebElement AddCartE= driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button"));
//	  Thread.sleep(3000);
//	  clickToElementByJS(AddCartE);
//	  
//	  String innerText = executeForBrowser("return document.documentElement.innerText");
//	  Assert.assertTrue(innerText.contains("Samsung Galaxy was added to your shopping cart."));
//	  Thread.sleep(3000);	  
//	  clickToElementByJS(driver.findElement(By.xpath("//a[text()='Privacy Policy']")));
//	 
//	  String title = executeForBrowser("return document.title");
//	  Assert.assertEquals(title, "Privacy Policy");
//	  scrollToBottomPage();
//	  Thread.sleep(3000);
//	  WebElement tabE= driver.findElement(By.xpath("//th[text()='WISHLIST_CNT']/following-sibling::td[text()='The number of items in your Wishlist.']"));
//	  Assert.assertTrue(tabE.isDisplayed());
//	  navigateToUrlByJS("http://demo.guru99.com/v4/");
//	  String domain4= executeForBrowser("return document.domain");
//	  Assert.assertEquals(domain4, "demo.guru99.com");
//	  
//  }
  
  @Test
  public void TC_02_RemoveAttribute() throws Exception{
	  clickToElementByJS(driver.findElement(By.xpath("//a[text()='New Customer']")));
	  driver.findElement(By.xpath("//a[text()=\"New Customer\"]")).click(); 
		 customerName="TrangVTAutoTest";
		 genDer="male";
		 dateOfBirthday="1994-01-01";
		 address="123 Address thanh thanh";
		 city="Ho Chi Minh";
		 state="Thu Duc";
		 pin="888888";
		 email="trangvu"+ Topic_03_WebElement_WebBrowser_Exercise.randomNubmer() +"@gmail.com"; 
		 moblieNo="0966688899";
		 passWord="123456";
		 driver.findElement(CustomerNameTextBox).sendKeys(customerName);
		 driver.findElement(genderRadio).click();
		 removeAttributeInDOM(driver.findElement(dateOfBirthdayTB), "type");
		 driver.findElement(dateOfBirthdayTB).sendKeys(dateOfBirthday);
		 driver.findElement(addressTB).sendKeys(address);
		 driver.findElement(cityTB).sendKeys(city);
		 driver.findElement(stateTB).sendKeys(state);
		 driver.findElement(pinTB).sendKeys(pin);
		 driver.findElement(moblieNoTB).sendKeys(moblieNo);
		 driver.findElement(emailTB).sendKeys(email);
		 driver.findElement(passWordTextBox).sendKeys(passWord);
		 driver.findElement(submitButton).click();
			 
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Customer Name\"]//following-sibling::td")).getText(), customerName);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Gender\"]//following-sibling::td")).getText(), genDer);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Birthdate\"]//following-sibling::td")).getText(), dateOfBirthday);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Address\"]//following-sibling::td")).getText(), address);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"City\"]//following-sibling::td")).getText(), city);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"State\"]//following-sibling::td")).getText(), state);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Pin\"]//following-sibling::td")).getText(), pin);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Mobile No.\"]//following-sibling::td")).getText(), moblieNo);
		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Email\"]//following-sibling::td")).getText(), email);
		CustomerIDValues = driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Customer ID\"]/following-sibling::td")).getText();
 
  }

  
  @Test
  public void TC_03_Creat_An_Account() throws Exception{
	  String emailS = "Vutrang"+randomNubmer()+"@gmail.com";
	  navigateToUrlByJS("http://live.guru99.com/");
	  clickToElementByJS(driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")));
	  clickToElementByJS(driver.findElement(By.xpath("//span[text()='Create an Account']")));
sendkeyToElementByJS(driver.findElement(firstNameE), "Vu");
sendkeyToElementByJS(driver.findElement(lastNameE), "Tràng");
sendkeyToElementByJS(driver.findElement(middleNameE), "Thy");
sendkeyToElementByJS(driver.findElement(emailE),emailS);
sendkeyToElementByJS(driver.findElement(passwordE), "123456");
sendkeyToElementByJS(driver.findElement(confirmPassE), "123456");
clickToElementByJS(driver.findElement(btnSubmit));
Assert.assertTrue(driver.findElement(By.xpath("//li[@class='success-msg']//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());
clickToElementByJS(driver.findElement(By.xpath("//div[@class='skip-links']//span[text()='Account']")));
clickToElementByJS(driver.findElement(By.xpath("//div[@class='links']//a[text()='Log Out']")));
Thread.sleep(6000);
String title = executeForBrowser("return document.title");
Assert.assertEquals(title, "Home page");

  }
  
  public static int randomNubmer() {
		 Random rd = new Random();
		int n = rd.nextInt(999999);
		return n;
		 	 
	 }
  
  public void highlightElement(WebElement element) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].style.border='6px groove red'", element);
  }

  public String executeForBrowser(String javaSript) {
          JavascriptExecutor js = (JavascriptExecutor) driver;
          return (String) js.executeScript(javaSript);
  }

  public Object clickToElementByJS(WebElement element) {
          JavascriptExecutor js = (JavascriptExecutor) driver;
          return js.executeScript("arguments[0].click();", element);
  }

  public Object sendkeyToElementByJS(WebElement element, String value) {
         JavascriptExecutor js = (JavascriptExecutor) driver;
         return  js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
  }

  public void removeAttributeInDOM(WebElement element, String attribute) throws Exception{
          JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
           Thread.sleep(3000);
  }

  public Object scrollToBottomPage() {
          JavascriptExecutor js = (JavascriptExecutor) driver;
          return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
  }

  public Object navigateToUrlByJS(String url) {
          JavascriptExecutor js = (JavascriptExecutor) driver;
          return js.executeScript("window.location = '" + url + "'");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit(); 
  }
  
}
