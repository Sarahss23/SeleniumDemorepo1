package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class Threetest extends Base {

	@Test
	public void testThree() throws IOException, InterruptedException {
		
		System.out.println("Inside Test Three");
		
		WebDriver	driver = initializeBrowser();
		
		driver.get("https://www.facebook.com/login/");
		
		Thread.sleep(2000);
		driver.close();
	}
}
