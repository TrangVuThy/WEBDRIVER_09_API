package testng;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_07_Loop {
	
	  @Test(invocationCount=3)
	  public void TC_01() {
		  System.out.println("Run testcase 01");
		  Assert.assertTrue(false);
	  }
	 
}
