package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"/Cucumber-tutorial/resources/Features/DemoQA.feature"},
	dryRun=true,
	glue = {"stepDefinitions"}
		)
public class DemoQATest {

}
