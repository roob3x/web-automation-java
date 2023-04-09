package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static By  PRODUCT_NAME_CHECKOUT = By.xpath("//div[@data-testid = 'ptz-bag-product-description']");
    public static By  PRODUCT_PRICE_UNIT = By.xpath("//div[@data-testid = 'ptz-bag-product-unit-price']");
    public static By  PRODUCT_PRICE_AMOUNT = By.xpath("//div[@data-testid = 'ptz-bag-product-amount']");
    public static By  PRODUCT_PRICE_RESUME_SUBTOTAL = By.xpath("//div[@data-testid = 'ptz-bag-resume-subtotal']");
    public static By  PRODUCT_PRICE_RESUME_AMOUNT = By.xpath("//div[@data-testid = 'ptz-bag-resume-amount']");
    public static By IR_PAGAMENTO_BTN = By.xpath("/html/body/div[4]/section/div/div/div[2]/div/div[2]/div[5]/button");

    public void productValidateCheckout(Map<String, String> firstRow) {
        Assert.assertEquals(getTextByAttribute(PRODUCT_NAME_CHECKOUT, "innerText"), firstRow.get("nomeProduto"));
        Assert.assertEquals(getText(PRODUCT_PRICE_UNIT), firstRow.get("precoNormal"));
        Assert.assertEquals(getText(PRODUCT_PRICE_AMOUNT), firstRow.get("precoNormal"));
        Assert.assertEquals(getText(PRODUCT_PRICE_RESUME_SUBTOTAL), firstRow.get("precoNormal"));
        Assert.assertEquals(getText(PRODUCT_PRICE_RESUME_AMOUNT), firstRow.get("precoNormal"));
    }
}
