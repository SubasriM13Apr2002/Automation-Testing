package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/main/java/FeatureFile/cucu.feature"},
	dryRun=true,
	glue = {"cucupackage"}
		)

public class FirstTest {

}
