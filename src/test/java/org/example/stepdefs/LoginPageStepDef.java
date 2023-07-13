package org.example.stepdefs;

import cucumber.api.java.Before;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.manager.PageObjectManager;
import org.example.manager.StaticObjectManager;

import java.util.List;
import java.util.Map;

public class LoginPageStepDef {
    
    PageObjectManager pageObjectManager = new PageObjectManager();

    @Given("Launch the Application URL")
    public void launchTheApplicationURL() {
        pageObjectManager.getLoginAction().getApplication(pageObjectManager.getPropertiesUtility(StaticObjectManager.PROPERTIESFILEPATH).getProperty("ApplicationURL"));
        pageObjectManager.getExtendReporting().loggingInfoInReport("Launching Application");
    }

    @Given("The user enter below username and password in text box")
    public void theUserEnterBelowUsernameAndPasswordInTextBox(DataTable dataTable) {
        List<String> loginDetails = dataTable.row(0);
        pageObjectManager.getLoginAction().enterUsername(loginDetails.get(0));
        pageObjectManager.getExtendReporting().loggingInfoInReport("Entering Username");
        pageObjectManager.getLoginAction().enterPassword(loginDetails.get(1));
        pageObjectManager.getExtendReporting().loggingInfoInReport("Entering Password");
    }

    @When("The user click on Login button")
    public void theUserClickOnLoginButton() {
        pageObjectManager.getLoginAction().clickLoginButton();
        pageObjectManager.getExtendReporting().loggingInfoInReport("Clicking Login Button");
    }

    @Given("The user enter {string} username and {string} password in text box")
    public void theUserEnterUsernameAndPasswordInTextBox(String username, String password) {
        pageObjectManager.getLoginAction().enterUsername(username);
        pageObjectManager.getExtendReporting().loggingInfoInReport("Entering Username");
        pageObjectManager.getLoginAction().enterPassword(password);
        pageObjectManager.getExtendReporting().loggingInfoInReport("Entering Username");
    }

    @Given("Printing following data to concol")
    public void printingFollowingDataToConcol(DataTable dataTable) {
        List<Map<String,String>> table_map = dataTable.asMaps();
        System.out.println(table_map);
    }
}
