package handelcontrol;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configExample.configReaderExample;
import io.github.bonigarcia.wdm.WebDriverManager;

public class modal {
	
	
	WebDriver driver;
	 
		@BeforeTest
		public void openApp() throws IOException
		{
			WebDriverManager.chromedriver().setup();
	        driver= new ChromeDriver();
	        driver.manage().window().maximize();
	        
	         driver.get("http://www.uitestpractice.com/Students/Switchto");
	        
		}
		@AfterTest
		public void closeApp() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.close();
		
		}
		@Test
		public void modal() throws InterruptedException
		{
			driver.findElement(By.xpath("//button[@data-target='#myModal']")).click();
			WebElement act = driver.findElement(By.xpath("//h4"));
			String text = act.getText();
			System.out.println(text);
		   Assert.assertEquals(text, "Modal window demo");
		   Thread.sleep(3000);
//		 WebElement msg2 = driver.findElement(By.xpath("//div[@class='modal-body']"));
//		 Thread.sleep(3000);
//		 String text2 = msg2.getText();
//		 Thread.sleep(3000);
//		  String ex="A modal dialog is a window that forces the user to interact with it before they can go back to using the parent application. It can be gmail or facebook authentication window also.";
//		 Thread.sleep(3000);
//		 Assert.assertEquals(text2,ex);
		 driver.findElement(By.xpath("(//button[@data-dismiss='modal'])[3]")).click();
		}
		

}
