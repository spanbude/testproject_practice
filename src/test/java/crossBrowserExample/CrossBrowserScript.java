package crossBrowserExample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrossBrowserScript extends BaseTestParallel {
	  @Test
	    public void verifyOrgangeHRMLoginTest() throws InterruptedException {
	        driver.get("https://opensource-demo.orangehrmlive.com/");

	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	        driver.findElement(By.id("btnLogin")).click();
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, "OrangeHRM");
	        Thread.sleep(4000);
	        
	        
	        driver.findElement(By.cssSelector("a#welcome")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.linkText("Logout")).click();
	        Thread.sleep(2000);
	    }

	    
}
