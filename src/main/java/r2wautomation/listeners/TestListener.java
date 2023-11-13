package r2wautomation.listeners;

import java.io.IOException;
import r2wautomation.base.SeleniumUtils;
import r2wautomation.base.TestUtils;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener extends SeleniumUtils implements ITestListener{
    public TestListener() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            test.log(Status.FAIL, "Failed Test Case is: " + result.getName());
            test.addScreenCaptureFromPath(TestUtils.takeScreenshot(result.getName()));
            test.log(Status.FAIL, result.getName() + " FAIL with error " + result.getThrowable());
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
        }
        report.flush();
    }
    @Override
    public void onTestSuccess(ITestResult result){
        try {
            test.log(Status.PASS, "Test Case: " + result.getName() + " finished successfully");
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        report.flush();
    }
    @Override
    public void onTestSkipped(ITestResult result){
        try {
            test.log(Status.SKIP, "Test Case: " + result.getName() + " has been skipped");
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        report.flush();
    }
}
