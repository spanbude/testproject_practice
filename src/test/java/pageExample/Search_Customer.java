package pageExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Search_Customer {
	WebDriver driver;
	public Search_Customer (WebDriver redriver) {

	        this.driver = redriver;
	        PageFactory.initElements(redriver, this);

	    }
	    

	@FindBy(how = How.ID, using="Email")
	private WebElement email;
	
	@FindBy(how = How.ID, using="FirstName")
	private WebElement firstName;
	
	
	
	@FindBy(how = How.ID, using="LastName")
	private WebElement lastName;
	
	
	@FindBy(how = How.ID, using="Gender_Male")
	private WebElement male;
	
	
	@FindBy(how = How.NAME, using="save")
	private WebElement save;
	
	
	

	

	public void emailField(String em){
		
		email.sendKeys(em);

	    }
	public void fnameField(String Fname)
	{
		firstName.sendKeys(Fname);
		
	}
	
	public void LnameField(String Lname) {
		lastName.sendKeys(Lname);
	}
	public void gender() {
		male.click();
	}
	public void btnsave() {
		save.click();
	}


}
