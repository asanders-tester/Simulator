package automationChallenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CheckoutInfoPage;
import pageObjects.CheckoutOverviewPage;
import pageObjects.ProductsPage;
import pageObjects.ShoppingCartPage;
import resources.Base;
import resources.Utils;

//This class has all of the test cases that are executed on the Checkout: Overview page.
public class CheckoutOverviewPageTest extends Base {

	public WebDriver driver;
	private Utils util;
	private ProductsPage pp;
	private ShoppingCartPage yourCart;
	private CheckoutInfoPage info;
	private CheckoutOverviewPage overview;

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

	// Verify that the total price of items in the cart is correct
	// Test executed with standard user and performance glitch user
	@Test(dataProvider = "valid", dataProviderClass = Utils.class)
	public void verifyTotal(String username, String password) {
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

		overview = new CheckoutOverviewPage(driver);
		List<WebElement> items = overview.getItemPrice();
		List<String> amountList = new ArrayList<String>();

		// Get item prices from webelement list and add to array list of string values
		for (int i = 0; i < items.size(); i++) {
			String amount = items.get(i).getText();
			amountList.add(amount);
		}

		// Get each price from their index, remove $ and parse to a double
		String amount1 = amountList.get(0);
		amount1 = amount1.substring(1);
		double amount1Value = Double.parseDouble(amount1);

		String amount2 = amountList.get(1);
		amount2 = amount2.substring(1);
		double amount2Value = Double.parseDouble(amount2);

		// Add amounts together
		double sumOfProducts = amount1Value + amount2Value;

		WebElement total = overview.getTotalPrice();
		// Get the text from subtotal line and 'cut out' the amount
		String subtotal = total.getText().substring(13, 18);
		// Parse string to a double
		double expectedSubtotal = Double.parseDouble(subtotal);

		// Verify by comparing the added value to the extracted subtotal value
		Assert.assertEquals(sumOfProducts, expectedSubtotal);
	}

}
