package bankguru;

import org.openqa.selenium.WebDriver;

import pageObject.DeleteCustomerPO;
import pageObject.EditCustomerPO;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.ManagerPageObject;
import pageObject.NewCustomerPO;

public class PageGeneratorManager {

	public static PageGeneratorManager getPageGeneratorManager() {
		return new PageGeneratorManager();
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static NewCustomerPO getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPO(driver);
	}

	public static ManagerPageObject getManagerPage(WebDriver driver) {
		return new ManagerPageObject(driver);
	}

	public static EditCustomerPO getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPO(driver);
	}

	public static DeleteCustomerPO getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPO(driver);
	}
}
