package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver driver;
	
    public MyAccountPage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(how=How.CSS, using=".page-heading")
    public static WebElement pageHeader;
	
	 
    @FindBy(how=How.CSS, using="[title='Log me out']")
    public static WebElement signOut;
	
	//Check the error message
    public String pageHeader(){
    	return pageHeader.getText();
    } 
    
    //Click the signout button
    public void signOut(){
    	signOut.click();     
    }
}
