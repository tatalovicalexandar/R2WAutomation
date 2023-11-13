package r2wautomation.R2WSmokeTests.Merchant;

import org.testng.Assert;
import org.testng.annotations.Test;
import r2wautomation.base.SeleniumConfig;
import r2wautomation.base.SeleniumUtils;
import r2wautomation.pages.r2w.merchant.HomeForm;
import r2wautomation.pages.r2w.merchant.LoginForm;

public class MerchantLoginTests extends SeleniumUtils {
    SeleniumConfig config = SeleniumConfig.getInstance();
    @Test
    public void verifySuccessfulLoginActionOnLoginPage(){
        // Include test in test report
        test = report.createTest("Successful Login And Logout");
        log.info("Test verifySuccessfulLoginActionOnLoginPage has been created and added to the extent report");

        HomeForm homeForm = new HomeForm(driver, log);

        // Open Login Form page
        LoginForm loginPage = new LoginForm(driver, log);
        loginPage.openPage(config.getEnvironmentURL());

        //Login with valid user credentials
        loginPage.logIn("atatalovic+ma_replica@wolktest.local", "Test1234");

        waitUtils.waitForUrl("/#/facilities");
        // Verification: New URL
        Assert.assertEquals( loginPage.getCurrentUrl(), config.getEnvironmentURL().concat("/#/facilities"));

        homeForm.click(homeForm.logoutTopMenuItem);

        homeForm.click(homeForm.signoutButton);

        waitUtils.waitForUrl("/#/login");

        // Verification: New URL
        Assert.assertEquals( loginPage.getCurrentUrl(), config.getEnvironmentURL().concat("/#/login"));
        //Assert.assertEquals( loginPage.getCurrentUrl(), loginPage.getPageUrl().concat("/#/facilities"));
    }

    @Test
    public void verifyUnsuccessfullLoginActionOnLoginPage(){
        // Include test in test report
        test = report.createTest("Unsuccessful Login");
        log.info("Test verifyUnsuccessfullLoginActionOnLoginPage has been created and added to the extent report");

        // Open Login Form page
        LoginForm loginPage = new LoginForm(driver, log);
        loginPage.openPage(config.getEnvironmentURL());

        //Login with invalid user credentials
        loginPage.logIn("atatalovic+ma_replica@wolktest.local", "Qwer1234");

        // Wait for the web element to be loaded
        waitUtils.waitForElementPresence(loginPage.errorMessageLabel);

        // Verification: Element exist in HTML
        Assert.assertTrue(loginPage.elementExist(loginPage.errorMessageLabel));
        // Verification: Error message is displayed
        Assert.assertEquals(loginPage.find(loginPage.errorMessageLabel).getAttribute("innerText"), "There was an error during log in. Email address or password is not valid");
    }
}
