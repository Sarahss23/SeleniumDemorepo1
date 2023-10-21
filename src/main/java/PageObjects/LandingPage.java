package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
// globally  declare webdriver driver in pageobjectmodel classes
	//create constructor with webdriver parameters
	//declare this.driver inside constructor 
	//create pagefactory.iniElements and assign driver,this
	//initialize webElements and also CREATE PUBLIC METHOD for them return, and make webElements private webElement
	
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccountDropdown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	public WebElement myAccountDropdown() {

		return myAccountDropdown;
	}

	public WebElement loginOption() {
		return loginOption;

	}
}
