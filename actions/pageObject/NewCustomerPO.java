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

	public Object getErrorMessage(String idValue) {
		waitForElementVisible(driver, NewCustomerPageUI.ERROR_MESSAGE, idValue);
		return getElementText(driver, NewCustomerPageUI.ERROR_MESSAGE, idValue);
	}

	public NewCustomerPO reloadPage() {
		refreshCurrentPage(driver);
		return PageGeneratorManager.getNewCustomerPage(driver);
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

	public Object getSuccessMessage() {
		waitForElementVisible(driver, NewCustomerPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, NewCustomerPageUI.SUCCESS_MESSAGE);
	}

	public Object getInfoMationSuccess(String textValue) {
		waitForElementVisible(driver, NewCustomerPageUI.INFOMATION_SUCCES, textValue);
		return getElementText(driver, NewCustomerPageUI.INFOMATION_SUCCES, textValue);
	}

}
