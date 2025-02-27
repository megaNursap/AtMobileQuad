package step_defs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.factory.DriverFactory;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/jsonReports/cucumber.json", "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports"},
        features = {"src/test/resources"},
        glue = {"step_defs"},
        tags = "@test",
        monochrome = true)
public class RunCucumberTest {
    @BeforeClass
    public static void setUp() {
        DriverFactory.prepareChromeDriver();
    }

    @AfterClass
    public static void cleanUp() {
    }
}