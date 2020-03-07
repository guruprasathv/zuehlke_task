package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	private static String HOME_PAGE="http://automationpractice.com/index.php";
	
	@FindBy(linkText = "Sign in")
    public WebElement sign_in;
	
	//Open the homepage method
    public void load(){
    	driver.get(HOME_PAGE);
    }
    
  //Navigate to signInpage
    public void navigateToSignIn(){
    	sign_in.click();
    } 
}
