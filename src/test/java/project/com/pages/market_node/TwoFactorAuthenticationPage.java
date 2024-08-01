package project.com.pages.market_node;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.com.driver.DriverManager;
import project.com.keywords.WebUI;

import java.util.List;

public class TwoFactorAuthenticationPage {
    By authCodeInputs = By.cssSelector(".lib-code-inputs .ant-input");
//    By authCodeInputs = By.xpath("//*[@id=\"verificationCode\"]/div/div[4]/div/div/div/div/div/div/div/input");
    By verifyButton = By.xpath("//*[@id=\"verificationCode\"]/div/div[7]/div/div/div/div/button");

    public void enterAuthenticationCode(String code) {
        WebUI.set2FAText(authCodeInputs, code);
    }

    public void clickVerifyButton(){
        WebUI.clickElement(verifyButton, 10);
    }
}
