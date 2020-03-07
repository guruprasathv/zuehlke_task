package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
    public LoginPage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(how=How.ID, using="email")
    public static WebElement email;
    
    @FindBy(how=How.ID, using="passwd")
    public static WebElement password;
    
    @FindBy(how=How.ID, using="SubmitLogin")
    public static WebElement signin_button;
    
    @FindBy(how=How.CSS, using=".alert-danger li")
    public static WebElement error_message;
    
    @FindBy(how=How.CSS, using=".page-heading")
    public static WebElement page_header;
    
    
  //Set user name in email address textbox
    public void setUserName(String strUserName){
    	email.sendKeys(strUserName);     
    }
    
  //Clear email address field
    public void clearUsername(){
    	email.clear();
    }
    
  //Set password in password textbox
    public void setPassword(String strPassword){
    	password.sendKeys(strPassword);
    }
    
  //Clear password field
    public void clearPassword(){
    	password.clear();
    }
    
  //Click on login button
    public void clickLogin(){
    	signin_button.click();
    } 
    
  //Check the error message
    public String checkErrorMessage(){
    	return error_message.getText();
    } 
   
  //Check the error message
    public String pageHeader(){
    	return page_header.getText();
    } 
    
  //Login method
    public void login(String strUserName,String strPasword){
    	this.clearUsername();
        this.setUserName(strUserName);
        this.clearPassword();
        this.setPassword(strPasword);
        this.clickLogin();           
    }
}
