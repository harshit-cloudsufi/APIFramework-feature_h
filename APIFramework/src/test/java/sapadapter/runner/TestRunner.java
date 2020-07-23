package sapadapter.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/features" },
        plugin = { "pretty", "html:target/cucumber-html-reports",
                "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt" }, monochrome = true,
        glue = {"sapadapter/stepDefinetions/"}
)
public class TestRunner {
//tags= {"@DeletePlace"}  compile test verify
}
