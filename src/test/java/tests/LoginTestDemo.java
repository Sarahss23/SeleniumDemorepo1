package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
//import junit.framework.Assert;
import resources.Base;

public class LoginTestDemo extends Base {
//create loginpage method
	//create object for landingpage and access landing page methods by making it child class of Base class
	//create object for loginpage and use data provider testNG annotations
	//create object for accountpage page and access account methods
	//use log4j logs for everysteps in test execution
	Logger log;

	@Test(dataProvider = "getLoginData")
	public void loginTest(String email, String password, String expectedResult) throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");

		LoginPage loginpage = new LoginPage(driver);

		loginpage.emailAddressTextField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginpage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on Login Button");
		String actualresult = null;

		AccountPage accountpage = new AccountPage(driver);

		try {
			accountpage.accountinfo().isDisplayed();
			log.debug("User got logged in");
			actualresult = "Successful";
		} catch (Exception e) {
			log.debug("User didn't log in");
			actualresult = "Failure";
		}

		Assert.assertEquals(actualresult, expectedResult);
		log.info("Login Test got passed");
	}

	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTestDemo.class.getName());
		
		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	@AfterMethod
	public void tearDown() {

		driver.close();
		log.debug("Browser got closed");
	}

	@DataProvider
	public Object[][] getLoginData() {

		Object[][] data = { { "sarahsaad23@gmail.com", "12345", "Successful" },
				{ "dummy@test.com", "1234", "Failure" } };

		return data;

	}

}

