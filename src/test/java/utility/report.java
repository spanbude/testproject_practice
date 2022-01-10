package utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class report {
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	  public static ExtentReports extent;
	public ExtentTest logger;
	@BeforeTest
	public static ExtentReports startReport() {
		// htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
		// "/test-output/LT_ExtentReport.html");
		String dateName_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter("./nopcommerce_report/LT_nopcommerce"+dateName_number+".html");
		// Create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "nopcommerce");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "Swapnil Panbude");
		htmlReporter.config().setDocumentTitle("Functional Automation/API Report");
		// Name of the report
		htmlReporter.config().setReportName("Regression Report");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.DARK);
		return extent;
	}


}
