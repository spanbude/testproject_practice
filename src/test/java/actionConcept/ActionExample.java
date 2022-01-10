package actionConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionExample {
	 WebDriver driver;
	@BeforeTest
	public void openApp()
	{
		WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
	}
	@AfterTest
	public void closeApp() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	
	}
	@Test
	public void dragDrop() throws InterruptedException
{
		
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		WebElement source = driver.findElement(By.xpath("//div[contains(@id,'draggable')]"));
		WebElement Target = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-header ui-droppable')]"));
		Actions Act= new Actions(driver);
		Act.dragAndDrop(source, Target).perform();
}
}
