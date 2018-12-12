package TestCasePackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassPackage.BaseClass;
import PageClassPackage.HomePageClass;
import PageClassPackage.LoginPageClass;

public class HomePageTestCases extends BaseClass{
	
	
	public HomePageClass homepage;
	public LoginPageClass Loginpage;

	public HomePageTestCases() throws IOException {
		super();
		
	}
	
	
	
	@BeforeMethod 
	public void startup() throws IOException {
		
		
		intialization();
		homepage = new HomePageClass();
		Loginpage = new LoginPageClass();
	}

	
	@Test(enabled = true)
	public void verifyExistenceOfContactusLink() {
		
		boolean flag1 = homepage.validateExistenceOfContactusLink();
		Assert.assertTrue(flag1,"Not Present");
	
    }
	
	@Test(enabled = true)
	public void verifyContactusLinkClickable() {
		
		String title = homepage.validateContactusLinkClickable();
		Assert.assertEquals(title, "Contact us - My Store", "Eleement not clickable title not Matched");
	}
	
	@Test
	public void verifyloginpage() throws IOException {
		
        Loginpage = homepage.validatelogin();
	}
	
	
	@Test(enabled = true)
	public void verifyExistenceOfSigninLink() {
		
	    boolean flag = homepage.validateExistenceOfSigninLink();
		Assert.assertTrue(flag, "Not Present");
		
	}
	
	
	
	
	
	
	
	@AfterMethod 
    public void teardown() {
		driver.quit();
	}
	
	
	
}
