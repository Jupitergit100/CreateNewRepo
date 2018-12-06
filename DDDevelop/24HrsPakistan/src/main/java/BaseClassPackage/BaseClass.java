package BaseClassPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import TestUtilPackage.WebEventListener;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	public WebEventListener eventdriver;
	public EventFiringWebDriver e_driver;
	public BaseClass() throws IOException {
		
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Ali Hassan\\DDDevelop\\24HrsPakistan\\src\\main\\java\\ConfigurationPackage\\Config.properties");
		prop.load(file);
		
	}
	
	public void intialization() throws IOException {
	
		String URL = prop.getProperty("Browser");
		if (URL.equals("Chrome")) {
			System.setProperty("driver.chrome.chromedriver", "C:\\Users\\Ali Hassan\\DDDevelop\\24HrsPakistan\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (URL.equals("FF")) {
			System.setProperty("driver.gecko.geckodriver", "C:\\Users\\Ali Hassan\\DDDevelop\\24HrsPakistan\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		
		eventdriver = new WebEventListener();
		e_driver.register(eventdriver);
		
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	
	
	
	

}
