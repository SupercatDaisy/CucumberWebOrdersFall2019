package com.weborders.step_definitions;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("Test Setup");
    }

    @After()
    public void teardown(Scenario scenario){
        if(scenario.isFailed())
        {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver(ConfigurationReader.getProperty("browser"));
            // cucumber requires array of bytes for ss but test ng requires FILE
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach ss to report
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("Test Clean Up");
        Driver.closeDriver();
    }
}