package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	protected WebDriver driver; 
	public 	Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initializeBrowser() throws IOException {
		
		//create initializeBrowser method in base class
		//declare global propertities in base class for avoid hardcoding
		//create screenshot method in base class
		
		 prop = new Properties();
		String propertiesPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fls = new FileInputStream(propertiesPath);
		prop.load(fls);
		
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		} else if(browser.equalsIgnoreCase("InternetExplorer")) {
			
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			
			return driver;
				
			
			
		}
	
public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		return destinationFilePath;
	}
		
		
	}

