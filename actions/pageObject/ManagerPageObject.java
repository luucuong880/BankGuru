package pageObject;

import org.openqa.selenium.WebDriver;

import bankguru.BasePage;
import pageUI.bankguru.ManagerPageUI;

public class ManagerPageObject extends BasePage {
	private WebDriver driver;

	public ManagerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object getHeadingTitle() {
		waitForElementVisible(driver, ManagerPageUI.HEADING_TEXT);
		return getElementText(driver, ManagerPageUI.HEADING_TEXT);
	}

}
