package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (plugin = {"pretty", "html:target/cucumber.html"},
        //snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"stepdefenitions", "hooks"},
        features = "./src/test/resources/features",
        tags = "scenario1 or scenario2",
        dryRun = false,
        monochrome = false

        )

public class JUnitRunnerTest {

}
