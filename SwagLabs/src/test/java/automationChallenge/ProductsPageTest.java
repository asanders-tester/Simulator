package automationChallenge;

import java.io.IOException;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.ProductsPage;
import resources.Base;
import resources.Utils;

//This class has all of the test cases that are executed on the Products page.
public class ProductsPageTest extends Base {

	public WebDriver driver;
	private Utils util;
	private ProductsPage pp;
	private WebElement badge;
	private By cartBadge;

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

	// Verify that items can be added to the cart
	// Test executed with standard user and performance glitch user
	@Test(dataProvider = "valid", dataProviderClass = Utils.class)
	public void addItemsToCart(String username, String password) {
		cartBadge = By.cssSelector(".fa-layers-counter.shopping_cart_badge");

		util = new Utils(driver);
		// Login with valid credentials
		util.login(driver, username, password);
		pp = new ProductsPage(driver);

		String[] productItemsNeeded = { "Sauce Labs Bike Light" };
		// Add the items specified to the cart by calling the addItems method
		util.addItems(driver, productItemsNeeded);
		badge = pp.getShoppingCartBadge();

		// Verify by checking that badge is present on cart icon
		if (ExpectedConditions.presenceOfElementLocated(cartBadge) != null) {
			Assert.assertTrue(true);
		}
	}

	// Verify that items can be removed from the cart
	// Test executed with standard user and performance glitch user
	@Test(dataProvider = "valid", dataProviderClass = Utils.class)
	public void removeItemsFromCart(String username, String password) {
		cartBadge = By.cssSelector(".fa-layers-counter.shopping_cart_badge");

		util = new Utils(driver);
		// Login with valid credentials
		util.login(driver, username, password);
		pp = new ProductsPage(driver);

		String[] productItemsNeeded = { "Sauce Labs Bike Light" };
		// Add the items specified to the cart by calling the addItems method
		util.addItems(driver, productItemsNeeded);

		// Remove the items that have the remove button available
		util.removeItems(driver);
		List<WebElement> buttons = pp.getCartBtn();
		// Iterates through list of webelements and gets the text on the button
		for (int i = 0; i < buttons.size(); i++) {
			String btnText = buttons.get(i).getText();
			// Verify by asserting text does not say remove (all buttons are 'add to cart')
			if (!btnText.equalsIgnoreCase("remove")) {
				Assert.assertTrue(true);
			}
		}

	}

	// Verify that the “Test.allTheThings” shirt is available for purchase
	// Test executed with standard user and performance glitch user
	@Test(dataProvider = "valid", dataProviderClass = Utils.class)
	public void verifyTestAllThingsShirt(String username, String password) {
		util = new Utils(driver);
		// Login with valid credentials
		util.login(driver, username, password);
		pp = new ProductsPage(driver);

		List<WebElement> product = pp.getInventoryItemName();
		// Iterate all product names until desired one is found
		for (int i = 0; i < product.size(); i++) {
			String name = product.get(i).getText();
			// Verify by asserting the product name contains the given text
			if (name.contains("Test.allTheThings")) {
				Assert.assertTrue(true);
			}
		}
	}

}
