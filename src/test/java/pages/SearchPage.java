package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static By PRODUCT_LIST = By.id("listProductsShowcase");
    public static By PRODUCT_TITLE = By.xpath("//div[@class = 'product-title']//h1");
    public static By PRODUCT_NAME = By.xpath("//div[@class = 'product-code-brand']//a[2]//span");
    public static By PRODUCT_PRICE_NORMAL = By.xpath("//div[@class = 'product-top-price']//strong");
    public static By PRODUCT_PRICE_SUBSCRIBER = By.className("price-subscriber");
    public static By ADD_TO_CART_BTN = By.id("adicionarAoCarrinho");

    public void chooseThirdProduct() {
        WebElement el = find(PRODUCT_LIST);
        click_element_by_index(el, 2);
    }

    public void productValidate(Map<String, String> firstRow) {
        Assert.assertEquals(getTextByAttribute(PRODUCT_TITLE, "innerText"), firstRow.get("nomeProduto"));
        Assert.assertEquals(getText(PRODUCT_NAME), firstRow.get("fornecedor"));
        Assert.assertEquals(getText(PRODUCT_PRICE_NORMAL), firstRow.get("precoNormal"));
        Assert.assertEquals(getText(PRODUCT_PRICE_SUBSCRIBER), firstRow.get("precoAssianante"));
    }

    public void clickAddProductToCart() {
        moveToElement(ADD_TO_CART_BTN);
        click(ADD_TO_CART_BTN);
    }
}
