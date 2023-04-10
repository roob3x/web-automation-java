package steps;

import io.cucumber.java.*;
import support.Driver;
import org.apache.commons.io.FileUtils;
import utils.Filters;
import utils.Screenshot;

import java.io.File;
import java.io.IOException;

import static constants.Url.MAIN_URL;

public class ServiceHooks {
    Filters filter = new Filters();

    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        filter.removeDirectoryEvidence();
        Driver.getDriver().get(MAIN_URL);
    }

    @BeforeStep
    public void beforeStep() {
        Screenshot.takeScreenShot();
    }

    @After
    public void tearDown() throws InterruptedException {
        Driver.endSession();
    }

    @AfterStep
    public void afterStep() {
        Screenshot.takeScreenShot();
    }
}
