package handelcontrol;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcApp  {

	 WebDriver driver;
//	 Properties prop;
		@BeforeTest
		public void openApp() throws IOException
		{
			WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
	        driver.manage().window().maximize();
//	        FileInputStream fi=new FileInputStream(".\\Irctc\\irctc.properties");
//		     prop=new Properties();
//			prop.load(fi);
//	        driver.get(prop.getProperty("url"));
//	        config c= new config();
//	        driver.get(c.username());
	        driver.get("https://www.irctc.co.in/nget/train-search");
           driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      
		}
		@AfterTest
		public void closeApp() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.quit();
		}
		@Test
		public void demo() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			Thread.sleep(2000);
			String mainwindow = driver.getWindowHandle();
//			
			driver.findElement(By.xpath("//a[contains(text(),' HOTELS ')]")).click();
			Thread.sleep(2000);
			Set<String> tabs = driver.getWindowHandles();
			
			String window1 = (String) tabs.toArray()[0];
			System.out.print("window1 handle code = " + tabs.toArray()[0]);

			String window2 = (String) tabs.toArray()[1];
			System.out.print("\nwindow2 handle code = " + tabs.toArray()[1]);

			
			driver.switchTo().window(window2);
			WebElement log = driver.findElement(By.xpath("//a[@data-toggle='modal']"));
			Actions a=new Actions(driver);
			a.moveToElement(log).click().build().perform();
			
			
			Thread.sleep(2000);
//			driver.findElement(By.xpath(prop.getProperty("xp_username"))).sendKeys("admin");
			
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
			WebElement button = driver.findElement(By.xpath("//button[text()='Login']"));
			a.moveToElement(button).click().build().perform();
			
			
			 WebElement act_text = driver.findElement(By.xpath("(//p[contains(text(),'Invalid User details')])[1]"));
			System.out.println("msg is :"+act_text.getText());
//    		Assert.assertEquals(act_text,"Invalid User details");
			
			driver.findElement(By.xpath("//i[@class='fa fa-close']")).click();
			driver.switchTo().window(window1);
			WebElement contactus = driver.findElement(By.xpath(" //a[contains(text(),'CONTACT US')] "));
			a.moveToElement(contactus).click().build().perform();
			
			WebElement text = driver.findElement(By.xpath("//span[contains(text(),'You may')]"));
			String acthual = text.getText();
			System.out.println("acthual text is="+acthual);
//			Assert.assertEquals(acthual," ");
			Thread.sleep(2000);
			
			
			
		}
}

