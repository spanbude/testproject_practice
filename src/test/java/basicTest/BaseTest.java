package basicTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import configExample.configReaderExample;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
		 WebDriver driver;
		 configReaderExample s;
			@BeforeTest
			public void openApp() throws IOException
			{
				WebDriverManager.chromedriver().setup();
		        driver= new ChromeDriver();
		        driver.manage().window().maximize();
		         s= new configReaderExample();
		         driver.get(s.ul());
		        
			}
			@AfterTest
			public void closeApp() throws InterruptedException
			{
				Thread.sleep(2000);
				driver.close();
			
			}

}
