package R2WAutomation.Listeners;

import java.io.IOException;
import R2WAutomation.Base.BaseTest;
import R2WAutomation.Base.TestUtilities;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener extends BaseTest implements ITestListener{
    public TestListener() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            test.log(Status.FAIL, "Failed Test Case is: " + result.getName());
            test.addScreenCaptureFromPath(TestUtilities.takeScreenshot(result.getName()));
            test.log(Status.FAIL, result.getName() + " FAIL with error " + result.getThrowable());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(NullPointerException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        report.flush();
    }
}
