package testng;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_06_Depend {
	
	  @Test(groups="payment", description ="Create account for all user")
	  public void TC_01() {
		  System.out.println("Run testcase 01");
		  Assert.assertTrue(false);
	  }
	  
	  @Test(groups="payment",priority=5, dependsOnMethods = "TC_01")
	  public void TC_02() {
		  System.out.println("Run testcase 02");
	  }
	  @Test(groups= {"customer"}, description = "Create account for all customer",priority=1,dependsOnMethods = "TC_02")
	  public void TC_03() {
		  System.out.println("Run testcase 03");
	  }
	  
	  @Test(groups="customer",priority=4,dependsOnMethods = "TC_03")
	  public void TC_04() {
		  System.out.println("Run testcase 04");
	  }
	  
	  @Test(groups="order",priority=2)
	  public void TC_05() {
		  System.out.println("Run testcase 05");
	  }
	  
	  @Test(groups="order")
	  public void TC_06() {
		  System.out.println("Run testcase 06");
	  }
}
