package r2wautomation.base;

import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import org.openqa.selenium.OutputType;
import java.text.SimpleDateFormat;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;

public class TestUtils extends SeleniumUtils {
    public TestUtils(WebDriver driver) {
        super();
    }
    public static String takeScreenshot(String screenshotName) throws IOException {

        // Create a string variable which will be unique
        String dateFormat = new SimpleDateFormat("yyyyMMddhhss").format(new Date());

        // Create object variable of takeScreenshot class
        TakesScreenshot screenshot = (TakesScreenshot)driver;

        // Create file which contain the screenshot reference
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        // Capture the screenshot in path variable
        String path = System.getProperty("user.dir") + "/test-output/extent-report/screenshots/" + screenshotName + dateFormat + ".png";

        // New file object which contain destination path
        File destination = new File(path);

        // Save screenshot to desired location
        Files.copy(new FileInputStream(source), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return path;
    }
}
