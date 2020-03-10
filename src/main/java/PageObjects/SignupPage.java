package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;	
import org.openqa.selenium.support.PageFactory;
import PageObjects.LoginPage;

public class SignupPage {
	WebDriver driver;
	
	public SignupPage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  @FindBy(how=How.ID, using="customer_firstname")
  private WebElement firstnameInput;

  @FindBy(how=How.ID, using="customer_lastname")
  private WebElement lastnameInput;

  @FindBy(how=How.ID, using="passwd")
  private WebElement passwordRegisterInput;

  @FindBy(how=How.ID, using="firstname")
  private WebElement firstnameAdressInput;

  @FindBy(how=How.ID, using="lastname")
  private WebElement lastnameAdressInput;

  @FindBy(how=How.ID, using="company")
  private WebElement companyInput;

  @FindBy(how=How.ID, using="address1")
  private WebElement adress1Input;

  @FindBy(how=How.ID, using="address2")
  private WebElement adress2Input;

  @FindBy(how=How.ID, using="city")
  private WebElement cityInput;

  @FindBy(how=How.ID, using="postcode")
  private WebElement postcodeInput;

  @FindBy(how=How.ID, using="other")
  private WebElement additionalInfoInput;

  @FindBy(how=How.ID, using="phone")
  private WebElement homePhoneInput;

  @FindBy(how=How.ID, using="phone_mobile")
  private WebElement mobilePhoneInput;

  @FindBy(how=How.ID, using="alias")
  private WebElement aliasInput;

  @FindBy(how=How.ID, using="submitAccount")
  private WebElement submitBtn;

  @FindBy(how=How.ID, using="days")
  private WebElement dayOfBirthSelect;

  @FindBy(how=How.ID, using="months")
  private WebElement monthOfBirthSelect;

  @FindBy(how=How.ID, using="years")
  private WebElement yearOfBirthSelect;

  @FindBy(how=How.ID, using="id_state")
  private WebElement stateSelect;
  
  @FindBy(how=How.NAME, using="email_create")
  public static WebElement emailid;
  
  public void emailIdField(String emailaddress) {
	  emailid.click();
	  emailid.sendKeys(emailaddress);
  }

  public void firstnameInputField(String firstname) {
    firstnameInput.sendKeys(firstname);
  }

  public void lastnameInput(String lastname) {
    lastnameInput.sendKeys(lastname);
  }

  public void passwordRegisterInput(String password) {
    passwordRegisterInput.sendKeys(password);
  }

  public void fistnameAdressInput(String fistnameAdress) {
    firstnameAdressInput.clear();
    firstnameAdressInput.sendKeys(fistnameAdress);
  }

  public void lastnameAdressInput(String lastnameAdress) {
    lastnameAdressInput.clear();
    lastnameAdressInput.sendKeys(lastnameAdress);
  }

  public void companyInput(String company) {
    companyInput.sendKeys(company);
  }

  public void adress1Input(String adress1) {
    adress1Input.sendKeys(adress1);
  }

  public void adress2Input(String adress2) {
    adress2Input.sendKeys(adress2);
  }

  public void cityInput(String city) {
    cityInput.sendKeys(city);
  }

  public void postcodeInput(String postcode) {
    postcodeInput.sendKeys(postcode);
  }

  public void additionalInfoInput(String info) {
    additionalInfoInput.sendKeys(info);
  }

  public void homePhoneInput(String phone) {
    homePhoneInput.sendKeys(phone);
  }

  public void mobilePhoneInput(String phone) {
    mobilePhoneInput.sendKeys(phone);
  }

  public void aliasInput(String alias) {
    aliasInput.clear();
    aliasInput.sendKeys(alias);
  }

  public void submitBtn() {
    submitBtn.click();
  }

  public void dayOfBirthSelect(String day) {
    new Select(dayOfBirthSelect).selectByValue(day);
  }

  public void monthOfBirthSelect(String month) {
    new Select(monthOfBirthSelect).selectByValue(month);
  }

  public void yearOfBirthSelect(String year) {
    new Select(yearOfBirthSelect).selectByValue(year);
  }

  public void stateSelect(String state) {
    Select states = new Select(stateSelect);
    states.selectByVisibleText(state);
  }
  
  public void signUp(String emailaddress,String firstname,String lastname,String address,String city,String state,String phone,String password, String zipcode) {
	LoginPage loginPage = new LoginPage(driver);
	this.emailIdField(emailaddress);
	loginPage.clickSignUp();
	this.firstnameInputField(firstname);
	this.lastnameInput(firstname);
	this.adress1Input(address);
	this.cityInput(city);
	this.postcodeInput(zipcode);
	this.stateSelect(state);
	this.homePhoneInput(phone);
	loginPage.setPassword(password);
	this.submitBtn();
  }

}