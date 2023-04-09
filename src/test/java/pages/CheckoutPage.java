package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static By  PRODUCT_NAME_CHECKOUT = By.xpath("//div[@data-testid = 'ptz-bag-product-description']//div");
    public static By  PRODUCT_PRICE_UNIT = By.xpath("//div[@data-testid = 'ptz-bag-product-unit-price']");
    public static By  PRODUCT_PRICE_AMOUNT = By.xpath("//div[@data-testid = 'ptz-bag-product-amount']");
    public static By  PRODUCT_PRICE_RESUME_SUBTOTAL = By.xpath("//div[@data-testid = 'ptz-bag-resume-subtotal']");
    public static By  PRODUCT_PRICE_RESUME_AMOUNT = By.xpath("//div[@data-testid = 'ptz-bag-resume-amount']");
    public static By ID_MAIN = By.id("app");
    public void productValidateCheckout(Map<String, String> firstRow) throws InterruptedException {
        Thread.sleep(1000);
        WebElement el = find(ID_MAIN);
        Assert.assertEquals(el.findElement(PRODUCT_NAME_CHECKOUT).getAttribute("innerText"),
                firstRow.get("nomeProduto"));
        Assert.assertEquals("R$ "+el.findElement(PRODUCT_PRICE_UNIT).getAttribute("innerText"),
                firstRow.get("precoNormal"));
        Assert.assertEquals("R$ "+el.findElement(PRODUCT_PRICE_AMOUNT).getAttribute("innerText"),
                firstRow.get("precoNormal"));
        Assert.assertEquals("R$ "+el.findElement(PRODUCT_PRICE_RESUME_SUBTOTAL).getAttribute("innerText"),
                firstRow.get("precoNormal"));
        Assert.assertEquals("R$ "+el.findElement(PRODUCT_PRICE_RESUME_AMOUNT).getAttribute("innerText"),
                firstRow.get("precoNormal"));
    }
}
