package TestUtilPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseClassPackage.BaseClass;

public class TestUtilClass extends BaseClass {

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public TestUtilClass() throws IOException {
		
		super();
	}


	
	

	public static Object[][] getTestData(String sheetName) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Ali Hassan\\newprojectHybirdApporch\\AutomationPractice\\src\\main\\java\\TestDataPackage\\ExcelData2.xlsx");
		
		book = WorkbookFactory.create(file);
		
		
		
		sheet  = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		
		for(int i=0; i<sheet.getLastRowNum();i++) {
			
			for (int k= 0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
			
			
		}
		return data;
	}
	
	public void takeScreenShots() throws IOException {
		
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String currentDir = System.getProperty("user.dir");
    	FileUtils.copyFile(scrfile, new File(currentDir +"\\ScreenShots\\"+ System.currentTimeMillis()+".png"));
		 
		
	}	

}
