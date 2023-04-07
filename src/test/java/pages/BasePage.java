package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public WebDriverWait wait_for() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait;
    }

    public WebElement find(By locator) {
        WebElement element = wait_for().until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public void elementNotVisible(By locator) {
        wait_for().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public void click(By locator) {
        wait_for().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public void send_keys(By locator, String text) {
        wait_for().until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    public void handleWindow() {
        Set<String> janelas = driver.getWindowHandles();

        for (String janela : janelas) {
            if (!janela.equals(driver.getWindowHandle())) {
                driver.switchTo().window(janela);
                break;
            }
        }
    }
}
