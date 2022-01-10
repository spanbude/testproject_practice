package excerciesHeadelessMode;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotation {
	@BeforeTest
	public void openApp()
	{
		System.out.println("opne app");
	}
	@AfterTest
	public void closeApp()
	{
		System.out.println("close app");
	}
	@Test(priority = 0)
	public void Login()
	{
		System.out.println("Login Test Run");
	}
	@Test
	public void logOut()
	{
		System.out.println("Logout test run");
	}
	@BeforeMethod
	public void refresh()
	{
		System.out.println("Refresh the methdo...");
		
	}
	
	@AfterMethod
	public void  ssShot()
	{
		System.out.println("Take screenshot..");
		
	}

}
