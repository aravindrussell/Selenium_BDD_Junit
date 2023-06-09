package org.example.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.action.LoginAction;

import java.awt.*;
import java.util.List;

public class LoginPageStepDef {

    LoginAction loginAction = new LoginAction();

    @Given("Launch the Application URL")
    public void launchTheApplicationURL() {
        loginAction.getApplication("https://opensource-demo.orangehrmlive.com/");
    }

    @Given("The user enter below username and password in text box")
    public void theUserEnterBelowUsernameAndPasswordInTextBox(DataTable dataTable) {
        List<String> loginDetails = dataTable.row(0);
        loginAction.enterUsername(loginDetails.get(0));
        loginAction.enterPassword(loginDetails.get(1));
    }

    @When("The user click on Login button")
    public void theUserClickOnLoginButton() {
        loginAction.clickLoginButton();
    }
}
