package org.fetch.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.fetch.utilities.ConfigurationReader;
import org.fetch.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    @Before()
    public void setBaseURI() {                          //sets the base uri before every scenario
        System.out.println("----- Setting BaseURI");    //prints the test result after each scenario
        RestAssured.baseURI = ConfigurationReader.getProperty("fetch.baseURI");
    }

    @After()
    public void endScenario(Scenario scenario) {
        System.out.println("Test Result for " + scenario.getName() + " " + scenario.getStatus());
    }

    @Before("@ui")
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }
}
