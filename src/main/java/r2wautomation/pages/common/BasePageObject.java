package r2wautomation.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import r2wautomation.base.SeleniumConfig;

public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;
    protected String environmentURL;

    SeleniumConfig config = SeleniumConfig.getInstance();
    //String environmentURL = config.getEnvironmentURL();

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        //this.environmentURL = config.getEnvironmentURL();
    }

    /** Open page with given URL */
    public void openUrl(String url) {
        driver.get(url);
    }

    /** Find element using given locator */
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Click on element with given locator when it's visible */
    public void click(By locator) {
        find(locator).click();
    }

    /** Check if element exist in HTML */
    public boolean elementExist(By locator) {
        return driver.findElements(locator).isEmpty() ? false : true;
    }

    /** Type given text into element with given locator */
    public void type(String text, By locator) {
        find(locator).sendKeys(text);
    }

    /** Get URL of current page from browser */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
