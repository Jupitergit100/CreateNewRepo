package PageClassPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassPackage.BaseClass;

public class HomePageClass extends BaseClass{

	@FindBy(xpath = "//a[@title='Contact Us']")
	WebElement Contactus;
	
	@FindBy(className = "login")
	WebElement signin;
	
	
	
	
	public HomePageClass() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	

	public boolean validateExistenceOfContactusLink() {
		
		boolean flag = Contactus.isDisplayed();
		return flag;
	}
	
	public String validateContactusLinkClickable() {
		
		Contactus.click();
		String title = driver.getTitle();
		return title;
	}
	
	public LoginPageClass validatelogin() throws IOException {
		
		signin.click();
		return new LoginPageClass();
		
	}
	
	public ContactUsPageClass validateContactUsPage() throws IOException {
		
		Contactus.click();
		return new ContactUsPageClass();
	}
	
	
	public boolean validateExistenceOfSigninLink() {
		
		boolean flag = signin.isDisplayed();
		return flag;
		
	}
	
}
