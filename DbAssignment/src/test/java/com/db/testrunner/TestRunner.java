package com.db.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\db\\features\\", glue = "com.db.step_def", plugin = { "pretty",
		"html:test-output", "json:target/json_output/cucumber.json",
		"junit:junit_xml/cucumber.xml" }, monochrome = true, tags = "", strict = true, dryRun = false)
public class TestRunner {

}
