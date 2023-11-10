package R2WAutomation.Base;

import java.io.*;
import java.util.Date;
import org.openqa.selenium.OutputType;
import java.text.SimpleDateFormat;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtilities extends BaseTest  {
    public TestUtilities(WebDriver driver) {
        super();
        // TODO Auto-generated constructor stub
    }

    public static String takeScreenshot(String screenshotName) throws IOException {

        // Create a string variable which will be unique
        String dateFormat = new SimpleDateFormat("yyyyMMddhhss").format(new Date());

        // Create object variable of takeScreenshot class
        TakesScreenshot screenshot = (TakesScreenshot)driver;

        // Create file which contain the screenshot reference
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        // Capture the screenshot in path variable
        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + dateFormat + ".png";

        // New file object which contain destination path
        File destination = new File(path);

        // Save screenshot to desired location
        copyFileUsingStream(source, destination);

        return path;
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
