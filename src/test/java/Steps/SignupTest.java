package Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import Utils.Utils;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import PageObjects.HomePage;
import PageObjects.SignupPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SignupTest {
	
	public static WebDriver driver;
	
	@Given("^User is on the sign in page$")
	public void user_is_on_the_sign_in_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","chromedriver");
	    driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage homepage = new HomePage(driver);
		homepage.load();
		homepage.navigateToSignIn();
	}

	@When("^Fill out the personal information form$")
	public void fill_out_the_personal_information_form() throws Throwable {
		Utils utils = new Utils();
		String emailaddress = utils.randomAlphaNumeric(7)+"@yopmail.com";
		LoginPage loginpage = new LoginPage(driver);
		SignupPage signuppage = new SignupPage(driver);
		signuppage.signUp(emailaddress,"testfirstname","testlastname","test address","Berlin","Alabama","1234567890","testtest","12345");
	}

	@Then("^My account page should be open$")
	public void my_account_page_should_be_open() throws Throwable {
		MyAccountPage myaccount = new MyAccountPage(driver);
		String expected_text = "MY ACCOUNT";
		String actual_text = myaccount.pageHeader();
	    Assert.assertEquals(expected_text,actual_text);
	    myaccount.signOut();
	    driver.quit();
	}
}
