package project.com.pages.market_node;

import org.openqa.selenium.By;
import project.com.constants.ConstantGlobal;
import project.com.driver.DriverManager;
import project.com.keywords.WebUI;

public class LoginPage {
    By emailInput = By.xpath("//*[@id=\"loginForm\"]/div/div/div[2]/div[1]/div/div/div/div/div/span/input");
    By passwordInput = By.xpath("//*[@id=\"loginForm\"]/div/div/div[2]/div[2]/div/div/div/div/div/span/input");
    By loginButton = By.xpath("//*[@id=\"loginForm\"]/div/div/div[2]/div[3]/div/div/div/div/button");
    By emailErrorMessage = By.xpath("//*[@id=\"loginForm_username_help\"]/div");
    By passwordErrorMessage = By.xpath("//*[@id=\"loginForm_password_help\"]/div");
    By invalidMessage = By.xpath("//*[@id=\"loginForm\"]/div/div/div[3]/div/div");

    public void openLoginPage(){
        WebUI.openURL(ConstantGlobal.URL+"login");
        new LoginPage();
    }

    public void setEmailInput(String emailInputStr) {
        WebUI.setText(emailInput ,emailInputStr);
    }

    public void setPasswordInput(String passwordInputStr) {
        WebUI.setText(passwordInput, passwordInputStr);
    }

    public void clickLoginButton() {
        WebUI.clickElement(loginButton, 10);
    }
    public String getEmailErrorMessage(){
        String emailErrorMessageStr = "";
        if(DriverManager.getDriver().findElement(emailErrorMessage).isDisplayed()){
            WebUI.getElementText(emailErrorMessage);
        }
        return emailErrorMessageStr;
    }

    public String getPasswordErrorMessage(){
        String passwordErrorMessageStr = "";
        if(DriverManager.getDriver().findElement(passwordErrorMessage).isDisplayed()){
            WebUI.getElementText(passwordErrorMessage);
        }
        return passwordErrorMessageStr;
    }

    public void verifyInvalidMessIsVisible(){
        WebUI.verifyElementVisible(invalidMessage);
    }
}
