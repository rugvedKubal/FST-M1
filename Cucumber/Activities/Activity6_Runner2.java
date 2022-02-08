package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features",
        glue = {"stepDefinitions"},
        tags = "@activity1_2",
        plugin = {"html: html-reports/test-reports.html"},
        monochrome = true
)
public class Activity6_Runner2 {
}
