package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//These are all the encapsulated objects for the Login page.
public class LoginPage {

	public WebDriver driver;

	private By username = By.cssSelector("#user-name");
	private By password = By.cssSelector("#password");
	private By loginBtn = By.cssSelector("#login-button");
	private By errorBtn = By.cssSelector(".error-button");

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// getter methods
	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}

	public List<WebElement> getErrorBtn() {
		return driver.findElements(errorBtn);
	}
}
