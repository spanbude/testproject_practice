package crossBrowserExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestParallel {

	 public WebDriver driver;

	    @BeforeTest
	    @Parameters("browser")
	    public void setup(String browser) throws Exception {

	        if (browser.equalsIgnoreCase("firefox")) {

	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }
	        // Check if parameter passed as 'chrome' from testNG.xml file
	        else if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }

	        else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        } 
	        else {
	            // If no browser passed throw exception
	            throw new Exception("Browser is not correct");
	        }
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    }

	    @AfterTest
	    public void closeBrowser() {
	        driver.close();
	    }

}
