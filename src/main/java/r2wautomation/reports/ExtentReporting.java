package r2wautomation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import r2wautomation.base.SeleniumConfig;

public class ExtentReporting {
    static SeleniumConfig config = SeleniumConfig.getInstance();

    // This is used to provide/add information to the HTML report
    public static ExtentReports extent;

    // Builds a new report using the spark template
    public static ExtentSparkReporter spark;

    public static ExtentReports getExtentReportInstance() {
        if(extent == null) {
            spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extent-report/extentReport.html");

            System.out.println(" Report name: " + config.getReportName());

            extent = new ExtentReports();

            // Attach report to extent object variable
            extent.attachReporter(spark);

            // Attach desired information to the report
            extent.setSystemInfo("Environment", config.getEnvironmentName());
            extent.setSystemInfo("Environment URL", config.getEnvironmentURL());
            extent.setSystemInfo("Web Browser", config.getBrowserName());
            extent.setSystemInfo("User Name", "Aleksandar Tatalovic");
            spark.config().setDocumentTitle(config.getReportName());
            spark.config().setTimelineEnabled(true);
            String time = spark.config().getTimeStampFormat();
            System.out.println("Time: " + time);

            // Name of the report
            spark.config().setReportName(config.getReportName());

            // Set Dark Theme
            spark.config().setTheme(Theme.DARK);
        }
        return extent;
    }
}
