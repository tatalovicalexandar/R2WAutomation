package r2wautomation.pages.r2w.merchant;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import r2wautomation.pages.common.BasePageObject;

public class HomeForm  extends BasePageObject {
    public HomeForm(WebDriver driver, Logger log) {
        super(driver, log);
    }
    /** ========================================== Side Menu Locators ============================================== */
    public static final By hideAndShowSideMenuIcon = By.xpath("//md-icon[@class='noMargin cursorPointer']']");
    public static final By dashboardTechnologySideMenuItem = By.xpath("//md-list-item[@ui-sref='app.dashboardTechnology']");
    public static final By dailyFinanceOverviewSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.dashboardFinancial']");
    public static final By organizationSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.organization']");
    public static final By messagesSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.alarms']");
    public static final By reportsSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.reports']");
    public static final By cashlessSalesSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.cashlessSales']");
    public static final By userGroupsSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.userGroups']");
    public static final By loyaltySideMenuItem = By.xpath("//md-list-item[@ui-sref='app.loyalty']");
    public static final By periodicSummarySideMenuItem = By.xpath("//md-list-item[@ui-sref='app.periodicSummary']");
    public static final By vouchersSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.vouchers']");
    public static final By transactionsSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.transactions']");
    public static final By managingTokensSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.tokens']");
    public static final By pricingSideMenuItem = By.xpath("//md-list-item[@ui-sref='app.pricing']");

    /** =========================================== Top Menu Locators ============================================== */
    public static final By showSideMenuTopMenuItem = By.xpath("//div[@class='md-toolbar-tools']/child::button[1]");
    public static final By activeFeatureDescTopMenuItem = By.xpath("//div[@class='md-toolbar-tools']/child::ui-breadcrumbs //span");
    public static final By notificationTopMenuItem = By.xpath("//div[@class='md-toolbar-tools']/child::md-menu[1] //button");
    public static final By profileTopMenuItem = By.xpath("//div[@class='md-toolbar-tools']/child::md-menu[2]/child::button");
    public static final By profileMyAccountTopSubMenuItem = By.xpath("//div[@id[starts-with(.,'menu_container_')]][1] //md-menu-item[1]");
    public static final By profileAccountMgtTopSubMenuItem = By.xpath("//div[@id[starts-with(.,'menu_container_')]][1] //md-menu-item[2]");
    public static final By profileReleaseNotesTopSubMenuItem = By.xpath("//div[@id[starts-with(.,'menu_container_')]][1] //md-menu-item[3]");
    public static final By profileHelpTopSubMenuItem = By.xpath("//div[@id[starts-with(.,'menu_container_')]][1] //md-menu-item[4]");
    public static final By profileSignOutTopSubMenuItem = By.xpath("//div[@id[starts-with(.,'menu_container_')]][1] //md-menu-item[5]");
    public static final By logoutTopMenuItem = By.xpath("//div[@class='md-toolbar-tools']/child::button[2]");

    /** ====================================== User Sign Out Modal Dialog ========================================== */
    public static final By cancelButton = By.xpath("//md-dialog-actions //button[1]");
    public static final By signoutButton = By.xpath("//md-dialog-actions //button[2]");
    /** ============================================================================================================ */

}
