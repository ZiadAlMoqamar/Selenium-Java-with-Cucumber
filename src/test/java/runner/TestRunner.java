package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}
        ,glue = {"stepsdefinition"}
        ,monochrome = true
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,plugin = {"pretty","html:target/report/report.html"}
)
public class TestRunner {
}