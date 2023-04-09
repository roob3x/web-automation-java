package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Entao;
import pages.CheckoutPage;

import java.util.List;
import java.util.Map;

import static support.Driver.driver;

public class CheckoutStep {

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Entao("valido que o detalhe do produto continua o mesmo")
    public void productDetailValidateCheckout(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> firstRow = rows.get(0);
        checkoutPage.productValidateCheckout(firstRow);
    }
}
