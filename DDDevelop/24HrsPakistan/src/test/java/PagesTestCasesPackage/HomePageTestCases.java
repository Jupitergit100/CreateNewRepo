package PagesTestCasesPackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassPackage.BaseClass;
import PageClassesPackage.HomePageClass;
import TestUtilPackage.TestUtil;



public class HomePageTestCases extends BaseClass {

	HomePageClass homepage;
	public JavascriptExecutor js;
	
	public HomePageTestCases() throws IOException {
		super();
		
	}
	
	
	@BeforeMethod 
	public void setup() throws IOException {
		
		intialization();
		homepage = new HomePageClass();
		
	}
	
	
	@Test(enabled = true)
	public void verifyLogoImage() {
		
		boolean flag = homepage.validateLogoImage();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(enabled = true)
	public void verifyLoginlink() {
		
		boolean flag = homepage.validateLoginlink();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(enabled = true)
	public void verifyRegisterlink() {
		
		boolean flag = homepage.validateregisterlink();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(enabled = true)
	public void verifyCallSupportText() {
		
		boolean flag = homepage.validateCallSupportText();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(enabled = true)
	public void verifySupportNumber() {
		
		String Actual = homepage.validateSupportNumber();
		AssertJUnit.assertEquals("0300-0372424", Actual);
	}
	
	@Test(enabled = true)
	public void verifyCountryTextIndropdown() {
		
		 String Actual = homepage.validateDropdowntext();
		 AssertJUnit.assertEquals("Pakitan", Actual);
	}
	
	@Test(enabled = true)
	public void verifyCityTextIndropdown() {
		String Actual = homepage.validateCityInDropdown();
		 AssertJUnit.assertEquals("Karchi", Actual);
	}
	
	@Test(enabled = true)
	public void verifyHomeMenuclick() {
		String ActualTitle = homepage.ValidateHomeMenuclick();
		AssertJUnit.assertEquals("Online Shopping in Pakistan: Buy Fashion, Electronics, Food & Services Deals | 24hours.pk", ActualTitle);
		
	}
	
	@Test(enabled = true)
	public void verifyAboutusMenuclick() {
		String ActualTitle = homepage.ValidateAboutUsMenuclick();
		AssertJUnit.assertEquals("About Us - 24Hours", ActualTitle);
		
	}
	
	@DataProvider
	public Object[][] getSignupdata() throws IOException {
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}
	
	
	@Test (dataProvider = "getSignupdata", description = "Enter the Signup data")
	public void verifyRegisteringUser(String fname,String lname,String Email,String phone,String add) {
		
		homepage.validateRegisteringUser(fname, lname, Email, phone, add);
		
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
