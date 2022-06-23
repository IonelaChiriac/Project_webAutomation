package webAutomation.Elearning.unitbv.Base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ExtentTestNGReportBuilder extends Base_class{
	
		
	 @AfterMethod
	    public synchronized void afterMethodPost(ITestResult result) {

	        if (result.getStatus() == ITestResult.FAILURE)
	            test.fail(result.getTestName());
	        else if (result.getStatus() == ITestResult.SKIP)
	            test.skip(result.getThrowable());
	        else
	            test.pass("Test passed");

	        
	    
}
}