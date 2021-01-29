package StepDefinations;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = { "StepDefinations" },

		monochrome = true, plugin = { "pretty", "html:target/HtmlReports/report.html" })

public class TestRunner {

}
