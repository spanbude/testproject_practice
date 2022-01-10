package testExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	  // By default - priority = 0
    @Test(priority = 2)
    public void login() throws Exception {
    	 log.info("Entering UserName and password ");
        lp.enterUserName(cf.getAdminUser());
        lp.enterPassword(cf.getAdminPass());
        lp.clickLoginButton();
        

    }

    @Test(priority = 2)
    public void logout() {
    	log.info("logout to application");
        lp.clickLogout();
    }

    @Test (priority = 1)
    public void verifyTitle() {
    	log.info("verify the title");
        Assert.assertTrue(lp.getAppTitle().contains(""), "validation of application title");
    }

    @Test (priority = 0)
    		
    public void verifyLogo() {
    	 log.info("validating the logo");
        Assert.assertTrue(lp.verifyAppLogo(), "validation of application Logo");
    }
    
  
	


}
