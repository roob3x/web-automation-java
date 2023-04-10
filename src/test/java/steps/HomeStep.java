package steps;

import io.cucumber.java.es.Dado;
import pages.HomePage;
import utils.Screenshot;

import static support.Driver.driver;

public class HomeStep {
    HomePage homePage = new HomePage(driver);

    @Dado("realizo a consulta do produto {string}")
    public void consultaProduto(String product) throws InterruptedException {
        homePage.searchForProduct(product);
    }

}
