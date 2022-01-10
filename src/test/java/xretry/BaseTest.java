package xretry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 WebDriver driver;
	    @BeforeTest
	    public void launchApp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        
	    }
	    
	    @AfterTest
	    public void closeApp() throws Exception {
	        
	        Thread.sleep(4000);
	        driver.quit();
	        
	    }
	    

}
