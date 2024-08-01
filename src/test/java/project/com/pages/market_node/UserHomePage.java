package project.com.pages.market_node;

import org.openqa.selenium.By;
import project.com.keywords.WebUI;

public class UserHomePage {
    By letsGoButton = By.xpath("//*[@id=\"root\"]/section/main/div/div/div[2]/button");

    public By getLetsGoButton() {
        return letsGoButton;
    }
}
