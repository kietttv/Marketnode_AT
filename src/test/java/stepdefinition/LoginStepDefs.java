package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.com.constants.ConstantGlobal;
import project.com.driver.DriverManager;
import project.com.hooks.TestContext;
import project.com.keywords.WebUI;
import project.com.pages.market_node.LoginPage;
import project.com.pages.market_node.TwoFactorAuthenticationPage;
import project.com.pages.market_node.UserHomePage;

public class LoginStepDefs {
    TestContext testContext;
    LoginPage loginPage;
    TwoFactorAuthenticationPage twoFactorAuthenticationPage;
    UserHomePage userHomePage;

    public LoginStepDefs(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getLoginPage();
        twoFactorAuthenticationPage = testContext.getTwoFactorAuthenticationPage();
        userHomePage = testContext.getUserHomePage();
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        loginPage.setEmailInput(ConstantGlobal.USERNAME);
        loginPage.setPasswordInput(ConstantGlobal.PASSWORD);
        loginPage.clickLoginButton();
    }

    @And("user enters two-factor authentication code")
    public void userEntersTwoFactorAuthenticationCode(){
        WebUI.waitForPageLoaded();
        twoFactorAuthenticationPage.enterAuthenticationCode(getAuthenticationCode());
        twoFactorAuthenticationPage.clickVerifyButton();
    }

    @Then("user should be redirected to the home page")
    public void userShouldBeRedirectedToTheHomePage() {
        try {
            WebUI.waitForElementPresent(userHomePage.getLetsGoButton());
            String expectedUrl = ConstantGlobal.URL + "home";
            WebUI.verifyEquals(DriverManager.getDriver().getCurrentUrl(), expectedUrl);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @And("home page should be displayed")
    public void homePageShouldBeDisplayed() {
        try {
            WebUI.verifyElementVisible(userHomePage.getLetsGoButton());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private String getAuthenticationCode(){
//        String authenticationCode = "";
//        implement logic to get authentication code
        return "123456";
    }

    @When("user enters invalid {string} and {string}")
    public void userEntersInvalidAnd(String email, String password) {
        loginPage.setEmailInput(email);
        loginPage.setPasswordInput(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should be still stay on login page")
    public void userShouldBeStillStayOnLoginPage() {
        try {
            String expectedUrl = ConstantGlobal.URL + "login";
            WebUI.verifyEquals(DriverManager.getDriver().getCurrentUrl(), expectedUrl);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @And("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        try {
            loginPage.verifyInvalidMessIsVisible();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
