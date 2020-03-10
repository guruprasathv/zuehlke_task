package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.AddtocartPage;
import PageObjects.CartSummaryPage;
import Utils.Utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import org.junit.Assert;

public class CartSummaryTest {
	public static WebDriver driver;
	String productName = "Faded Short Sleeve T-shirts";
	String productName1 = "Printed Dress";
	@Given("^Add a single product to the cart$")
	public void add_a_single_product_to_the_cart() throws Throwable {
		System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homepage = new HomePage(driver);
        homepage.load();
        AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.searchProduct(productName);
		addTocartPage.viewProduct(productName);
		addTocartPage.addToCart();
		addTocartPage.checkout();
	}

	@Then("^Check the details in the cart summary$")
	public void check_the_details_in_the_cart_summary() throws Throwable {
		CartSummaryPage cartsummary = new CartSummaryPage(driver);
		Assert.assertEquals(16.51,cartsummary.getTotalProducts(),0);
		Assert.assertEquals(2.00,cartsummary.getTotalShipping(),0);
		Assert.assertEquals(18.51,cartsummary.getTotalPriceWithoutTax(),0);
		Assert.assertEquals(00.00,cartsummary.getTotalTax(),0);
		Assert.assertEquals(18.51,cartsummary.getTotalPrice(),0);
	}

	@Given("^Add multiple product to the cart$")
	public void add_multiple_product_to_the_cart() throws Throwable {
		AddtocartPage addTocartPage = new AddtocartPage(driver);
		addTocartPage.searchProduct(productName1);
		addTocartPage.viewProduct(productName1);
		addTocartPage.addToCart();
		addTocartPage.checkout();
	}

	@Then("^Check the products in the cart$")
	public void check_the_products_in_the_cart() throws Throwable {
		CartSummaryPage cartsummary = new CartSummaryPage(driver);
		Assert.assertTrue(cartsummary.ProductInCart(productName).isDisplayed());
		Assert.assertTrue(cartsummary.ProductInCart(productName1).isDisplayed());
		driver.quit();
	}
}
