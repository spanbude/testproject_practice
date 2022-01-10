package pageExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Add_CustomerPage {

	 WebDriver driver;

	    public Add_CustomerPage(WebDriver rdriver) {

	        this.driver = rdriver;
	        PageFactory.initElements(rdriver, this);

	    }
	    @FindBy(xpath = "//p[text()[normalize-space()='Customers']]")
	    WebElement customers;

		@FindBy(how = How.XPATH, using="//p[text()=' Customers']")
		private WebElement customers2;
		
		@FindBy(how = How.XPATH, using="//a[@class='btn btn-primary']")
		private WebElement addNew;
		
		
		
		 public void Click() throws InterruptedException  {
		        
		       customers.click();
		       Thread.sleep(4000);
		       customers2.click();
		       addNew.click();

		    }
}
