package actionConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ruto {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#nav-xshop>a:nth-of-type(7)")).click();

		driver.navigate().back();
		driver.navigate().back();
		driver.get("https://www.amazon.ca/");
	}

}
