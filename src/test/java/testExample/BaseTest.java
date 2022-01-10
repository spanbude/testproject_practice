package testExample;



import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageExample.Add_CustomerPage;
import pageExample.LoginPage;
import pageExample.Search_Customer;
import utility.config;
import utility.report;


public class BaseTest    {
    WebDriver driver;
    LoginPage lp;
    Add_CustomerPage ad;
    Logger log ;
    Search_Customer se;
    config cf;
    
    @BeforeClass
    @Parameters("browser")
    public void lanunchApp( String browser) throws Exception {
    	
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

        
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        //lp = new LoginPage(driver);
        
        lp = new LoginPage(driver);
        ad= new  Add_CustomerPage(driver);
        se= new Search_Customer(driver);
        cf= new config();
        
        //for log Information
        log = Logger.getLogger("LT_Logger");
        PropertyConfigurator.configure("C:\\Users\\admin\\eclipse-workspace\\com.org.lti.banking\\Log4j.properties file");
        driver.get(cf.getAppURL());
        log.info("******************************");
        log.info("nopcommerce Application launched.");
        
//        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }
    
    @AfterClass
    public void closeApp() throws Exception {
        Thread.sleep(4000);
        driver.quit();
        }
    public static String randomestring(){
    	String generatedString1 = RandomStringUtils.randomAlphabetic(5);
    	return (generatedString1);

}
}
