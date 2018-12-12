package TestCasePackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClassPackage.BaseClass;
import PageClassPackage.ContactUsPageClass;
import PageClassPackage.HomePageClass;
import TestUtilPackage.TestUtilClass;

public class ContactUsPageTest extends BaseClass {

	
	public HomePageClass homepage;
	public ContactUsPageClass ContactUspage;
	
//	public Object[][] data;
	
	public ContactUsPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void startup() throws IOException {
		
		intialization();
		homepage = new HomePageClass();
		ContactUspage = homepage.validateContactUsPage();
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
		
		
	}
	
		
//		 data = new Object[3][6];
//		
//		data[0][0] = 1;
//		data[0][1] = "mailgmail.com";
//		data[0][2] = "hdhsdj";
//		data[0][3] = "C:\\Users\\Ali Hassan\\Desktop\\ExcelData.xlsx";
//		data[0][4] = "The system can enter the planned test phase. It is expected that the\r\n" + 
//				"tests will run without too many obstacles or problems.\r\n" + 
//				"The required products are available and their content is sufficient\r\n" + 
//				"The system is sufficiently stable and has enough functionality to\r\n" + 
//				"move on to the test phase";
//		data[0][5]= "Invalid email address.";
//		
//		
//		data[1][0] = 1;
//		data[1][1] = "biger@gmail.com";
//		data[1][2] = "";
//		data[1][3] = "C:\\Users\\Ali Hassan\\Desktop\\ExcelData.xlsx";
//		data[1][4] = "The system can enter the planned test phase. It is expected that the\r\n" + 
//				"tests will run without too many obstacles or problems.\r\n" + 
//				"The required products are available and their content is sufficient\r\n" + 
//				"The system is sufficiently stable and has enough functionality to\r\n" + 
//				"move on to the test phase";
//		 data[1][5]= "Bad file extension";
//		
//		
//		data[2][0] = 1;
//		data[2][1] = "biger@gmail.com";
//		data[2][2] = "hdhszxx";
//		data[2][3] = "C:\\Users\\Ali Hassan\\Desktop\\ExcelData.xlsx";
//		data[2][4] = "The system can enter the planned test phase. It is expected that the\r\n" + 
//				"tests will run without too many obstacles or problems.\r\n" + 
//				"The required products are available and their content is sufficient\r\n" + 
//				"The system is sufficiently stable and has enough functionality to\r\n" + 
//				"move on to the test phase";
//		data[2][5]= "Bad file extension";
//		
		
	@DataProvider
	public Object[][] getdata() throws IOException{
		
		Object data[][] = TestUtilClass.getTestData("Sheet1");
		return data;
	}
	
	
    @Test(dataProvider = "getdata")
    public void verifySendMessageTest(String ind, String email,String refer,String path,String message,String Exp_error) {
    	
              String Act_err =  ContactUspage.validateSendMessage(ind, email, refer,path,message,Exp_error);
    	        Assert.assertEquals(Act_err, Exp_error);
    }







    @AfterMethod 
    public void teardown() {
    
       driver.quit();
    	
    }
    
    
    
}