package dataDrivenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginHrmTest {
	WebDriver driver;
	@BeforeTest
	public  void openApp()
	{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		
	}
	@AfterTest
	public  void closeApp() throws InterruptedException
	{   Thread.sleep(2000);
		driver.close();
		
	}
	@Test(dataProvider = "invalidData")
	public void logIn(String username,String pswd) throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(pswd);
	driver.findElement(By.cssSelector(".button")).click();
	
		String text = driver.findElement(By.cssSelector("span#spanMessage")).getText();
	Assert.assertEquals(text, "Invalid credentials");
	Thread.sleep(2000);
	}

	@DataProvider(name="invalidData")
	public String[][] m1()
	{
		String[][] data= {{"swapnil@gmail.com","swapnil1"},{"swap@gmail.com","Swa@234"},{"bond@gmail.com","bond002"}};
		return data;
	}
	
}
