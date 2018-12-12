package PageClassPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClassPackage.BaseClass;

     

public class ContactUsPageClass extends BaseClass {
	
	public Select sel;
	
	@FindBy(id="id_contact")
	WebElement dropdown;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath=".//*[@id='id_order']")
	WebElement OrderRef;
	
	@FindBy(id="fileUpload")
	WebElement fileupload;
	
	@FindBy(id="message")
	WebElement EnterMessage;
	
	@FindBy(id="submitMessage")
	WebElement submit;
	
	@FindBy(xpath = ".//*[@id='center_column']/div/ol/li")
	WebElement Error;

	public ContactUsPageClass() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

	public String validateSendMessage(String indx,String emails,String ref,String path,String message,String error ) {
		
		
		sel = new Select(dropdown);
		
    	sel.selectByIndex(Integer.parseInt(indx));
		
		Email.sendKeys(emails);
		OrderRef.sendKeys(ref);	
		fileupload.sendKeys(path);
	    EnterMessage.sendKeys(message);
	    submit.click();
	    return Error.getText();
	}
	
	
		
		
		
	}
	
	
	

