package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "steps",
        dryRun = false,
        tags = "",
        plugin = {
                "pretty",
                "html:target/htmlReports/cucumber-pretty.html",
                "json:target/jsonReports/report.json"
        }
)
public class Runner {
}
