package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class Twotest extends Base {
	public WebDriver	driver;
	@Test
	public void testTwo() throws IOException, InterruptedException {
		
		System.out.println("Inside TestTwo");
		
		driver = initializeBrowser();
	
	driver.get("http://omayo.blogspot.com/");
	
	Thread.sleep(2000);
	
	Assert.assertTrue(false);
	driver.close();
	}

}
