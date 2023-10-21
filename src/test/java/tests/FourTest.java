package tests;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import resources.Base;

public class FourTest extends Base {

	public WebDriver	driver;
	public void testFour() throws IOException, InterruptedException {
		
		System.out.println("Inside Test Four");
		
		
			driver = initializeBrowser();
		
		driver.get("https://www.youtube.com/");
		
		Thread.sleep(2000);
		//Assert.assertTrue(false);
		driver.close();
	}
}
