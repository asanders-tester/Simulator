package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//These are all the encapsulated objects for the Products page.
public class ProductsPage {

	public WebDriver driver;

	private By inventoryItemName = By.cssSelector(".inventory_item_name");
	private By cartBtn = By.cssSelector("button[class*='btn_inventory']");
	private By removeFromCartBtn = By.cssSelector(".btn_secondary.btn_inventory");
	private By productsTitle = By.cssSelector(".product_label");
	private By shoppingCartIcon = By.cssSelector("svg[data-icon='shopping-cart']");
	private By shoppingCartBadge = By.cssSelector(".fa-layers-counter.shopping_cart_badge");

	// constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	// getter methods
	public List<WebElement> getInventoryItemName() {
		return driver.findElements(inventoryItemName);
	}

	public List<WebElement> getCartBtn() {
		return driver.findElements(cartBtn);
	}

	public List<WebElement> getRemoveFromCartBtn() {
		return driver.findElements(removeFromCartBtn);
	}

	public WebElement getProductsTitle() {
		return driver.findElement(productsTitle);
	}

	public WebElement getShoppingCartIcon() {
		return driver.findElement(shoppingCartIcon);
	}

	public WebElement getShoppingCartBadge() {
		return driver.findElement(shoppingCartBadge);
	}
}
