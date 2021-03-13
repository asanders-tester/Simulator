package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//These are all the encapsulated objects for the Checkout: Your Information page.
public class CheckoutInfoPage {

	public WebDriver driver;

	// constructor
	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	private By firstName = By.cssSelector("#first-name");
	private By lastName = By.cssSelector("#last-name");
	private By zipCode = By.cssSelector("#postal-code");
	private By continueBtn = By.cssSelector("input[value='continue' i]");

	// getter methods
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}

	public WebElement getLastName() {
		return driver.findElement(lastName);
	}

	public WebElement getZipCode() {
		return driver.findElement(zipCode);
	}

	public WebElement getContinueBtn() {
		return driver.findElement(continueBtn);
	}

}
