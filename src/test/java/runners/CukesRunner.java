package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// @RunWith(Cucumber.class) -> tell that we run with Cucumber class
@RunWith(Cucumber.class)
// @CucumberOptions -> locate where, what, and how to run
@CucumberOptions(
        // plugin -> to create report.
        plugin = {
                "pretty", // "pretty" is the type/format of the report
                "html:target/report.html", // (html) type of file : location of the report generated
                "json:target/cucumber-reports/cucumber.json", // (json) type of file : location
                "rerun:target/rerun.txt"
        },
        // location of features file
        features = "src/test/resources/features",
        // glue -> tells where the step_definitions is located
        glue = "step_definitions",
        // stepNotifications -> shows steps in the box on the side. It is false by default.
        stepNotifications = true,
        // dryRun gives you option to look for undefined step definition that been written in feature file
        dryRun = true
        // tags -> run by tag (you can combine by using "and, or, and not"
        ,tags = "@US0201"
//        ,tags = "@smoke and @US001"
)
public class CukesRunner {
}
