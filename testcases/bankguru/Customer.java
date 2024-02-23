package bankguru;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.data.UserDataMapper;
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

		userData = UserDataMapper.getUserData();

		emailAddress = userData.getEmailAddress() + "@fakemail.com";

		customerName = userData.getFirstName() + userData.getLastName();

		dayofBirth = userData.getDay() + "/" + userData.getMonth() + "/" + userData.getYear();

		dateofBirth = userData.getYear() + "-" + userData.getMonth() + "-" + userData.getDay();

		homePage.inputToEmailToGetAccessDetails("abcx@gmail.com");
		loginPage = homePage.openLoginPage();
		managerPage = loginPage.loginToCustomerPage(userData.getLoginUsername(), userData.getLoginPassword());
		verifyEquals(managerPage.getHeadingTitle(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void New_Customer_Case_01() {
		log.info("New Customer - Step 01: Open New Customer Page at Sub Menu");
		newCustomerPage = (NewCustomerPO) managerPage.openPageAtSubMenu(driver, "New Customer");

		log.info("New Customer - Step 02: Do not enter a value Name field");
		newCustomerPage.clickToFieldbox("name");
		verifyEquals(newCustomerPage.getErrorMessage("message"), "Customer name must not be blank");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_02() {
		log.info("New Customer - Step 03: Enter number at value name field");
		newCustomerPage.inputToTextField("name", "1234");
		verifyEquals(newCustomerPage.getErrorMessage("message"), "Numbers are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_03() {
		log.info("New Customer - Step 04: Enter First character Blank space at value name field");
		newCustomerPage.inputToTextField("name", "name@#$");
		verifyEquals(newCustomerPage.getErrorMessage("message"), "Special characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_04() {
		log.info("New Customer - Step 04: Enter First character Blank space at value name field");
		newCustomerPage.inputToTextField("name", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message"), "First character can not have space");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_05() {
		log.info("New Customer - Step 05: Do not enter a value Address field");
		newCustomerPage.clickToAddressbox();
		verifyEquals(newCustomerPage.getErrorMessage("message3"), "Address Field must not be blank");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_06() {
		log.info("New Customer - Step 06: Enter First character Blank space at value address field");
		newCustomerPage.inputToAddressField(" ");
		verifyEquals(newCustomerPage.getErrorMessage("message3"), "First character can not have space");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_07() {
		log.info("New Customer - Step 07: Do not enter a value City field");
		newCustomerPage.clickToFieldbox("city");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "City Field must not be blank");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_08() {
		log.info("New Customer - Step 08: Enter First character Blank space at value City field");
		newCustomerPage.inputToTextField("city", "1234");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "Numbers are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_09() {
		log.info("New Customer - Step 09: Enter Special Character at value City field");
		newCustomerPage.inputToTextField("city", "@@##!");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "Special characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_10() {
		log.info("New Customer - Step 10: Enter First Character Blank space at value City field");
		newCustomerPage.inputToTextField("city", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message4"), "First character can not have space");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_11() {
		log.info("New Customer - Step 11: Do not enter at value State field");
		newCustomerPage.clickToFieldbox("state");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "State must not be blank");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_12() {
		log.info("New Customer - Step 12: Enter Number at value State field");
		newCustomerPage.inputToTextField("state", "12345");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "Numbers are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_13() {
		log.info("New Customer - Step 13: Enter Special Character at value State field");
		newCustomerPage.inputToTextField("state", "@#$!");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "Special characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_14() {
		log.info("New Customer - Step 14: Enter First Character Blank space at value State field");
		newCustomerPage.inputToTextField("state", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message5"), "First character can not have space");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_15() {
		log.info("New Customer - Step 16: Do not enter at PIN field");
		newCustomerPage.inputToTextField("pinno", "132PIN");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "Characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_16() {
		log.info("New Customer - Step 15: Enter character value at PIN field");
		newCustomerPage.clickToFieldbox("pinno");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "PIN Code must not be blank");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_17() {
		log.info("New Customer - Step 17: Enter Number Less than 6 digit at PIN field");
		newCustomerPage.inputToTextField("pinno", "123");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "PIN Code must have 6 Digits");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_18() {
		log.info("New Customer - Step 18: Enter Special Character at PIN field");
		newCustomerPage.inputToTextField("pinno", "@#$F");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "Special characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_19() {
		log.info("New Customer - Step 19: Enter First Character Blank space at PIN field");
		newCustomerPage.inputToTextField("pinno", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "First character can not have space");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_20() {
		log.info("New Customer - Step 20: Enter Character Blank space at PIN field");
		newCustomerPage.inputToTextField("pinno", "812 31");
		verifyEquals(newCustomerPage.getErrorMessage("message6"), "Characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_21() {
		log.info("New Customer - Step 21: Do not enter at Phone field");
		newCustomerPage.clickToFieldbox("telephoneno");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "Mobile no must not be blank");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_22() {
		log.info("New Customer - Step 22: Enter First Character Blank space at Phone field");
		newCustomerPage.inputToTextField("telephoneno", " ");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "First character can not have space");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_23() {
		log.info("New Customer - Step 23: Enter Character Blank space at Phone field");
		newCustomerPage.inputToTextField("telephoneno", "123 123");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "Characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_24() {
		log.info("New Customer - Step 24: Enter Special Character at Phone field");
		newCustomerPage.inputToTextField("telephoneno", "2231@#$");
		verifyEquals(newCustomerPage.getErrorMessage("message7"), "Special characters are not allowed");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_25() {
		log.info("New Customer - Step 25: Do not enter value at Email field");
		newCustomerPage.clickToFieldbox("emailid");
		verifyEquals(newCustomerPage.getErrorMessage("message9"), "Email-ID must not be blank");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_26() {
		log.info("New Customer - Step 26: Enter Invalid email at Email field");
		newCustomerPage.inputToTextField("emailid", "guru99");
		verifyEquals(newCustomerPage.getErrorMessage("message9"), "Email-ID is not valid");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_27() {
		log.info("New Customer - Step 27: Enter Blank space at Email field");
		newCustomerPage.inputToTextField("emailid", "guru 99");
		verifyEquals(newCustomerPage.getErrorMessage("message9"), "Email-ID is not valid");
		newCustomerPage.reloadPage();
	}

	@Test
	public void New_Customer_Case_28() {
		log.info("New Customer - Step 28: Add New Customer");

		newCustomerPage.inputToTextField("name", customerName);

		newCustomerPage.inputToTextField("dob", dayofBirth);

		newCustomerPage.inputToAddressField(userData.getAddress());

		newCustomerPage.inputToTextField("city", userData.getCity());

		newCustomerPage.inputToTextField("state", userData.getState());

		newCustomerPage.inputToTextField("pinno", userData.getPIN());

		newCustomerPage.inputToTextField("telephoneno", userData.getPhone());

		newCustomerPage.inputToTextField("emailid", emailAddress);

		newCustomerPage.inputToTextField("password", userData.getPassword());

		newCustomerPage.clickToFieldbox("sub");

		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		log.info("New Customer - Step 29: Verify Info Registerd Successfully");

		verifyEquals(newCustomerPage.getSuccessMessage(), "Customer Registered Successfully!!!");

		verifyEquals(newCustomerPage.getInfoMationSuccess("Customer Name"), customerName);
		verifyEquals(newCustomerPage.getInfoMationSuccess("Birthdate"), dateofBirth);
		verifyEquals(newCustomerPage.getInfoMationSuccess("Address"), userData.getAddress());
		verifyEquals(newCustomerPage.getInfoMationSuccess("City"), userData.getCity());
		verifyEquals(newCustomerPage.getInfoMationSuccess("State"), userData.getState());
		verifyEquals(newCustomerPage.getInfoMationSuccess("Pin"), userData.getPIN());
		verifyEquals(newCustomerPage.getInfoMationSuccess("Mobile No."), userData.getPhone());
		verifyEquals(newCustomerPage.getInfoMationSuccess("Email"), emailAddress);
	}

	@Parameters({ "browser" })
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	UserDataMapper userData;
	String emailAddress, dayofBirth, customerName, dateofBirth;
	HomePageObject homePage;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPO newCustomerPage;

}
