package runnerTest;

import org.junit.runner.RunWith;



	
	@RunWith(io.cucumber.junit.Cucumber.class)

	@io.cucumber.junit.CucumberOptions(monochrome = true, features = "src/test/resources/features",
	glue = {"StepsDefinition"},
	plugin = { "pretty","json:target/test-report.json","html:target/test-report.html", "junit:target/test-report.xml" })
	
	
	public class RunnerTest {
	
}
