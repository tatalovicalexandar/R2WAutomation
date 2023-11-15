package r2wautomation.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriverFactory {
    SeleniumConfig config = SeleniumConfig.getInstance();
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }
    // Create ChromeOptions object
    ChromeOptions optionsChrome = new ChromeOptions();

    public WebDriver createDriver() {
        // Create Driver
        log.info("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                // Add option to start the browser maximized
                optionsChrome.addArguments("start-maximized");
                // Add the Headless argument
                if(config.getHeadlessDriver().equals("true")){
                    optionsChrome.addArguments("--headless");
                    log.info("Setting " + config.getBrowserName() + " WebDriver options to run in Headless mode");
                }
                driver.set(new ChromeDriver(optionsChrome));
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                // Create FirefoxOptions object
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                // Add the Headless argument
                if(config.getHeadlessDriver().equals("true")){
                    optionsFirefox.addArguments("--headless");
                    log.info("Setting " + config.getBrowserName() + " WebDriver options to run in Headless mode");
                }
                driver.set(new FirefoxDriver(optionsFirefox));
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                // Create EdgeOptions object
                EdgeOptions optionsEdge = new EdgeOptions();
                // Add option to start the browser maximized
                optionsEdge.addArguments("start-maximized");
                // Add the Headless argument
                if(config.getHeadlessDriver().equals("true")){
                    optionsEdge.addArguments("--headless");
                    log.info("Setting " + config.getBrowserName() + " WebDriver options to run in Headless mode");
                }
                driver.set(new EdgeDriver(optionsEdge));
                break;

            default:
                log.info("Do not know how to start: " + browser + ", starting default Chrome browser.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }
}
