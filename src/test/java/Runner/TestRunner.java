package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src\\test\\java\\Features\\AddAndRemoveProduct.feature"},
        glue = {"StepDefinitions","Hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json", "junit:target/cucumber.xml"}
)

public class TestRunner {
}
