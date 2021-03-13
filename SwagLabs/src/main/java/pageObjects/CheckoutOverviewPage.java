package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//These are all the encapsulated objects for the Checkout: Overview page.
public class CheckoutOverviewPage {

	public WebDriver driver;

	// constructor
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	private By itemPrice = By.cssSelector(".inventory_item_price");
	private By totalPrice = By.cssSelector(".summary_subtotal_label");
	private By finishBtn = By.cssSelector(".btn_action.cart_button");

	// getter methods
	public List<WebElement> getItemPrice() {
		return driver.findElements(itemPrice);
	}

	public WebElement getTotalPrice() {
		return driver.findElement(totalPrice);
	}

	public WebElement getFinishBtn() {
		return driver.findElement(finishBtn);
	}
}
