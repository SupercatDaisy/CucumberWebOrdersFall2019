package com.weborders.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/weborders/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = false,
        tags = "@Test2",
        plugin= {
                "html:target/default-report"

        }
)
public class Runner {

}
