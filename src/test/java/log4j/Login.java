package log4j;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	 @Test
	    public void login() {
	        
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        
	        Logger log = Logger.getLogger("LT_Logger");
	        PropertyConfigurator.configure("C:\\Users\\admin\\eclipse-workspace\\com.org.lti.banking\\Log4j.properties file");
	        
	        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	        
	        log.info("******************************");
	        
	        
	        log.info("HRM Application launched.");
	        
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        
	        log.info("Entered UserName");
	        
	        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	        
	        log.info("Entered Password");
	        
	        driver.findElement(By.id("btnLogin")).click();
	        
	        log.info("Clicked on Loggin Button");
	        
	        
	        String actual = driver.findElement(By.cssSelector("h1")).getText();
	        
	        if(actual.contains("Dash")) {
	            
	            
	            Assert.assertTrue(true, "Dashboard verification passed");
	            log.info("Dashboard verification ------ passed");
	        }
	        else {
	            
	            Assert.assertTrue(true,"Dashboard verification failed" );
	            log.info("Dashboard verification ------ failed");
	        }

}
}
