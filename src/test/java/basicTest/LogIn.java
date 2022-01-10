package basicTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {
	@Test
	public void Log()
	{
		
		driver.findElement(By.id("txtUsername")).sendKeys(s.username());
		driver.findElement(By.id("txtPassword")).sendKeys(s.Ps());
		driver.findElement(By.cssSelector(".button")).click();
	}

}
