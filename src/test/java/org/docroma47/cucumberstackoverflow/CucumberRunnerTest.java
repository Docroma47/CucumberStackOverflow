package org.docroma47.cucumberstackoverflow;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/org/docroma47/cucumberstackoverflow/feature"},
    glue = {"org.docroma47.cucumberstackoverflow.steps"},
    plugin = { "pretty", "json:./results/cucumber.json" }
)
public class CucumberRunnerTest {

}
