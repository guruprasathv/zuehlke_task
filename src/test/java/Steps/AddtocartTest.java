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
import cucumber.api.java.After;
import org.junit.Assert;

public class AddtocartTest {
	public static WebDriver driver;
	
	@Given("^User navigates to the home view$")
	public void user_navigates_to_the_home_view() throws Throwable {
		System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homepage = new HomePage(driver);
        homepage.load();
	}
	
	@Then("^Cart is empty$")
	public void check_the_cart() throws Throwable {
		String cartExpectedMessage = "(empty)";
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		String cartActualMessage = addTocartPage.checkCartMessage();
		Assert.assertEquals(cartExpectedMessage, cartActualMessage);
	}
	
	@When("^Search for a product")
	public void search_for_a_product_in_the_search_box() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.searchProduct("Faded Short Sleeve T-shirts");
	}
	
	@When("^User navigates to the product page$")
	public void user_navigates_to_the_product_page() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.viewProduct("Faded Short Sleeve T-shirts");
	}

	@Then("^Add the product to the cart$")
	public void add_the_product_to_the_cart() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.addToCart();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Then("^Product successfully added to the cart$")
	public void product_successfully_added_to_the_cart() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		String expected_product_name = "Faded Short Sleeve T-shirts";
		addTocartPage.checkout();
		String actual_product_name = addTocartPage.findProductName();
        Assert.assertEquals(expected_product_name,actual_product_name);
        driver.quit();
	}
}
