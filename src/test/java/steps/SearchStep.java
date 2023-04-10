package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import pages.SearchPage;
import utils.Screenshot;

import java.util.List;
import java.util.Map;

import static support.Driver.driver;

public class SearchStep {
    SearchPage searchPage = new SearchPage(driver);

    @Quando("seleciono o terceiro produto da lista")
    public void selectThirdProduct() throws InterruptedException {
        searchPage.chooseThirdProduct();
    }

    @Entao("valido as informacoes do produto")
    public void productDetailValidate(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> firstRow = rows.get(0);
        searchPage.productValidate(firstRow);
    }

    @Quando("adiciono o produto ao carrinho")
    public void addProductToCart() throws InterruptedException {
        searchPage.clickAddProductToCart();
    }
}
