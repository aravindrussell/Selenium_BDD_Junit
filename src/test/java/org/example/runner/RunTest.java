package org.example.runner;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.utility.WebDriverUtility;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "org.example.stepdefs",
        tags = ""
)

public class RunTest {

    public static WebDriverUtility webDriverUtility = new WebDriverUtility();

    @BeforeClass
    public static void InitialTest(){
        WebDriverUtility.webDriver = webDriverUtility.getWebDriver("CHROME");
    }

    @AfterClass
    public static void TearDown(){
        WebDriverUtility.webDriver.quit();
    }

}
