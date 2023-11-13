package r2wautomation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;
    SeleniumConfig config = new SeleniumConfig();
    private int timeout = Integer.parseInt(config.getTimeout());

    // Constructor to initialize the WebDriver and WebDriverWait
    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // Common wait method for element to be clickable
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Common wait method for presence of element
    public WebElement waitForElementPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Function to implement dynamic wait for URL
    public void waitForUrl(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }
}
