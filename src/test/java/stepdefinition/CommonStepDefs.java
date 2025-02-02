package stepdefinition;

import io.cucumber.java.en.Given;
import org.testng.annotations.Listeners;
import project.com.constants.ConstantGlobal;
import project.com.hooks.TestContext;
import project.com.keywords.WebUI;
import project.com.listeners.ReportListener;
import project.com.pages.market_node.LoginPage;
import project.com.pages.market_node.TwoFactorAuthenticationPage;
import project.com.pages.market_node.UserHomePage;

@Listeners(ReportListener.class)
public class CommonStepDefs {
    TestContext testContext;
    LoginPage loginPage;
    TwoFactorAuthenticationPage twoFactorAuthenticationPage;
    UserHomePage userHomePage;

    public CommonStepDefs(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getLoginPage();
        twoFactorAuthenticationPage = testContext.getTwoFactorAuthenticationPage();
        userHomePage = testContext.getUserHomePage();
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.openLoginPage();
    }
}
