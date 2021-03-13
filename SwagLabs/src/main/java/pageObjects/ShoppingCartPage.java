package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//These are all the encapsulated objects for the Your Cart page.
public class ShoppingCartPage {

	public WebDriver driver;
	private By checkoutBtn = By.cssSelector(".btn_action.checkout_button");

	// constructor
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	// getter methods
	public WebElement getCheckoutBtn() {
		return driver.findElement(checkoutBtn);
	}
}
