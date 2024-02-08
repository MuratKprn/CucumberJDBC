package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

public class OuterRunner {

        final String tags = "@Query02 or @Query03";

        @CucumberOptions(
                plugin = {
                        "html:target/reports/" + tags + "-report.html",
                        "json:target/json-reports/cucumber.json",
                        "junit:target/xml-report/cucumber.xml",
                        "rerun:target/failedRerun.txt"
                },
                features = "src/test/Resources",
                glue = {"StepDefinitions"},
                tags = tags,
                dryRun = false
        )

        public class Runner {}

}




