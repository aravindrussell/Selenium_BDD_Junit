package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.manager.PageObjectManager;
import org.example.manager.StaticObjectManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"org.example.stepdefs","org.example.runner"},
        tags = "@New_Scenario",
        dryRun = false,
        monochrome = true,
        plugin = { "pretty","json:target/cucumber-json/cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"}
)

public class RunTest {

    private static final PageObjectManager pageObjectManager = new PageObjectManager();

    @BeforeClass
    public static void InitialTest() {
        StaticObjectManager.PROPERTIESFILEPATH = "./testData/config.properties";
        String reportFilePath = (pageObjectManager.getPropertiesUtility(StaticObjectManager.PROPERTIESFILEPATH).getProperty("ReportHomePath")
                + "Test_Run_"
                + pageObjectManager.getDateTimeUtility().getCurrentDateTime()).trim();
        pageObjectManager.getExtendReporting().initExtentReporting(reportFilePath,"Consolidated Report");
    }

    @AfterClass
    public static void TearDown() {
//        WebDriverUtility.webDriver.quit();
    }

}
