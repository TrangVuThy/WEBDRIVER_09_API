package testng;

import org.testng.annotations.Test;


public class Topic_02_Groups {
	
	  @Test(groups="payment", description ="Create account for all user",priority=3)
	  public void TC_01() {
		  System.out.println("Run testcase 01");
	  }
	  
	  @Test(groups="payment",priority=5)
	  public void TC_02() {
		  System.out.println("Run testcase 02");
	  }
	  @Test(groups= {"customer"}, description = "Create account for all customer",priority=1)
	  public void TC_03() {
		  System.out.println("Run testcase 03");
	  }
	  
	  @Test(groups="customer",priority=4)
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
