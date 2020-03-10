package Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import Utils.Utils;
import PageObjects.LoginPage;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginTest {
	public static WebDriver driver;
	
	@Given("^User navigates to the home page$")
	public void user_navigates_to_the_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","chromedriver");
	    driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homepage = new HomePage(driver);
        homepage.load();
	}

	@When("^user navigates to the Login Page$")
	public void user_navigates_to_the_Login_Page() throws Throwable {
		HomePage homepage = new HomePage(driver);
		homepage.navigateToSignIn();
	}
	
	@Then("^Check for the  'Forgot password' option$")
	public void check_for_the_Forgot_password_option() throws Throwable {
		LoginPage loginview = new LoginPage(driver);
		Assert.assertTrue(loginview.forgotPassword.isDisplayed());
		Assert.assertTrue(loginview.email.isDisplayed());
		Assert.assertTrue(loginview.password.isDisplayed());
		Assert.assertTrue(loginview.signupButton.isDisplayed());
	}
	
	@Given("^user donot enter any values in email and password field$")
	public void user_donot_enter_any_values_in_email_and_password_field() throws Throwable {
		LoginPage loginview = new LoginPage(driver);
		loginview.login("","");
	}

	@Then("^Error message is thrown for entering emaild address$")
	public void error_message_is_thrown_for_entering_emaild_address() throws Throwable {
		String expected_invalid_message = "An email address required.";
		LoginPage loginview = new LoginPage(driver);
		String actual_invalid_message = loginview.checkErrorMessage();
        Assert.assertEquals(expected_invalid_message,actual_invalid_message);
	}
	
	@When("^user enters invalid username and valid password$")
	public void user_enters_invalid_username_and_Password() throws Throwable {
		Utils utils = new Utils();
		String invalidname = utils.randomAlphaNumeric(7);
		LoginPage loginview = new LoginPage(driver);
		loginview.login(invalidname,"testtest");
	}
	
	@Then("^Error message is thrown for authentication failure$")
	public void error_message_is_thrown_for_authentication_failure() throws Throwable {
		String expected_invalid_message = "Invalid email address.";
		LoginPage loginview = new LoginPage(driver);
		String actual_invalid_message = loginview.checkErrorMessage();
        Assert.assertEquals(expected_invalid_message,actual_invalid_message);
	}
	
	@Given("^user enters invalid characters for email address field$")
	public void user_enters_invalid_characters_for_email_address_field() throws Throwable {
		LoginPage loginview = new LoginPage(driver);
		loginview.login("@#%$ˆ@gmail.com","testtest");
	}
	
	@Then("^Error message is thrown for invalid username$")
	public void error_message_is_thrown_for_invalid_username() throws Throwable {
		String expected_invalid_message = "Invalid email address.";
		LoginPage loginview = new LoginPage(driver);
		String actual_invalid_message = loginview.checkErrorMessage();
        Assert.assertEquals(expected_invalid_message,actual_invalid_message);
	}

	@Given("^user enters valid username and invalid Password$")
	public void user_enters_username_and_invalid_Password() throws Throwable {
		LoginPage loginview = new LoginPage(driver);
		loginview.login("personal1731@gmail.com","test");
	}
	
	@Then("^Error message is thrown for invalid password$")
	public void error_message_is_thrown_for_invalid_password() throws Throwable {
		String expected_invalid_message = "Invalid password.";
		LoginPage loginview = new LoginPage(driver);
		String actual_invalid_message = loginview.checkErrorMessage();
        Assert.assertEquals(expected_invalid_message,actual_invalid_message);
	}
	
	@Given("^user enters valid username and Password$")
	public void user_enters_valid_username_and_Password() throws Throwable {
		LoginPage loginview = new LoginPage(driver);
		loginview.login("personal1731@gmail.com","testtest");
	}
	
	@Then("^My account page is shown$")
	public void my_account_page_is_shown() throws Throwable {
		LoginPage loginview = new LoginPage(driver);
		MyAccountPage myaccount = new MyAccountPage(driver);
		String expected_text = "MY ACCOUNT";
		String actual_text = myaccount.pageHeader();
	    Assert.assertEquals(expected_text,actual_text); 
	    myaccount.signOut();
	    driver.quit();
	}

}
