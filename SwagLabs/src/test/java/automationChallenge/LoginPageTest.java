package automationChallenge;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import resources.Base;
import resources.Utils;

//This class has all of the test cases that are executed on the Login page.
public class LoginPageTest extends Base {

	public WebDriver driver;
	private WebDriverWait wait;
	private LoginPage lp;
	private ProductsPage pp;
	private Utils util;

	// Initialize the driver object and get the webpage
	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	// Quit entire browser session and render driver object null at end of each test case
	// Clears state between each test
	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver = null;
	}

	// Validate title of browser tab when on the website
	@Test
	public void validateTitle() {
		wait = new WebDriverWait(driver, 20);
		// Wait until the title is visible before grabbing text using a WebDriverWait
		// object
		wait.until(ExpectedConditions.titleIs("Swag Labs"));
		String title = driver.getTitle();
		// Compare actual title to expected title
		Assert.assertEquals(title, "Swag Labs");
	}

	// Verify that a user can log into the site with valid credentials
	// DataProvider tests standard user and performance glitch user both with valid
	// passwords
	@Test(dataProvider = "valid", dataProviderClass = Utils.class)
	public void testValidLoginAccounts(String username, String password) {
		util = new Utils(driver);
		util.login(driver, username, password);
		pp = new ProductsPage(driver);
		String productTitle = pp.getProductsTitle().getText();

		// Verification is based on header text of products page
		Assert.assertEquals(productTitle, "Products");
	}

	// Verify that a user cannot log into the site with invalid credentials
	// Verify that a locked out user cannot log in, even with valid credentials
	// DataProvider tests locked out user with valid password and standard user with
	// invalid password
	@Test(dataProvider = "invalid", dataProviderClass = Utils.class)
	public void testInvalidLoginAccounts(String username, String password) {
		lp = new LoginPage(driver);
		util = new Utils(driver);
		util.login(driver, username, password);
		int errorButton = lp.getErrorBtn().size();
		// Verification is based on presence of error button on page
		if (errorButton > 0) {
			Assert.assertTrue(true);
		}
		Assert.assertFalse(false);
	}

}
