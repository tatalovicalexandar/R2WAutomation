package r2wautomation.base;

import r2wautomation.reports.ExtentReporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SeleniumUtils {
    protected static WebDriver driver;

    // Create an instance of WaitUtils
    protected WaitUtils waitUtils;
    protected String testName;
    protected Logger log;

    // Get the reference of ExtentReports object to instantiate HTML reporting
    public static ExtentReports report = ExtentReporting.getExtentReportInstance();

    // Indicate which test to include in report
    public static ExtentTest test;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun=true)
    public void setUp(@Optional("firefox") String browser, ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        this.testName = testName;
        log = LogManager.getLogger(testName);
        System.out.println("Test name: " + this.testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();
        driver.manage().window().maximize();

        waitUtils = new WaitUtils(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterEach() {
        // Close browser
        log.info("Close driver");
        if (driver != null) {
            driver.quit();
        }
    }
    public String getCurrentTestNameFromXml() {
        return this.testName;
    }
}
