package Steps;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.AddtocartPage;
import PageObjects.SignupPage;
import Utils.Utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SignupAddtoCart {
	public static WebDriver driver;
	
	@Given("^Signup as a new user and navigate to account page$")
	public void signup_as_a_new_user_and_navigate_to_account_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","chromedriver");
	    driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage homepage = new HomePage(driver);
		homepage.load();
		homepage.navigateToSignIn();
		Utils utils = new Utils();
		String emailaddress = utils.randomAlphaNumeric(7)+"@yopmail.com";
		SignupPage signUpPage = new SignupPage(driver);
		signUpPage.signUp(emailaddress,"testfirstname","testlastname","test address","Berlin","Alabama","1234567890","testtest","12345");
	}

	@When("^Search for a new product$")
	public void search_for_a_new_product() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.searchProduct("Printed Dress");
	}

	@When("^User should navigate to the product page$")
	public void user_should_navigate_to_the_product_page() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.viewProduct("Printed Dress");
	}

	@When("^Add a new product to the cart$")
	public void add_a_new_product_to_the_cart() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.addToCart();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Then("^Product is successfully added to the cart$")
	public void product_is_successfully_added_to_the_cart() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		String expected_product_name = "Printed Dress";
		addTocartPage.checkout();
		String actual_product_name = addTocartPage.findProductName();
        Assert.assertEquals(expected_product_name,actual_product_name);
        driver.quit();
	}
}
