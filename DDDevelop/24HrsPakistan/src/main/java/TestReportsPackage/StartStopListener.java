package TestReportsPackage;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class StartStopListener implements ISuiteListener{

	public void onFinish(ISuite arg0) {
		System.out.println("Test Suite Finished.......................................");
		
	}

	public void onStart(ISuite arg0) {
		System.out.println("Test Suite Starting.......................................");
		
	}

	

}
