package org.example.CucumberRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features"} ,
        glue= {"org.example.StepDefinition"},
        plugin ={"pretty",
                "html:target/Cucumber.html",
                "json:target/Cucumber.json",
                "junit:target/Cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:target/parallel-threads",
                "rerun:target/failedRerun.txt"
        },
        dryRun = false,
        monochrome = true,
        tags="@smoke"
)

public class cucumberTestNGRunner extends AbstractTestNGCucumberTests {
        //overriding the @DataProvider method from AbstractTestNGclass
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}
