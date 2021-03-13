package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//These are all the encapsulated objects for the Finish page.
public class FinishPage {

	public WebDriver driver;

	// constructor
	public FinishPage(WebDriver driver) {
		this.driver = driver;
	}

	private By ponyExpressImage = By.cssSelector(".pony_express");

	// getter methods
	public WebElement getPonyExpressImage() {
		return driver.findElement(ponyExpressImage);
	}
}
