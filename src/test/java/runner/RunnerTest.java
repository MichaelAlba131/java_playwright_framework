package runner;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "steps"
)
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/cucumber/html, json:target/cucumber/report.json, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)

//@IncludeTags("TagDoCenarioDesejado")
//@ExcludeTags("TagDoCenarioNaoDesejado")
public class RunnerTest {
}