package R2WAutomation.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {

    // This is used to provide/add information to the HTML report
    public static ExtentReports extent;

    // Builds a new report using the spark template
    public static ExtentSparkReporter spark;

    public static ExtentReports getExtentReportInstance() {
        if(extent == null) {
            spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/screenshots/extentReport.html");

            extent = new ExtentReports();

            // Attach report to extent object variable
            extent.attachReporter(spark);

            // Attach desired information to the report
            extent.setSystemInfo("Environment", "R2W Replica");
            extent.setSystemInfo("User Name", "Aleksandar Tatalovic");
            spark.config().setDocumentTitle("Extent Report Result");

            // Name of the report
            spark.config().setReportName("Ready2Wash Automation Testing");

            // Set Dark Theme
            spark.config().setTheme(Theme.DARK);
        }
        return extent;
    }
}
