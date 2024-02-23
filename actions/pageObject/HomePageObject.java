package pageObject;

import org.openqa.selenium.WebDriver;

import bankguru.BasePage;
import bankguru.PageGeneratorManager;
import pageUI.bankguru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailField(String textValue) {
		waitForElementVisible(driver, HomePageUI.EMAIL_FIELD);
		sendkeyToElement(driver, HomePageUI.EMAIL_FIELD, textValue);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, HomePageUI.SUBMIT_BUTTON);
		clickToElement(driver, HomePageUI.SUBMIT_BUTTON);
	}

	public void inputToEmailToGetAccessDetails(String textValue) {
		inputToEmailField(textValue);
		clickToSubmitButton();
	}

	public LoginPageObject openLoginPage() {
		openPageUrl(driver, "https://demo.guru99.com/v4/");
		return PageGeneratorManager.getLoginPage(driver);
	}

}
