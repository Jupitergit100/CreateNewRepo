package PageClassesPackage;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import BaseClassPackage.BaseClass;

public class HomePageClass extends BaseClass{
	
		
	@FindBy(xpath="//img[@alt='Online Shopping: Pakistan’s Largest Deals Website | 24hours.pk']")
	WebElement hr24logo;
	
	@FindBy(className="user-login")
	WebElement login;
	
	@FindBy(className="user-register")
	WebElement register;
	
	@FindBy(xpath="//div[@class='call-us']")
	WebElement CallSupport;
	
	@FindBy(xpath=".//*[@id='st-container']/div/div[2]/div/div/header/div/div/div[4]/div/div[1]/div/p[2]/span")
	WebElement SupportNumber;
	
	@FindBy(className="dropdown-toggle")
	WebElement dropdowntoggle;

	@FindBy(xpath = ".//*[@id='st-container']/div/div[2]/div/div/header/div/div/div[4]/div/div[3]/div/div/ul/li[1]/a")
	WebElement SelectCity;
	
	@FindBy(xpath=".//*[@id='st-container']/div/div[2]/div/div/header/div/div/div[5]/nav/ul/li[2]/a")
	WebElement Homemenu;
	
	@FindBy(xpath = ".//*[@id='st-container']/div/div[2]/div/div/header/div/div/div[5]/nav/ul/li[3]/a")
	WebElement AboutUSmenu;
	
	@FindBy(id="Profile[firstname]")
	WebElement firstname;
	
	@FindBy(id="Profile[lastname]")
	WebElement lastname;
	
	@FindBy(id="Profile[email]")
	WebElement email;
	
	@FindBy(id="Profile[mobile]")
	WebElement mobile;
	
	@FindBy(id="Profile[address]")
	WebElement address;
	
	@FindBy(id="subscribe_city-selectized")
	WebElement city;
	
	@FindBy(className="btn btn-default")
	WebElement createAccount;
	
	public HomePageClass() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Action1
	public boolean validateLogoImage() {
		
		boolean logoImage = hr24logo.isDisplayed();
	    return logoImage;
	}

   //Action2
   public boolean validateLoginlink() {
	   
	   boolean loginLink = login.isDisplayed();
	   return loginLink;
   }

   //Action3
   public boolean validateregisterlink() {
	   
	   boolean registerlink = register.isDisplayed();
	   return registerlink;
	   }
    
   //Action4
   public boolean validateCallSupportText() {
	   
	   boolean callsupport = CallSupport.isDisplayed();
	   return callsupport;
   }

  //Action5
   public String validateSupportNumber() {
	   
	   String Actual =  SupportNumber.getText();
	   return Actual;
   }
   
   //Action6
   public String validateDropdowntext() {
	   
	   String Actual = dropdowntoggle.getText();
	   return Actual;
   }
 
   //Action6
   public String validateCityInDropdown() {
	   
	   dropdowntoggle.click();
	   SelectCity.click();
	   String Actual = dropdowntoggle.getText();
	   return Actual;
   }
 
   //Action7
   public String ValidateHomeMenuclick() {
	   
	   Homemenu.click();
	   String ActualTitle = driver.getTitle();
	   return ActualTitle;
   }
 //Action8
   public String ValidateAboutUsMenuclick() {
	   
	   AboutUSmenu.click();
	   String ActualTitle = driver.getTitle();
	   return ActualTitle;
   }

   
   
   
  //Action9
   public void validateRegisteringUser(String fname,String lname, String Email,String phone,String add) {
	
	   register.click();
	   firstname.sendKeys(fname);
	   lastname.sendKeys(lname);
	   email.sendKeys(Email);
	   mobile.sendKeys(phone);
	   address.sendKeys(add);
	  
	   
	   
	   
	   
   }
}

