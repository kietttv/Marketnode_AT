package project.com.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import project.com.driver.DriverFactory;
import project.com.driver.DriverManager;
import project.com.pages.market_node.LoginPage;
import project.com.pages.market_node.TwoFactorAuthenticationPage;
import project.com.pages.market_node.UserHomePage;
import project.com.utils.LogUtils;

public class TestContext {
    private LoginPage loginPage;
    private TwoFactorAuthenticationPage twoFactorAuthenticationPage;
    private UserHomePage userHomePage;

    public TestContext() {
        ThreadGuard.protect(new DriverFactory().createDriver("chrome"));
        LogUtils.info("Driver in TestContext: " + getDriver());
    }

    public LoginPage getLoginPage() {
        if (loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public TwoFactorAuthenticationPage getTwoFactorAuthenticationPage() {
        if (twoFactorAuthenticationPage == null){
            twoFactorAuthenticationPage = new TwoFactorAuthenticationPage();
        }
        return twoFactorAuthenticationPage;
    }

    public UserHomePage getUserHomePage() {
        if(userHomePage == null){
            userHomePage = new UserHomePage();
        }
        return userHomePage;
    }

    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }
}
