package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddtocartPage {
WebDriver driver;
	
    public AddtocartPage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(how=How.ID, using="email")
    public static WebElement email;
    
    @FindBy(how=How.CSS, using=".ajax_cart_no_product")
    public static WebElement empty_cart;
    
    @FindBy(how=How.ID, using="search_query_top")
    public static WebElement search_field;
    
    @FindBy(how=How.NAME, using="submit_search")
    public static WebElement search_submit;
    
    @FindBy(how=How.NAME, using="Submit")
    public static WebElement add_to_cart;
    
    @FindBy(how=How.CSS, using=".cart_description .product-name")
    public static WebElement product_name;
    
    @FindBy(how=How.CSS, using="[title='Proceed to checkout']")
    public static WebElement checkout;
    
    @FindBy(how=How.CSS, using=".product-image-container")
    public static WebElement product_container;
    
  //Check the message in the cart
    public String checkCartMessage(){
    	return empty_cart.getText();
    } 
    
  //Submit the search value
    public void searchSubmit(){
    	search_submit.click();
    } 
    
  //Clear the search field
    public void clearSearchField(){
    	search_field.clear();
    } 
    
  //Set value to the search field
    public void setSearchValue(String searchTerm){
    	search_field.sendKeys(searchTerm);     
    }
    
  //Add to cart button
    public void addToCart(){
    	add_to_cart.click();     
    }
    
  //Find product name
    public String findProductName(){
    	return product_name.getText();     
    }
    
  //Proceed to checkout
    public void checkout(){
    	checkout.click();    
    }
    
  //Search a product
    public void searchProduct(String searchTerm){
    	this.clearSearchField();
    	this.setSearchValue(searchTerm);
    	this.searchSubmit();
    }
    
  //View a product
    public void viewProduct(String productName){
    	driver.findElement(By.xpath("//img[@title='"+productName+"']")).click();
    }

}
