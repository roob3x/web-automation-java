package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import support.Driver;

import static constants.Url.MAIN_URL;

public class ServiceHooks {

    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException {
        Driver.getDriver().get(MAIN_URL);
    }

    @After
    public void tearDown() throws InterruptedException {
        Driver.endSession();
    }
}
