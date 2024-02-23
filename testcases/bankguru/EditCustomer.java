package bankguru;

import java.util.Random;

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

public class EditCustomer extends BaseTest {
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

		homePage.inputToEmailToGetAccessDetails("abcx@gmail.com");
		loginPage = homePage.openLoginPage();
		managerPage = loginPage.loginToCustomerPage(userData.getLoginUsername(), userData.getLoginPassword());
		verifyEquals(managerPage.getHeadingTitle(), "Welcome To Manager's Page of Guru99 Bank");
	}

	@Test
	public void Edit_Customer() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}

	@Parameters({ "browser" })
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	HomePageObject homePage;
	UserDataMapper userData;
	String emailAddress;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPO newCustomerPage;

}
