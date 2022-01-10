package xretry;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginTest extends BaseTest {
//	 @Test(priority=1, retryAnalyzer = retry.RetryLogic.class) 
	@Test(priority=1)
	    public void login() {
	        
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	        driver.findElement(By.name("Submit")).click();
	        
	    }
	    
	    
	    @Test(priority=2)
	    public void verifyDashBoard() {
	        
	        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed(), "Verification of dashboard get failed");
	        
	    }
	    
	    
//	    @Test(priority=3, retryAnalyzer = retry.RetryLogic.class)
	    @Test(priority=3)
	    public void logout() throws Exception {
	        
	        
	        driver.findElement(By.id("welcome")).click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, 15);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
	        
	        Thread.sleep(1000);
	        //driver.findElement(By.linkText("Logout11")).click();
	        Assert.assertTrue(false);
	        
	        
	    }

}
