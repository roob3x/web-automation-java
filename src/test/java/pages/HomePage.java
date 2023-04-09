package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static By INPUT_SEARCH = By.id("search");
    public static By BUTTON_SEARCH = By.className("button-search");
    public static By ACCEPT_COOKIES = By.id("onetrust-accept-btn-handler");

    public void searchForProduct(String text) {
        click(ACCEPT_COOKIES);
        send_keys(INPUT_SEARCH, text);
        click(BUTTON_SEARCH);
    }

}
