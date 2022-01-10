package testExample;

import org.testng.annotations.Test;

public class AddTest  extends BaseTest {
	  @Test(priority = 1)
	    public void addCustomer() throws Exception  {
		 lp. logInApp(cf.getAdminUser(),cf.getAdminPass());
	     Thread.sleep(2000);
	     log.info("validating the addcustomer functionality");
		  ad.Click();

	    }

}
