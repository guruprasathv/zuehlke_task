package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage {
	
	WebDriver driver;
	
	public CartSummaryPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "total_product")
	public static WebElement totalProduct;
	
	@FindBy(how = How.ID, using = "total_shipping")
	public static WebElement totalShipping;

	@FindBy(how = How.ID, using = "total_price_without_tax")
	public static WebElement totalPriceWithoutTax;
	
	@FindBy(how = How.ID, using = "total_tax")
	public static WebElement totalTax;

	@FindBy(how = How.ID, using = "total_price")
	public static WebElement totalPrice;

	public double getTotalProducts() {
		return Double.parseDouble(totalProduct.getText().replace("$", ""));
	}	
	
	public double getTotalShipping() {
		return Double.parseDouble(totalShipping.getText().replace("$", ""));
	}	
	
	public double getTotalPriceWithoutTax() {
		return Double.parseDouble(totalPriceWithoutTax.getText().replace("$", ""));
	}	
	
	public double getTotalTax() {
		return Double.parseDouble(totalTax.getText().replace("$", ""));
	}	
	
	public double getTotalPrice() {
		return Double.parseDouble(totalPrice.getText().replace("$", ""));
	}	
	
	//Check the message in the cart
    public WebElement ProductInCart(String productName){
    	return driver.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(),'"+productName+"')]"));
    }  
    
}