package r2wautomation.pages.r2w.merchant;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import r2wautomation.pages.common.BasePageObject;

public class LoginForm extends BasePageObject {
    //private String pageUrl = "https://kaercher-replica.ready2wash.net";
    public static final By emailTextBox = By.id("input_1");
    public static final By passwordTextBox = By.id("input_2");
    public static final By logInButton = By.id("loginButton");
    public static final By forgotPasswordLink = By.id("forgotPasswordButton");
    public static final By languageDropDown = By.id("select_value_label_0");
    public static final By emailValidationLabel = By.xpath("//div[@ng-messages='loginForm.email.$error']");
    public static final By passwordLengthValidationLabel = By.xpath("//div[@ng-message='minlength']");
    public static final By passwordPatternValidationLabel = By.xpath("//div[@ng-message='pattern']']");

    public static final By errorMessageLabel = By.xpath("//p[@class='md-caption ng-binding']");

    public LoginForm(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Execute log in */
    public void logIn(String username, String password) {
        type(username, emailTextBox);
        type(password, passwordTextBox);
        click(logInButton);
    }

    /** Open Login Form Page with it's url */
    public void openPage(String pageUrl) { openUrl(pageUrl); }

    /** Get URL variable from PageObject */
    //public String getPageUrl() { return pageUrl; }
}
