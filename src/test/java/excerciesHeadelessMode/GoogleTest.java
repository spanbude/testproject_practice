package excerciesHeadelessMode;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	WebDriver driver;
	@Test
	public void openApp() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		driver = new ChromeDriver(option);
       
        
         driver.get("https://www.amazon.com/");
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
         Thread.sleep(3000);
         ssShot();
         
         //screenshot
         
//         TakesScreenshot sr= (TakesScreenshot)driver;
//         File source = sr.getScreenshotAs(OutputType.FILE);
//         File target= new File(".\\Result\\Screenshot1.png");
         
//         There are two way to copy the file from source to target
//      (1)   FileHandler.copy(source, target);   
//      (2)   FileUtils.copyFile(screenshotFile, target);
}
	public void ssShot() throws IOException
	{
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File target= new File(".\\Result\\Screenshot3.png");
		 FileUtils.copyFile(screenshotFile, target);
}
	
}
