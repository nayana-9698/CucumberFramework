package org.example.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin ={"pretty",
                "html:target/Cucumber.html",
                "json:target/Cucumber.json",
                "junit:target/Cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:target/parallel-threads"

        },
        dryRun = false,
        monochrome = true,
        features = {"@target/failedRerun.txt"} ,
        glue= {"org.example.StepDefinition"},
        tags="@smoke"
)


public class failedRunner extends AbstractTestNGCucumberTests {
}
