package org.example.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.manager.PageObjectManager;
import org.example.manager.StaticObjectManager;
import org.example.utility.WebDriverUtility;

public class Hooks {

    private final PageObjectManager pageObjectManager = new PageObjectManager();

    @Before
    public void beforeSetup(Scenario scenario){
        pageObjectManager.getExtendReporting().createNewScenario(scenario.getName());
        WebDriverUtility.webDriver = pageObjectManager.getWebDriverUtility()
                .getWebDriver(pageObjectManager.getPropertiesUtility(StaticObjectManager.PROPERTIESFILEPATH).getProperty("BROWSER"));
    }

    @After
    public void afterTearDown(){
        WebDriverUtility.webDriver.quit();
    }
}
