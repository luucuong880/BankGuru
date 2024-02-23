package pageObject;

import org.openqa.selenium.WebDriver;

import bankguru.BasePage;
import bankguru.PageGeneratorManager;
import pageUI.bankguru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailBox(String userID) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_BOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_BOX, userID);
	}

	public void inputToPasswordBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_BOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_BOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public ManagerPageObject loginToCustomerPage(String userID, String password) {
		inputToEmailBox(userID);
		inputToPasswordBox(password);
		clickToLoginButton();
		return PageGeneratorManager.getManagerPage(driver);
	}

}
