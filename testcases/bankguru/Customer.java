package bankguru;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.ManagerPageObject;
import pageObject.NewCustomerPO;
import utilities.Environment;

public class Customer extends BaseTest {
	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber) {
		ConfigFactory.setProperty("env", envName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);

		homePage = PageGeneratorManager.getHomePage(driver);

		homePage.inputToEmailToGetAccessDetails("abcx@gmail.com");
		loginPage = homePage.openLoginPage();
		managerPage = loginPage.loginToCustomerPage("mngr554412", "qUravam");
		verifyEquals(managerPage.getHeadingTitle(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void New_Customer() {
		log.info("New Customer - Step 01: Open New Customer Page at Sub Menu");
		newCustomerPage = (NewCustomerPO) managerPage.openPageAtSubMenu(driver, "New Customer");

		log.info("New Customer - Step 02: Do not enter a value Name field");
		newCustomerPage.clickToFieldbox("name");
		verifyEquals(newCustomerPage.getErrorMessage("message"), "Customer name must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 03: Enter number at value name field");
		newCustomerPage.inputToTextField("name", "1234");
		verifyEquals(newCustomerPage.getErrorMessage("message"), "Numbers are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 04: Enter First character Blank space at value name field");
		newCustomerPage.inputToTextField("name", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message"), "First character can not have space");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 05: Do not enter a value Address field");
		newCustomerPage.clickToAddressbox();
		verifyEquals(newCustomerPage.getErrorMessage("message3"), "Address Field must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 06: Enter First character Blank space at value address field");
		newCustomerPage.inputToAddressField(" ");
		verifyEquals(newCustomerPage.getErrorMessage("message3"), "First character can not have space");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 07: Do not enter a value City field");
		newCustomerPage.clickToFieldbox("city");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "City Field must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 08: Enter First character Blank space at value City field");
		newCustomerPage.inputToTextField("city", "1234");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "Numbers are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 09: Enter Special Character at value City field");
		newCustomerPage.inputToTextField("city", "@@##!");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "Special characters are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 10: Enter First Character Blank space at value City field");
		newCustomerPage.inputToTextField("city", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "First character can not have space");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 11: Do not enter at value State field");
		newCustomerPage.clickToFieldbox("state");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "State must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 12: Enter Number at value State field");
		newCustomerPage.inputToTextField("state", "12345");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "Numbers are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 13: Enter Special Character at value State field");
		newCustomerPage.inputToTextField("state", "@#$!");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "Numbers are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 14: Enter First Character Blank space at value State field");
		newCustomerPage.inputToTextField("state", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "First character can not have space");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 15: Enter character value at PIN field");
		newCustomerPage.clickToFieldbox("pinno");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "PIN Code must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 16: Do not enter at PIN field");
		newCustomerPage.clickToFieldbox("pinno");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "PIN Code must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 17: Enter Number Less than 6 digit at PIN field");
		newCustomerPage.inputToTextField("state", "123");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "PIN Code must have 6 Digits");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 18: Enter Special Character at PIN field");
		newCustomerPage.inputToTextField("state", "@#$F");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "Special characters are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 19: Enter First Character Blank space at PIN field");
		newCustomerPage.inputToTextField("state", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "First character can not have space");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 20: Enter Character Blank space at PIN field");
		newCustomerPage.inputToTextField("state", "123 ");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "Characters are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 21: Do not enter at Phone field");
		newCustomerPage.clickToFieldbox("telephoneno");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "Mobile no must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 22: Enter First Character Blank space at Phone field");
		newCustomerPage.inputToTextField("telephoneno", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "First character can not have space");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 23: Enter Character Blank space at Phone field");
		newCustomerPage.inputToTextField("telephoneno", "123 123");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "First character can not have space");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 24: Enter Special Character at Phone field");
		newCustomerPage.inputToTextField("telephoneno", "2231@#$");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "Special characters are not allowed");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 25: Do not enter value at Email field");
		newCustomerPage.clickToFieldbox("emailid");
		verifyEquals(newCustomerPage.getErrorMessage("message9"), "Email-ID must not be blank");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 26: Enter Invalid email at Email field");
		newCustomerPage.inputToTextField("emailid", "guru99");
		verifyEquals(newCustomerPage.getErrorMessage("message9"), "Email-ID is not valid");
		newCustomerPage.reloadPage();

		log.info("New Customer - Step 27: Enter Blank space at Email field");
		newCustomerPage.inputToTextField("emailid", "guru 99");
		verifyEquals(newCustomerPage.getErrorMessage("message9"), "Email-ID is not valid");
		newCustomerPage.reloadPage();
	}

	@Parameters({ "browser" })
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPO newCustomerPage;

}
