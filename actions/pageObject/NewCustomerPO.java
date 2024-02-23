package pageObject;

import org.openqa.selenium.WebDriver;

import bankguru.BasePage;
import bankguru.PageGeneratorManager;
import pageUI.bankguru.NewCustomerPageUI;

public class NewCustomerPO extends BasePage {
	private WebDriver driver;

	public NewCustomerPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFieldbox(String nameValue) {
		waitForElementClickable(driver, NewCustomerPageUI.FIELD_BOX, nameValue);
		clickToElement(driver, NewCustomerPageUI.FIELD_BOX, nameValue);
		waitForElementClickable(driver, NewCustomerPageUI.BODY);
		clickToElement(driver, NewCustomerPageUI.BODY);
		sleepInSecond(2);
	}

	public Object getErrorMessage(String idValue) {
		waitForElementVisible(driver, NewCustomerPageUI.ERROR_MESSAGE, idValue);
		return getElementText(driver, NewCustomerPageUI.ERROR_MESSAGE, idValue);
	}

	public NewCustomerPO reloadPage() {
		refreshCurrentPage(driver);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}

	public void inputToTextField(String nameValue, String textValue) {
		waitForElementVisible(driver, NewCustomerPageUI.FIELD_BOX, nameValue);
		sendkeyToElement(driver, NewCustomerPageUI.FIELD_BOX, textValue, nameValue);
	}

	public void clickToAddressbox() {
		waitForElementClickable(driver, NewCustomerPageUI.ADDRESS_BOX);
		clickToElement(driver, NewCustomerPageUI.ADDRESS_BOX);
		waitForElementClickable(driver, NewCustomerPageUI.BODY);
		clickToElement(driver, NewCustomerPageUI.BODY);
		sleepInSecond(2);
	}

	public void inputToAddressField(String textValue) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_BOX);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_BOX, textValue);
	}

}
