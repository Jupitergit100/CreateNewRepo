package BaseClassPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import TestUtilPackage.EventListener;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	public EventListener eventlistener;
	public EventFiringWebDriver e_driver;
	
	
	public BaseClass() throws IOException {
		
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Ali Hassan\\newprojectHybirdApporch\\AutomationPractice\\src\\main\\java\\ConfigPackage\\Config.properties");
		
		prop.load(file);
		
		}
	
	public void intialization() throws IOException {
		String Browser = prop.getProperty("browser");
		if (Browser.equals("Chrome")) {
			System.getProperty("driver.chrome.chromedriver", "C:\\Users\\Ali Hassan\\newprojectHybirdApporch\\AutomationPractice\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (Browser.equals("FF")) {
			System.getProperty("driver.gecko.geckodriver", "C:\\Users\\Ali Hassan\\newprojectHybirdApporch\\AutomationPractice\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventlistener = new EventListener();
		
		e_driver.register(eventlistener);
		
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
		
	}
	
	
	

}
