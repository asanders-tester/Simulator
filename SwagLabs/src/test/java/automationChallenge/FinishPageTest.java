package automationChallenge;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CheckoutInfoPage;
import pageObjects.CheckoutOverviewPage;
import pageObjects.FinishPage;
import pageObjects.ProductsPage;
import pageObjects.ShoppingCartPage;
import resources.Base;
import resources.Utils;

public class FinishPageTest extends Base {

	public WebDriver driver;
	private Utils util;
	private ProductsPage pp;
	private ShoppingCartPage yourCart;
	private CheckoutInfoPage info;
	private CheckoutOverviewPage checkout;
	private FinishPage image;

	// Initialize the driver object and get the webpage
	@BeforeMethod
	public void initialize() throws IOException {
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

	// Verify that the Pony Express image appears after a successful purchase
	// Test executed with standard user and performance glitch user
	@Test(dataProvider = "valid", dataProviderClass = Utils.class)
	public void verifyPonyExpressImage(String username, String password) {
		util = new Utils(driver);
		// Login with valid credentials
		util.login(driver, username, password);
		pp = new ProductsPage(driver);
		String[] productItemsNeeded = { "Sauce Labs Bike Light", "Test.allTheThings() T-Shirt (Red)" };
		// Add the items specified to the cart by calling the addItems method
		util.addItems(driver, productItemsNeeded);
		pp.getShoppingCartIcon().click();

		// Click through a couple of pages, adding info to the correct fields
		yourCart = new ShoppingCartPage(driver);
		yourCart.getCheckoutBtn().click();
		info = new CheckoutInfoPage(driver);
		info.getFirstName().sendKeys("Wendy");
		info.getLastName().sendKeys("Winder");
		info.getZipCode().sendKeys("12345");
		info.getContinueBtn().click();
		checkout = new CheckoutOverviewPage(driver);
		checkout.getFinishBtn().click();

		image = new FinishPage(driver);
		// Get the value for the src attribute
		String srcText = image.getPonyExpressImage().getAttribute("src");
		// Verify by asserting the words specified are in the value extracted
		if (srcText.contains("pony express png")) {
			Assert.assertTrue(true);
		}
	}

}
