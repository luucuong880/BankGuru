package pageObject.user;

import org.openqa.selenium.WebDriver;

import liveguru.user.BasePage;
import liveguru.user.PageGeneratorManager;
import pageUI.user.MobilePageUI;

public class MobilePageObject extends BasePage {
	private WebDriver driver;

	public MobilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostOfProducts(String productsItem) {
		waitForElementVisible(driver, MobilePageUI.PRODUCTS_NAME, productsItem);
		return getElementText(driver, MobilePageUI.PRODUCTS_NAME, productsItem);
	}

	public MobilePageObject clickAddLinks(String textValue, String classValue) {
		waitForElementClickable(driver, MobilePageUI.ADD_LINKS, textValue, classValue);
		clickToElement(driver, MobilePageUI.ADD_LINKS, textValue, classValue);
		return PageGeneratorManager.getPageGeneratorManager().getMobilePage(driver);
	}

	public ComparePageObject clickToCompareButton() {
		waitForElementClickable(driver, MobilePageUI.COMPARE_BUTTON);
		clickToElement(driver, MobilePageUI.COMPARE_BUTTON);
		switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		return PageGeneratorManager.getPageGeneratorManager().getComparePage(driver);
	}

}