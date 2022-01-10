package testExample;

import org.testng.annotations.Test;

public class Search_CustomerTest extends BaseTest {
	
	@Test(priority = 1)
    public void search_cust() throws Exception {
    lp. logInApp("admin@yourstore.com","admin");
    ad.Click();
    log.info("entering the email");
    String random=randomestring()+"jhon@gmial.com";
    se.emailField(random);
    log.info("entering the firstname");
	se.fnameField(cf.getFirstName());
	log.info("entering the lastname");
	se.LnameField(cf.getLastName());
	log.info("selecting gender");
	se.gender();
	log.info("save the customer");
	se.btnsave();

    }
	
}
