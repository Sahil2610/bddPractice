package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/e2eTests",glue={"stepDefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports","json:target/cucumber.json" },
        tags = {"@e2e"}, monochrome = true
)
public class TestRunner {
}
