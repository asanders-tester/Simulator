package resources;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;

//This class will have reusable methods.
public class Utils {

	public WebDriver driver;
	private LoginPage lp;
	private ProductsPage pp;

	// constructor
	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	// Method to be called when a user needs to log in
	// Uses login info specified in test and clicks login button
	public void login(WebDriver driver, String username, String password) {
		lp = new LoginPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginBtn().click();
	}

	// Method to be called when items need to be added to cart
	public void addItems(WebDriver driver, String[] productItemsNeeded) {
		pp = new ProductsPage(driver);
		List<WebElement> product = pp.getInventoryItemName();
		int itemsFound = 0;

		// Iterates through array and converts to array list
		for (int i = 0; i < product.size(); i++) {
			String item = product.get(i).getText();
			List<String> itemsList = Arrays.asList(productItemsNeeded);
			if (itemsList.contains(item)) {
				// Locates items specified in test and clicks Add To Cart button
				pp.getCartBtn().get(i).click();
				itemsFound++;

				// When number of items in array is equal to number of items in array list,
				// leaves loop
				if (itemsFound == productItemsNeeded.length) {
					break;
				}
			}
		}
	}

	// Method to be called when items need to be removed from cart
	public void removeItems(WebDriver driver) {
		pp = new ProductsPage(driver);
		List<WebElement> buttons = pp.getRemoveFromCartBtn();

		// Iterates through list of webelements and clicks only 'remove' buttons
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).click();
		}
	}

	// Username and password combos for valid users
	@DataProvider(name = "valid")
	public static Object[][] getValidLoginInfo() {
		Object[][] validLogin = new Object[2][2];
		validLogin[0][0] = "standard_user";
		validLogin[0][1] = "secret_sauce";

		validLogin[1][0] = "performance_glitch_user";
		validLogin[1][1] = "secret_sauce";

		return validLogin;
	}

	// Username and password combos for invalid users
	@DataProvider(name = "invalid")
	public static Object[][] getInvalidLoginInfo() {
		Object[][] invalidLogin = new Object[2][2];
		invalidLogin[0][0] = "locked_out_user";
		invalidLogin[0][1] = "secret_sauce";

		invalidLogin[1][0] = "standard_user";
		invalidLogin[1][1] = "secretsauce";

		return invalidLogin;
	}
}
