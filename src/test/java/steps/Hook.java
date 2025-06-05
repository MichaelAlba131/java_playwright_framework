package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.driver.PlaywrightDriver;

public class Hook {
    @Before
    public void InitializeTest(Scenario scenario) {
        PlaywrightDriver.initialize();
    }

    @After
    public void finalizeTest(Scenario scenario) {
        PlaywrightDriver.close();
    }
}