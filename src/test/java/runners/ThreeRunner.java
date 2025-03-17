package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/report3.html",
                "json:target/cucumber-reports/cucumber3.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "step_definitions",
        stepNotifications = true,
        dryRun = false
        ,tags = "@US003 and @signIn"
//        ,tags = "@smoke and @US001"
)
public class ThreeRunner {
}
