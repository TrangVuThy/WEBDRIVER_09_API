package selenium;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

@Test
public class Topic_11_UploadFile {
	WebDriver driver;
	String rootFolder = System.getProperty("user.dir");
	String image1 ="anh1.PNG";
	String image2 ="anh2.PNG";
	String image3 ="anh3.PNG";
	String chrome ="chrome.exe";
	String firefox ="firefox.exe";
	String ie ="ie.exe";
	String FilePathImage1 = rootFolder + "\\UploadFile\\" + image1;
	String FilePathImage2 = rootFolder + "\\UploadFile\\" + image2;
	String FilePathImage3 = rootFolder + "\\UploadFile\\" + image3;
	
	String ChromePath = rootFolder + "\\UploadFile\\" + chrome;
	String FilefoxPath = rootFolder + "\\UploadFile\\" + firefox;
	String IEPath = rootFolder + "\\UploadFile\\" + ie;
	
	String [] paths = {FilePathImage1, FilePathImage2, FilePathImage3};

@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Get path of file
		//C:\Users\trang\git\WEBDRIVER_09_API\github\WEBDRIVER_09_API\UploadFile\anh1.PNG
		

	  }

//  @Test
//  public void TC_01_Upload_File_By_Sendkeys_Queue() {
//	 driver.get("http://blueimp.github.com/jQuery-File-Upload/");
//	 for(String path : paths) {
//	 WebElement upLoadFilebtn= driver.findElement(By.xpath("//input[@type='file']"));
//	 upLoadFilebtn.sendKeys(path);
//	 try {
//		Thread.sleep(1000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	 }
//	 driver.findElement(By.xpath("//span[text()='Start upload']")).click();
//	 
//	 Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image1  +"']")).isDisplayed());
//	 Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image2  +"']")).isDisplayed());
//	 Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image3  +"']")).isDisplayed());
//
//  }
//  
//@Test
//  public void TC_02_Upload_File_By_Sendkeys_Alloftime() throws Exception{
//	 driver.get("http://blueimp.github.com/jQuery-File-Upload/");
//	
//	 WebElement upLoadFilebtn= driver.findElement(By.xpath("//input[@type='file']"));
//	 upLoadFilebtn.sendKeys(FilePathImage1+"\n"+FilePathImage2+"\n"+FilePathImage3);
//	Thread.sleep(1000);
//	 List <WebElement> listE = driver.findElements(By.xpath("//table[@class='table table-striped']//button[@class='btn btn-primary start']"));
//	 	 for(WebElement btn : listE) {
//	 		 clickToElementByJS(btn);
//	 		 Thread.sleep(1000);
//	 	 }
//	 Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image1  +"']")).isDisplayed());
//	 Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image2  +"']")).isDisplayed());
//	 Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image3  +"']")).isDisplayed());
//
//  }
//  
public void TC_03_AutoIT() throws Exception{
	 driver.get("http://blueimp.github.com/jQuery-File-Upload/");
	 if(driver.toString().contains("chrome")) {
	 WebElement upLoadFilebtn= driver.findElement(By.cssSelector(".fileinput-button"));
    clickToElementByJS(upLoadFilebtn);
    Thread.sleep(2000);
	Runtime.getRuntime().exec(new String[] {ChromePath, chrome});

	 }else if(driver.toString().contains("firefox")) {
		 WebElement upLoadFilebtn= driver.findElement(By.xpath("//input[@type='file']"));
		 upLoadFilebtn.click();
		 Thread.sleep(2000);
			Runtime.getRuntime().exec(new String[] {FilefoxPath, firefox});

	}else {
		 WebElement upLoadFilebtn= driver.findElement(By.xpath("//span[contains(text(),'Add files...')]"));
		 upLoadFilebtn.click();
		 Thread.sleep(2000);
			Runtime.getRuntime().exec(new String[] {IEPath, ie});
	}
	 //Excute exe
	
}
public void TC_04_Robot() throws Exception{
	 driver.get("http://blueimp.github.com/jQuery-File-Upload/");
Thread.sleep(2000);
	// Specify the file location with extension
    StringSelection select = new  StringSelection(ChromePath);

    // Copy to clipboard
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

    if (driver.toString().contains("chrome")  || driver.toString().contains("firefox")) {
        WebElement uploadFile =  driver.findElement(By.cssSelector(".fileinput-button"));
        uploadFile.click();
        Thread.sleep(1000);
    } else {
        System.out.println("Go to IE");
        WebElement uploadFile =  driver.findElement(By.xpath("//input[@type='file']"));
        clickToElementByJS(uploadFile);
        Thread.sleep(1000);
    }

    Robot robot = new Robot();
    Thread.sleep(1000);

    // Nhan phim Enter
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

    // Nhan xuong Ctrl - V
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);

    // Nha Ctrl - V
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
    Thread.sleep(1000);

    // Nhan Enter
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
}


public Object clickToElementByJS(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return js.executeScript("arguments[0].click();", element);
}
  @AfterTest
  public void afterTest() {
	  driver.quit(); 
  }
  
}
