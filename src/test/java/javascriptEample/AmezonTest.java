package javascriptEample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmezonTest {
	 WebDriver driver;
		@BeforeTest
		public void openApp()
		{
			WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.amazon.com/");
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		@AfterTest
		public void closeApp() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.close();
		}
		@Test
		public void amz()
		{
			WebElement we = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",we);
			we.click();
			
		}
}
