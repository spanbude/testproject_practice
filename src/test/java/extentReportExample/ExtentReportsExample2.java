package extentReportExample;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;

public class ExtentReportsExample2 {
	 public WebDriver driver;
	    public ExtentHtmlReporter htmlReporter;
	    public ExtentReports extent;
	    public ExtentTest logger;

	    @BeforeTest
	    public void startReport() {
	        // htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
	        // "/test-output/LT_ExtentReport.html");
	        String dateName_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        htmlReporter = new ExtentHtmlReporter("./test-output/LT_NOPComm_ExtentReport"+dateName_number+".html");
	        // Create an object of Extent Reports
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	        
	        extent.setSystemInfo("Host Name", "Localhost");
	        extent.setSystemInfo("Environment", "Production");
	        extent.setSystemInfo("User Name", "Rajesh Singh");
	        htmlReporter.config().setDocumentTitle("Functional Automation/API Report");
	        // Name of the report
	        htmlReporter.config().setReportName("Regression Report");
	        // Dark Theme
	        htmlReporter.config().setTheme(Theme.DARK);
	        
	    }

	    // This method is to capture the screenshot and return the path of the
	    // screenshot.
	    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        // after execution, you could see a folder "FailedTestsScreenshots" under src
	        // folder
	        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        return destination;
	    }

	    @BeforeClass
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	    }

	    @Test(priority=0)
	    public void verifyTitle() {
	        logger = extent.createTest("To verify NOP comm Application Title");
	        Assert.assertEquals(driver.getTitle(), "Your store. Login");
	    }

	    @Test(priority=1)
	    public void verifyLogin() throws Exception {
	        logger = extent.createTest("To verify Login feature");
	        
	        
	        driver.findElement(By.name("Email")).clear();
	        driver.findElement(By.name("Email")).sendKeys("admin@yourstore.com");
	        driver.findElement(By.name("Password")).clear();
	        driver.findElement(By.name("Password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        
	        Thread.sleep(4000);
	        
	    }
	    
	    @Test(priority=2)
	    public void verifyLogout() {
	        logger = extent.createTest("To verify Logout feature");
	        driver.findElement(By.xpath("")).click();
	        
	        //Assert.assertTrue(false); //failed test case
	        
	    }
	    
	    

	    @AfterMethod
	    public void getResult(ITestResult result) throws Exception {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            // MarkupHelper is used to display the output in different colors
	            logger.log(Status.FAIL,
	                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	            logger.log(Status.FAIL,
	                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	            String screenshotPath = getScreenShot(driver, result.getName());
	            // To add it in the extent report
	            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	        } 
	        else if (result.getStatus() == ITestResult.SKIP) {
	            logger.log(Status.SKIP,
	                    MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	        } 
	        else if (result.getStatus() == ITestResult.SUCCESS) {
	            logger.log(Status.PASS,
	                    MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
	        }
	        
	    }

	    @AfterClass
	    public void closeApp() throws Exception {
	        Thread.sleep(2000);
	        driver.quit();
	    }
	    
	    @AfterTest
	    public void endReport() {
	        extent.flush();
	    }
	}


