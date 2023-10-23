package testClasses;

import org.testng.ITestNGListener;
import org.testng.ITestResult;
import testbase.WebTestBase;
import utility.DriverUtility;

public class ITestListenerClass extends WebTestBase implements ITestNGListener {
    public void onTestFailure(ITestResult result){
        DriverUtility.captureScreenshot(result.getTestName()+".jpg");

    }
}
